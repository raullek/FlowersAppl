package com.example.flowersapplication.ui.flowersList;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.flowersapplication.local.LocalDataSource;
import com.example.flowersapplication.local.entities.FlowerEntity;
import com.example.flowersapplication.remote.RemoteDataSource;
import com.example.flowersapplication.remote.model.Flowers;
import com.example.flowersapplication.ui.base.BasePresenter;
import com.example.flowersapplication.utils.NetworkUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import rx.Observer;

public class FlowersPresenter extends BasePresenter<ContractFlowers.ContractView> implements ContractFlowers.ContractPresenter  {
    private static final String TAG = "FlowersPresenter";
    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;

    public FlowersPresenter(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;

    }


    @Override
    public void getFlowers(Context context) {
        if (NetworkUtil.isNetworkConnected(context))
            getFlowersFromApi();
        else getFlowersFromDb();

    }

    @Override
    public void getFlowersFromApi() {

        getView().showLoading();

        mDisposable = remoteDataSource.getFlowersFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((List<FlowerEntity> response) ->{
                    if (!isViewAttached())
                        return;

                    getView().hideLoading();
                    saveFlowers(response);
                    getView().onFlowersReady(response);

                },throwable -> {
                    getView().hideLoading();
                    Log.e(TAG, throwable.getMessage());
                        });



    }


    @Override
    public void getFlowersFromDb() {
        getView().showLoading();

        localDataSource.getFlowerDao().getFlowersFromDb()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((List<FlowerEntity> response) -> {

                    if (isViewAttached())
                        return;
                    getView().hideLoading();
                    getView().onFlowersReady(response);


                },
                        throwable -> {
                            getView().hideLoading();
                            Log.e(TAG, throwable.getMessage() );
                        });

    }

    @Override
    public void saveFlowers(List<FlowerEntity> items) {

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                localDataSource.getFlowerDao().deleteFlowers();
                localDataSource.getFlowerDao().saveArticles(items);
                return null;
            }
        }.execute();

    }


    }


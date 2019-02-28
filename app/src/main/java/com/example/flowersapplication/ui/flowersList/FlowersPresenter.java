package com.example.flowersapplication.ui.flowersList;

import android.content.Context;

import com.example.flowersapplication.local.LocalDataSource;
import com.example.flowersapplication.local.entities.FlowerEntity;
import com.example.flowersapplication.remote.RemoteDataSource;
import com.example.flowersapplication.ui.base.BasePresenter;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Observer;
import rx.schedulers.Schedulers;

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

    }

    @Override
    public void getFlowersFromApi() {
        getView().showLoading();









    }

    @Override
    public void getFlowersFromDb() {

    }

    @Override
    public void saveFlowers(List<FlowerEntity> items) {

    }
}

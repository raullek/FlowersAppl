package com.example.flowersapplication.remote;

import com.example.flowersapplication.local.entities.FlowerEntity;
import com.example.flowersapplication.remote.model.Flowers;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public class RemoteDataSource {
    private static final String TAG = "RemoteDataSource";

    FlowersService mFlowersService;

    public RemoteDataSource(FlowersService mFlowersService) {
        this.mFlowersService = mFlowersService;
    }

    public Flowable<List<FlowerEntity>> getFlowersFromApi (){
        return mFlowersService.getFlowersFromApi();
    }

}

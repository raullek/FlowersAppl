package com.example.flowersapplication.di.module;

import com.example.flowersapplication.di.scope.ActivityScope;
import com.example.flowersapplication.local.LocalDataSource;
import com.example.flowersapplication.remote.RemoteDataSource;
import com.example.flowersapplication.ui.flowersList.FlowersPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class FlowersModule {

    @Provides
    @ActivityScope
    public FlowersPresenter provideFlowersPresenter (LocalDataSource localDataSource, RemoteDataSource remoteDataSource)
    {
        return new FlowersPresenter(remoteDataSource,localDataSource);
    }



}

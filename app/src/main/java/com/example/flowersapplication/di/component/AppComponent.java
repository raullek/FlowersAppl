package com.example.flowersapplication.di.component;

import com.example.flowersapplication.di.module.ApplicationModule;
import com.example.flowersapplication.local.LocalDataSource;
import com.example.flowersapplication.remote.RemoteDataSource;

import dagger.Component;

@Component (modules = ApplicationModule.class)
public interface AppComponent {

    LocalDataSource roomDataSource();

    RemoteDataSource remoteDataSouce();
}

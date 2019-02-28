package com.example.flowersapplication.di.component;

import com.example.flowersapplication.di.module.ApplicationModule;
import com.example.flowersapplication.di.scope.ActivityScope;
import com.example.flowersapplication.di.scope.ApplicationScope;
import com.example.flowersapplication.local.LocalDataSource;
import com.example.flowersapplication.remote.RemoteDataSource;

import dagger.Component;

@ApplicationScope
@Component (modules = ApplicationModule.class)
public interface AppComponent {

    LocalDataSource roomDataSource();

    RemoteDataSource remoteDataSouce();
}

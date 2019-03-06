package com.example.flowersapplication;

import android.app.Application;

import com.example.flowersapplication.di.component.AppComponent;
import com.example.flowersapplication.di.component.DaggerAppComponent;
import com.example.flowersapplication.di.module.ApplicationModule;

public class FlowersApp extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }
    public static   AppComponent getAppComponent (){
        return appComponent;
    }


}

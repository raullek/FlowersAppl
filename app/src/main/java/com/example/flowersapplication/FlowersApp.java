package com.example.flowersapplication;

import android.app.Application;

import com.example.flowersapplication.di.component.AppComponent;

public class FlowersApp extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


    }


}

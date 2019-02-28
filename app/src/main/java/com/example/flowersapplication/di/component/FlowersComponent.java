package com.example.flowersapplication.di.component;

import com.example.flowersapplication.di.module.FlowersModule;
import com.example.flowersapplication.di.scope.ActivityScope;
import com.example.flowersapplication.ui.flowersList.FlowersActivity;

import dagger.Component;
@ActivityScope
@Component(dependencies = {AppComponent.class},modules = {FlowersModule.class})
public interface FlowersComponent {
    void inject (FlowersActivity flowersActivity);
}

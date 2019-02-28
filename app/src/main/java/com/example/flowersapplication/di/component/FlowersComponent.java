package com.example.flowersapplication.di.component;

import com.example.flowersapplication.di.module.FlowersModule;

import dagger.Component;

@Component(dependencies = {AppComponent.class},modules = {FlowersModule.class})
public interface FlowersComponent {
}

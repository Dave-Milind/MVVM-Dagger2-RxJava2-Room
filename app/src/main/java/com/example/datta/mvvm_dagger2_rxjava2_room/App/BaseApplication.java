package com.example.datta.mvvm_dagger2_rxjava2_room.App;

import android.app.Application;

import com.example.datta.mvvm_dagger2_rxjava2_room.di.Component.AppComponent;
import com.example.datta.mvvm_dagger2_rxjava2_room.di.Component.DaggerAppComponent;
import com.example.datta.mvvm_dagger2_rxjava2_room.di.Modules.AppModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends Application {

 public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();


    }


}

package com.example.datta.mvvm_dagger2_rxjava2_room;

import android.app.Application;

import com.example.datta.mvvm_dagger2_rxjava2_room.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

    }
}

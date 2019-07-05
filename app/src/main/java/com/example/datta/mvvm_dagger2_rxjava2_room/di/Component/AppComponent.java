package com.example.datta.mvvm_dagger2_rxjava2_room.di.Component;


import com.example.datta.mvvm_dagger2_rxjava2_room.Network.WebService;
import com.example.datta.mvvm_dagger2_rxjava2_room.di.Modules.AppModule;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {


    WebService getWebService();


}

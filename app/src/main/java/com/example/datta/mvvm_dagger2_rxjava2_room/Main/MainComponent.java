package com.example.datta.mvvm_dagger2_rxjava2_room.Main;


import com.example.datta.mvvm_dagger2_rxjava2_room.Model.Office;

import dagger.Component;

@Component
public interface MainComponent {

    Office getOffice();

    void inject(MainActivity mainActivity);
}

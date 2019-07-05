package com.example.datta.mvvm_dagger2_rxjava2_room.Network;

import com.example.datta.mvvm_dagger2_rxjava2_room.Model.User;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface WebService {

    @GET("users")
    io.reactivex.Observable<List<User>> getUsers();



}

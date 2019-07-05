package com.example.datta.mvvm_dagger2_rxjava2_room.di.Modules;


import android.util.Log;

import com.example.datta.mvvm_dagger2_rxjava2_room.Network.WebService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

    @Provides
    WebService getWebService(Retrofit retrofit) {

        return retrofit.create(WebService.class);

    }


    @Provides
    Retrofit getRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();


    }


    @Provides
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor);


        return builder.build();


    }


    @Provides
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

                Log.i("okhttp", message);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }


}

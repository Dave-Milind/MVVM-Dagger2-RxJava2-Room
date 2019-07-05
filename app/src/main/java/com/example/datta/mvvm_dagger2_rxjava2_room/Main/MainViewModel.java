package com.example.datta.mvvm_dagger2_rxjava2_room.Main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.datta.mvvm_dagger2_rxjava2_room.App.BaseApplication;
import com.example.datta.mvvm_dagger2_rxjava2_room.Model.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    String TAG = "MainTag";

    public MutableLiveData<List<User>> getUsersLiveData() {
        return usersLiveData;
    }

    MutableLiveData<List<User>> usersLiveData = new MutableLiveData<List<User>>();

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    void getUsers() {

        BaseApplication.appComponent.getWebService().getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        compositeDisposable.add(d);

                    }

                    @Override
                    public void onNext(List<User> users) {

                        usersLiveData.setValue(users);

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("oo", e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}

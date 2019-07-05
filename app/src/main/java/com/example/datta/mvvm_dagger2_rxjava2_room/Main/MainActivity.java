package com.example.datta.mvvm_dagger2_rxjava2_room.Main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.datta.mvvm_dagger2_rxjava2_room.App.BaseApplication;
import com.example.datta.mvvm_dagger2_rxjava2_room.Model.Office;
import com.example.datta.mvvm_dagger2_rxjava2_room.Model.User;
import com.example.datta.mvvm_dagger2_rxjava2_room.R;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    MainComponent mainComponent;

    @Inject
    Office office;

    LinearLayout linearLayoutMain;

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    void init() {
        mainComponent = DaggerMainComponent.create();
        mainComponent.inject(this);
        linearLayoutMain = findViewById(R.id.ll_mainactivity);
        office.doSomeOfficeWork();

        mainViewModel = new MainViewModel();

        mainViewModel.getUsersLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {


                for (User user : users) {

                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(user.getEmail());
                    linearLayoutMain.addView(textView);

                }
            }
        });

        mainViewModel.getUsers();

    }


}

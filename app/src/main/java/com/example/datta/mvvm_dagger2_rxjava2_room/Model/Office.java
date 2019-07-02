package com.example.datta.mvvm_dagger2_rxjava2_room.Model;

import android.util.Log;

import javax.inject.Inject;

public class Office {

    String TAG="officeTag";
    Employee employee;

    Finance finance;

    @Inject
    Office(Employee employee, Finance finance) {
        this.employee = employee;
        this.finance = finance;
    }

   public void doSomeOfficeWork() {

        if (employee != null && finance != null) {

            Log.e(TAG, "Office work started..");

        }


    }

}

package com.tuan.googlemapproject.interactor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;
import android.support.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.tuan.googlemapproject.R;
import com.tuan.googlemapproject.presenter.IPresenter;

public class MyLocationInteractor {

    private IPresenter.MyLocationPresenterListener myLocationPresenterListener;

    public MyLocationInteractor(IPresenter.MyLocationPresenterListener myLocationPresenterListener) {
        this.myLocationPresenterListener = myLocationPresenterListener;
    }

    @SuppressLint("MissingPermission")
    public void getDeviceLocation(final Activity activity, FusedLocationProviderClient fusedLocationProviderClient) {
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(activity, new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful()) {
                    myLocationPresenterListener.responseSuccess(task.getResult());
                } else {
                    myLocationPresenterListener.responseFailure(activity.getString(R.string.failed));
                }
            }
        });
    }
}
package com.tuan.googlemapproject.presenter;

import android.app.Activity;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.tuan.googlemapproject.interactor.MyLocationInteractor;
import com.tuan.googlemapproject.view.IView;

public class MyLocationPresenter implements IPresenter.MyLocationPresenterListener {

    private MyLocationInteractor myLocationInteractor;
    private IView.MyLocationViewListener myLocationViewListener;

    public void responseMyLocationViewListener(IView.MyLocationViewListener myLocationViewListener) {
        this.myLocationViewListener = myLocationViewListener;
    }

    public MyLocationPresenter() {
        this.myLocationInteractor = new MyLocationInteractor(this);
    }

    public void requestDeviceLocation(Activity activity, FusedLocationProviderClient fusedLocationProviderClient) {
        myLocationInteractor.getDeviceLocation(activity, fusedLocationProviderClient);
    }


    @Override
    public void responseSuccess(Location location) {
        myLocationViewListener.getSuccess(location);
    }

    @Override
    public void responseFailure(String message) {
        myLocationViewListener.getFailure(message);
    }
}

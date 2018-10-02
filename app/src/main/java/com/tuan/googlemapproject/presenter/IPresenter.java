package com.tuan.googlemapproject.presenter;

import android.location.Location;

public interface IPresenter {

    interface MyLocationPresenterListener {
        void responseSuccess(Location location);

        void responseFailure(String message);
    }
}

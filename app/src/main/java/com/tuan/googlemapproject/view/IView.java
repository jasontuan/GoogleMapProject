package com.tuan.googlemapproject.view;

import android.location.Location;

public interface IView {

    interface MyLocationViewListener {
        void getSuccess(Location location);

        void getFailure(String message);
    }
}

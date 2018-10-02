package com.tuan.googlemapproject.widget;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tuan.googlemapproject.R;
import com.tuan.googlemapproject.constant.ConstValue;

public class CustomInfoMarker implements GoogleMap.InfoWindowAdapter {

    private View view;

    public CustomInfoMarker(Context context) {
        this.view = LayoutInflater.from(context).inflate(R.layout.item_marker, null);
    }

    private void customInfoMarker(Marker marker) {
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        tvMessage.setText(marker.getTitle());
    }

    @Override
    public View getInfoWindow(Marker marker) {
        customInfoMarker(marker);
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        customInfoMarker(marker);
        return view;
    }
}

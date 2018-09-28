package com.tuan.googlemapproject.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.tuan.googlemapproject.R;

public class CustomInfoMarker implements GoogleMap.InfoWindowAdapter {

    private Context context;
    private View view;

    public CustomInfoMarker(Context context) {
        this.context = context;
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

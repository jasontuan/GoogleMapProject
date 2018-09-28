package com.tuan.googlemapproject.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tuan.googlemapproject.R;
import com.tuan.googlemapproject.constant.ConstValue;

public class CustomInfoMarker implements GoogleMap.InfoWindowAdapter {

    private Context context;
    private GoogleMap mMap;
    private View view;

    public CustomInfoMarker(Context context, GoogleMap mMap) {
        this.context = context;
        this.mMap = mMap;
        this.view = LayoutInflater.from(context).inflate(R.layout.item_marker, null);
    }

    private void customInfoMarker(Marker marker) {
        TextView tvMessage = view.findViewById(R.id.tvMessage);
        tvMessage.setText(marker.getTitle());
    }

    private void setMarker(Marker marker) {
        mMap.addMarker(new MarkerOptions()
                .position(marker.getPosition())
                .title(marker.getTitle())
                .icon(BitmapDescriptorFactory.fromBitmap(CustomMarkerBitmap.newInstance().convertDrawable(context)))).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), ConstValue.DEFAULT_ZOOM));
    }

    @Override
    public View getInfoWindow(Marker marker) {
        customInfoMarker(marker);
        setMarker(marker);
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        customInfoMarker(marker);
        setMarker(marker);
        return view;
    }
}

package com.tuan.googlemapproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tuan.googlemapproject.constant.ConstValue;
import com.tuan.googlemapproject.widget.CustomInfoMarker;
import com.tuan.googlemapproject.widget.CustomMarkerBitmap;
import com.tuan.googlemapproject.widget.DialogLoadingFragment;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        DialogLoadingFragment.getInstance().show(getSupportFragmentManager(), ConstValue.TAG);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        DialogLoadingFragment.getInstance().dismiss();

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setInfoWindowAdapter(new CustomInfoMarker(this));

    }

    private void setMarker(Marker marker) {
        mMap.addMarker(new MarkerOptions()
                .position(marker.getPosition())
                .title(marker.getTitle())
                .icon(BitmapDescriptorFactory.fromBitmap(CustomMarkerBitmap.newInstance().convertDrawable(this)))).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), ConstValue.DEFAULT_ZOOM));
    }
}

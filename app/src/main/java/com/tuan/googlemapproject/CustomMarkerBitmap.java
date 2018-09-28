package com.tuan.googlemapproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class CustomMarkerBitmap {

    private final static CustomMarkerBitmap customMarkerBitMap = new CustomMarkerBitmap();

    public static CustomMarkerBitmap newInstance() {
        return customMarkerBitMap;
    }

    public Bitmap convertDrawable(Drawable drawable) {
        int width = 40;
        int height = 40;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}

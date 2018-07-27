package com.example.customadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DriveHolder {

    public ImageView typeImageView;
    public TextView titleView;
    public TextView dateView;
    public ImageView menuView;

    public DriveHolder(View root){
        typeImageView = (ImageView)root.findViewById(R.id.imageView2);
        titleView = root.findViewById(R.id.titleView);
        dateView = root.findViewById(R.id.dateView);
        menuView = root.findViewById(R.id.imageView3);
    }
}

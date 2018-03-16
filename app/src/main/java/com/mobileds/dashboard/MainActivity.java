package com.mobileds.dashboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileds.dashboard.utils.IntegerUtils;
import com.mobileds.dashboard.view.Dash;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dash dash = (Dash) findViewById(R.id.dash);
        dash.setData(0.86);
    }


}

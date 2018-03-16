package com.mobileds.dashboard.view;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobileds.dashboard.R;
import com.mobileds.dashboard.utils.IntegerUtils;

/**
 * Created by Administrator on 2018-3-16.
 */
public class Dash extends LinearLayout {

    long time = 2000;
    private ImageView pointer;
    private TextView tv_percent;

    public Dash(Context context) {
        super(context);
    }

    public Dash(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.item_dash, this);
        initView(view);
    }

    private void initView(View view) {
        pointer = (ImageView) findViewById(R.id.pointer);
        tv_percent = (TextView) findViewById(R.id.tv_percent);
    }

    public void setData(final double data) {
        setColor(data);
        final RotateAnimation animation = new RotateAnimation(startAngle(data), (float) (270 * data - 45),//-45f
                Animation.RELATIVE_TO_SELF, 0.890625f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(2000);
        animation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tv_percent.setTextColor(getColorByData(data));
                tv_percent.setText(IntegerUtils.handle1To1PerData(data));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        pointer.startAnimation(animation);
    }

    /**
     * @param data
     * @return
     */
    private float startAngle(double data) {
        if (data >= 0.66) {
            return (float) (-45 + 270 * 0.66);
        } else if (data >= 0.34) {
            return (float) (-45 + 270 * 0.34);
        } else {
            return (float) (-45);
        }
    }

    private long getTime(long data) {
        if (data >= 0.66) {
            return (long) ((data - 0.66) / 0.33) * time;
        } else if (data >= 0.34) {
            return (long) ((data - 0.34) / 0.33) * time;
        } else {
            return (long) (data / 0.34) * time;
        }
    }

    private void initView() {
        pointer = (ImageView) findViewById(R.id.pointer);
        tv_percent = (TextView) findViewById(R.id.tv_percent);
    }

    public void setColor(double data) {
        if (data >= 0.66) {
            pointer.setImageResource(R.mipmap.green_pointer);
        } else if (data >= 0.34) {
            pointer.setImageResource(R.mipmap.yollow_pointer);
        } else {
            pointer.setImageResource(R.mipmap.red_pointer);
        }
    }

    public int getColorByData(double data) {
        if (data >= 0.66) {
            return getResources().getColor(R.color.dash_green);
        } else if (data >= 0.34) {
            return getResources().getColor(R.color.dash_yellow);
        } else {
            return getResources().getColor(R.color.dash_red);
        }
    }
}

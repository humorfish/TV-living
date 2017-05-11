package com.you.tv_living.view.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.you.tv_living.R;

/**
 * Created by Administrator on 2017/5/8.
 */

public abstract class BaseActivity extends AppCompatActivity
{
    private static final int COLOR_DEFAULT = Color.parseColor("#7f000000");
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        context = this;

        setContentView(getRootViewId());
        setStatusViewColor(getResources().getColor(R.color.colorPrimaryDark));
        initView();
    }

    public void replaceFragment(@IdRes int id, Fragment fragment)
    {
        getSupportFragmentManager().beginTransaction().replace(id, fragment).commit();
    }

    public abstract int getRootViewId();
    public abstract void initView();

    public void setStatusViewColor(int statusColor)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            if (statusColor != -1)
                getWindow().setStatusBarColor(statusColor);

            return;
        }
        else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            int color = COLOR_DEFAULT;
            ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
            if(statusColor != -1)
                color = statusColor;

            View statusBarView = new View(this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(this));
            statusBarView.setBackgroundColor(color);
            contentView.addView(statusBarView, params);
        }
    }

    private int getStatusBarHeight(Context context)
    {
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            height = context.getResources().getDimensionPixelSize(resourceId);

        return height;
    }

}

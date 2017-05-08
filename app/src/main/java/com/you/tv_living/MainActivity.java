package com.you.tv_living;

import android.os.Bundle;
import com.you.tv_living.view.base.activity.BaseActivity;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getRootViewId()
    {
        return R.layout.activity_main;
    }

    @Override
    public void initView()
    {
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static
    {
        System.loadLibrary("native-lib");
    }
}

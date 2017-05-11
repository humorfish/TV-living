package com.you.tv_living;

import android.app.Application;

import com.you.tv_living.greendao.DaoMaster;
import com.you.tv_living.greendao.DaoSession;

/**
 * Created by Administrator on 2017/5/11.
 */

public class App extends Application
{
    private static final String BUGLY_ID  = "28aeafeef1";

    private DaoMaster.DevOpenHelper mHelper;

    private DaoSession mDaoSession;

    @Override
    public void onCreate()
    {
        super.onCreate();

        initDatabase();
    }

    public void initDatabase()
    {
        mHelper = new DaoMaster.DevOpenHelper(this,"tv-db",null);

        DaoMaster daoMaster = new DaoMaster(mHelper.getWritableDatabase());

        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }
}

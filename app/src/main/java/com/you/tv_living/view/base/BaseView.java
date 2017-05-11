package com.you.tv_living.view.base;

import com.you.tv_living.view.mvp.MvpView;

/**
 * Created by Administrator on 2017/5/10.
 */

public interface BaseView extends MvpView
{
    void showProgress();

    void onCompleted();

    void onError(Throwable e);
}

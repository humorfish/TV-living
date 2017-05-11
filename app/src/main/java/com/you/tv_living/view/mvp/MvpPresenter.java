package com.you.tv_living.view.mvp;

/**
 * Created by Administrator on 2017/5/10.
 */

public interface MvpPresenter<V extends MvpView>
{
    public void attachView(V view);
    public void detachView(boolean retainInstance);
}

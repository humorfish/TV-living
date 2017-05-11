package com.you.tv_living.view.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.you.tv_living.App;
import com.you.tv_living.view.mvp.MvpFragment;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/5/9.
 */

public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>>  extends MvpFragment<V,P>
{

    protected Context context;

    private View rootView;

    private Unbinder mUnbinder;
    private int rootViewId;

    public <T extends View> T findView(@IdRes int id){
        return (T)rootView.findViewById(id);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        context = getActivity();
        rootView = inflater.inflate(getRootViewId(), container, false);
        mUnbinder = ButterKnife.bind(this,rootView);

        initUI();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public App getApp()
    {
        return (App)getActivity().getApplication();
    }

    public <T> void  toSetList(List<T> list, List<T> newList, boolean isMore)
    {
        if(list!=null && newList!=null)
        {
            synchronized (BaseFragment.class)
            {
                if(!isMore)
                {
                    list.clear();
                }

                list.addAll(newList);
            }
        }
    }

    protected abstract void initData();

    protected abstract void initUI();

    public int getRootViewId()
    {
        return rootViewId;
    }
}

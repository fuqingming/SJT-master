package com.qlzs.sjt.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.qlzs.sjt.http.HttpClient;
import com.qlzs.sjt.util.HUDProgressUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by HH
 * Date: 2017/11/9
 */

public abstract class BaseFragment extends Fragment
{
    private View mContentView;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    protected KProgressHUD kProgressHUD;
    protected Unbinder unbinder;

    private boolean isHaveEventBus;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        if(mContentView != null)
        {
            ViewGroup vgParent = (ViewGroup) mContentView.getParent();
            if (vgParent != null)
            {
                vgParent.removeView(mContentView);
            }
            return mContentView;
        }
        mContentView = inflater.inflate(setLayoutResourceId(),container,false);

        mContentView = inflater.inflate(setLayoutResourceId(), null);
        mContext = getContext();
        mLayoutInflater = inflater;

        kProgressHUD = new HUDProgressUtils().showLoadingImage(getMContext());
        unbinder = ButterKnife.bind(this, getContentView());
        init();
        initView();
        initData();
        clickView();

        return mContentView;
    }

    protected abstract int setLayoutResourceId();
    private void init()
    {
        HttpClient.init(getContext().getApplicationContext(),false);
    }

    protected void initData(){}

    protected void initView() {}

    protected void clickView() {}

    protected View getContentView()
    {
        return mContentView;
    }

    public Context getMContext()
    {
        return mContext;
    }

    public LayoutInflater getMLayoutInflater()
    {
        return mLayoutInflater;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
//        unbinder.unbind();
        if(isHaveEventBus)
        {
            EventBus.getDefault().unregister(this);
        }
    }

    protected void setEventBus()
    {
        isHaveEventBus = true;
        EventBus.getDefault().register(this);
    }
}

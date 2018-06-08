package com.qlzs.sjt;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.qlzs.sjt.adapter.MyFrPagerAdapter;
import com.qlzs.sjt.base.BaseAppCompatActivity;
import com.qlzs.sjt.util.Utils;
import com.qlzs.sjt.view.PagerSlidingTabStrip;

import butterknife.BindView;

public class GroupDetailsActivity extends BaseAppCompatActivity
{
    @BindView(R.id.iv_details)
    ImageView m_ivDetails;

    @Override
    protected int setLayoutResourceId()
    {
        return R.layout.activity_group_details;
    }

    @Override
    protected void initView()
    {
        Utils.initCommonTitle(this,"团购详情");
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496996959&di=13c094ba73675a24df2ad1d2c730c02c&imgtype=jpg&er=1&src=http%3A%2F%2Fdasouji.com%2Fwp-content%2Fuploads%2F2015%2F07%2F%25E9%2595%25BF%25E8%258A%25B1%25E5%259B%25BE-6.jpg").into(m_ivDetails);
    }
}

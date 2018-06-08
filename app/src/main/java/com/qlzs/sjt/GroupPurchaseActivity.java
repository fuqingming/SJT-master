package com.qlzs.sjt;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.qlzs.sjt.adapter.MyFrPagerAdapter;
import com.qlzs.sjt.base.BaseAppCompatActivity;
import com.qlzs.sjt.util.Utils;
import com.qlzs.sjt.view.PagerSlidingTabStrip;

import butterknife.BindView;

public class GroupPurchaseActivity extends BaseAppCompatActivity
{
    @BindView(R.id.tabs)
    PagerSlidingTabStrip m_pagerSlidingTabStrip;
    @BindView(R.id.pager)
    ViewPager m_viewPager;

    private String m_textArray[] = {"热门","中央空调","地暖","橱柜","衣柜","瓷砖","洗衣机","热水器" };
    // 各tab页对应的fragment
    private Fragment m_fragmentArray[] = {  new FragmentGroupHotContent(),
                                            new FragmentTwoContent(),
                                            new FragmentOneContent(),
                                            new FragmentOneContent(),
                                            new FragmentOneContent(),
                                            new FragmentOneContent(),
                                            new FragmentOneContent(),
                                            new FragmentOneContent()};


    @Override
    protected int setLayoutResourceId()
    {
        return R.layout.activity_group_purchase;
    }

    @Override
    protected void initView()
    {
        Utils.initCommonTitle(this,"团购");

        m_viewPager.setAdapter(new MyFrPagerAdapter(getSupportFragmentManager(), m_textArray, m_fragmentArray));
        m_pagerSlidingTabStrip.setViewPager(m_viewPager);
        m_viewPager.setCurrentItem(0);
    }
}

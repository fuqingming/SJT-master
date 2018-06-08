package com.qlzs.sjt.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 顾修忠-guxiuzhong@youku.com/gfj19900401@163.com
 * @Title: MyPagerAdapter
 * @Package com.guxiuzhong.pagerslidingtabstrip.adapter
 * @Description:
 * @date 15/11/29
 * @time 下午12:53
 */
public class MyFrPagerAdapter extends FragmentPagerAdapter
{

    private String textArray[];

    private Fragment fragmentArray[];

    public MyFrPagerAdapter(FragmentManager fm, String m_textArray[], Fragment m_fragmentArray[])
    {
        super(fm);
        this.textArray = m_textArray;
        this.fragmentArray=m_fragmentArray;
    }


    @Override
    public CharSequence getPageTitle(int position)
    {
        return textArray[position];
    }

    @Override
    public int getCount()
    {
        return textArray.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position)
    {
        return fragmentArray[position];
    }
}

package com.qlzs.sjt;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qlzs.sjt.base.BaseAppCompatActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseAppCompatActivity
{

    private Fragment m_fragmentCommunity;
    private Fragment m_fragmentMessages;
    private Fragment m_fragmentCollections;
    private Fragment m_fragmentAboutMe;

    @BindView(R.id.radioGroup)
    RadioGroup m_radioGroup;

    private int m_nFragmentIndex = 0;

    @Override
    protected int setLayoutResourceId()
    {
        return R.layout.activity_main;
    }

    @Override
    protected void initData()
    {
        //创建Fragment对象及集合
        m_fragmentCommunity=new FragmentHall();
        m_fragmentMessages=new Fragment_Messages();
        m_fragmentCollections=new Fragment_Collections();
        m_fragmentAboutMe=new Fragment_AboutMe();

        m_radioGroup.check(R.id.radio_community);
        addFragment(m_fragmentCommunity);
    }

    public void addFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }

    private long lastBackPress;
    @Override
    public void onBackPressed()
    {
        if(m_nFragmentIndex != 0 )
        {
            m_nFragmentIndex = 0;
            m_radioGroup.check(R.id.radio_community);
            addFragment(m_fragmentCommunity);
            return;
        }
        if (System.currentTimeMillis() - lastBackPress < 1000)
        {
            super.onBackPressed();
        }
        else
        {
            lastBackPress = System.currentTimeMillis();
            Toast.makeText(MainActivity.this, "再按一次注销", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @OnClick({R.id.radio_community,R.id.radio_messages,R.id.radio_collections,R.id.radio_aboutme,R.id.iv_group})
    public void onViewClick(View view)
    {
        switch (view.getId())
        {
            case R.id.radio_community:
                m_nFragmentIndex = 0;
                addFragment(m_fragmentCommunity);
                break;
            case R.id.radio_messages:
                m_nFragmentIndex = 1;
                addFragment(m_fragmentMessages);
                break;
            case R.id.radio_collections:
                m_nFragmentIndex = 2;
                addFragment(m_fragmentCollections);

                break;
            case R.id.radio_aboutme:
                m_nFragmentIndex = 3;
                addFragment(m_fragmentAboutMe);
                break;
            case R.id.iv_group:
                Intent it = new Intent(this,GroupPurchaseActivity.class);
                startActivity(it);
                break;
        }
    }
}

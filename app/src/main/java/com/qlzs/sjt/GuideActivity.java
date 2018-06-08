package com.qlzs.sjt;

import android.content.Intent;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.qlzs.sjt.base.BaseAppCompatActivity;
import com.qlzs.sjt.util.Utils;

import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;

public class GuideActivity extends BaseAppCompatActivity
{

    @BindView(R.id.iv_guide)
    ImageView m_ivGuide;

    @Override
    protected int setLayoutResourceId()
    {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView()
    {
        m_ivGuide.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent it = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(it);
                finish();
            }
        },2000);
    }



    // 按两次返回键退出程序
    private static final int WAIT_NEXT_KEY_BACK_DURATION = 1000 * 2;
    private Boolean m_bFistKeyBackPressed = false;
    private Boolean m_bIsWaitingNextKeyBack = false;
    private Timer m_timerWaitingNextKeyBack = new Timer();

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if (!m_bFistKeyBackPressed)
            {
                m_bFistKeyBackPressed = true;

                Utils.showToast(this, "再按一次退出程序");

                if (!m_bIsWaitingNextKeyBack)
                {
                    m_bIsWaitingNextKeyBack = true;

                    m_timerWaitingNextKeyBack.schedule(new TimerTask()
                    {
                        public void run()
                        {
                            m_bFistKeyBackPressed = false;
                            m_bIsWaitingNextKeyBack = false;
                        }
                    }, WAIT_NEXT_KEY_BACK_DURATION);
                }
                return true;
            }
            else
            {
                finish();
            }
        }
        return false;
    }
}

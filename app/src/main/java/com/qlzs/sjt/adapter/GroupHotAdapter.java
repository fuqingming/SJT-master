package com.qlzs.sjt.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qlzs.sjt.R;
import com.qlzs.sjt.bean.base.GroupHotBean;
import com.qlzs.sjt.util.recycler.BaseRecyclerAdapter;
import com.qlzs.sjt.util.recycler.BaseRecyclerViewHolder;

import butterknife.BindView;

public class GroupHotAdapter extends BaseRecyclerAdapter<GroupHotBean>
{

    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_text)
    TextView tvText;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.ll_btn)
    LinearLayout llBtn;

    public GroupHotAdapter(){}

    @Override
    protected int getContentView(int viewType)
    {
        return R.layout.item_group_hot;
    }

    @Override
    protected void covert(BaseRecyclerViewHolder holder, final GroupHotBean data, final int position)
    {
        ivPic.setImageResource(data.getPic());
        tvTitle.setText(data.getTitle());
        tvText.setText(data.getText());
        tvAmount.setText(data.getAmount());
        tvCount.setText(data.getCount());

        llBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doClickListener.DoClick(data);
            }
        });
    }

}

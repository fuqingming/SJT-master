package com.qlzs.sjt.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qlzs.sjt.R;
import com.qlzs.sjt.bean.base.GroupHotBean;
import com.qlzs.sjt.bean.base.GroupHotCommentBean;
import com.qlzs.sjt.util.recycler.BaseRecyclerAdapter;
import com.qlzs.sjt.util.recycler.BaseRecyclerViewHolder;

import butterknife.BindView;

public class GroupHotCommentAdapter extends BaseRecyclerAdapter<GroupHotCommentBean>
{

    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_person_count)
    TextView tvPersonCount;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_btn)
    TextView tvBtn;

    public GroupHotCommentAdapter(){}

    @Override
    protected int getContentView(int viewType)
    {
        return R.layout.item_group_hot_comment;
    }

    @Override
    protected void covert(BaseRecyclerViewHolder holder, final GroupHotCommentBean data, final int position)
    {
//        ivIcon.setImageResource(data.getPic());
        tvName.setText(data.getName());
        tvPersonCount.setText(data.getCount());
        tvTime.setText(data.getTime());

        tvBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doClickListener.DoClick(data);
            }
        });
    }

}

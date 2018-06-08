package com.qlzs.sjt;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.qlzs.sjt.adapter.GroupHotAdapter;
import com.qlzs.sjt.base.BaseListFragment;
import com.qlzs.sjt.bean.base.GroupHotBean;
import com.qlzs.sjt.util.recycler.BaseRecyclerAdapter;

/**
 *  @author 付庆明
 */
public class FragmentGroupHotContent extends BaseListFragment
{
    private GroupHotAdapter m_groupHotAdapter = new GroupHotAdapter();

    @Override
    protected int setLayoutResourceId()
    {
        return R.layout.activity_common_listview;
    }

    @Override
    protected BaseRecyclerAdapter getListAdapter()
    {
        return m_groupHotAdapter;
    }

    @Override
    protected void initLayoutManager()
    {
        View header = LayoutInflater.from(getMContext()).inflate(R.layout.common_head_group_pic,mRecyclerView, false);
        mRecyclerViewAdapter.addHeaderView(header);
        mRecyclerView.setLoadMoreEnabled(true);

        DividerDecoration divider = new DividerDecoration.Builder(getMContext())
                .setHeight(R.dimen.ten)
                .setColorResource(R.color.app_backgrount_color)
                .build();

        mRecyclerView.addItemDecoration(divider);

        mRecyclerViewAdapter.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                Intent it = new Intent(getMContext(),GroupDetailsActivity.class);
                startActivity(it);
            }

        });

        m_groupHotAdapter.onDoClickListener(new BaseRecyclerAdapter.DoClickListener()
        {
            @Override
            public void DoClick(Object obj)
            {
                GroupHotBean data = (GroupHotBean)obj;
            }
        });
    }

    protected void requestData()
    {
        executeOnLoadDataSuccess(DataUtil.initGroupHotBean(), true);
        executeOnLoadFinish();
    }

}

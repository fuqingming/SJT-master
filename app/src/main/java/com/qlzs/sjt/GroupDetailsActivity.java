package com.qlzs.sjt;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.qlzs.sjt.adapter.GroupHotCommentAdapter;
import com.qlzs.sjt.adapter.GroupHotSimilarAdapter;
import com.qlzs.sjt.base.BaseGridViewActivity;
import com.qlzs.sjt.bean.base.GroupHotCommentBean;
import com.qlzs.sjt.util.Utils;
import com.qlzs.sjt.util.recycler.BaseRecyclerAdapter;
import butterknife.BindView;
import butterknife.OnClick;

public class GroupDetailsActivity extends BaseGridViewActivity
{
    private TextView m_tvTitle;
    private TextView m_tvText;
    private TextView m_tvAmount;
    private TextView m_tvAmounts;
    private TextView m_tvCount;                 //已拼件数
    private TextView m_tvPersonCount;           //拼单人数
    private TextView getM_tvPersonListCount;    //列表显示拼单人数
    private TextView m_tvCommentCount;          //商品评价数
    private TextView m_tvCommentCount1;         //正品
    private TextView m_tvCommentCount2;         //质量很好
    private TextView m_tvCommentCount3;         //划算
    private TextView m_tvCommentCount4;         //好用
    private ImageView m_ivCommentIcon;
    private TextView m_tvCommentName;
    private TextView m_tvCommentText;
    private ImageView m_ivCompanyPic;
    private TextView m_tvCompanyName;
    private TextView m_tvCompanyCount;          //商家商品数量
    private TextView m_tvCompanyCounts;         //商家已拼数
    private ImageView m_ivDetails;
    private TextView m_tvDetails;
    private LinearLayout m_llBtn;
    private RecyclerView m_recyclerViewJoin;

    @BindView(R.id.tv_all_amount)
    TextView m_tvAllAmount;                     //单独购买价格
    @BindView(R.id.tv_amount_btn)
    TextView m_tvAmountBtn;                     //发起拼单

    private GroupHotCommentAdapter m_groupHotCommentAdapter = new GroupHotCommentAdapter();
    private GroupHotSimilarAdapter m_groupHotSimilarAdapter = new GroupHotSimilarAdapter();

    @Override
    protected int setLayoutResourceId()
    {
        return R.layout.activity_group_details;
    }


    @Override
    protected void initView()
    {
        Utils.initCommonTitle(this,"团购详情");
    }

    @Override
    protected BaseRecyclerAdapter getListAdapter()
    {
        return m_groupHotSimilarAdapter;
    }

    @Override
    protected void initLayoutManager()
    {
        View header = LayoutInflater.from(this).inflate(R.layout.common_head_group_hot_similar,mRecyclerView, false);
        m_tvTitle = header.findViewById(R.id.tv_title);
        m_tvText = header.findViewById(R.id.tv_text);
        m_tvAmount = header.findViewById(R.id.tv_amount);
        m_tvAmounts = header.findViewById(R.id.tv_amounts);
        m_tvCount = header.findViewById(R.id.tv_count);                             //已拼件数
        m_tvPersonCount = header.findViewById(R.id.tv_person_count);                //拼单人数
        getM_tvPersonListCount = header.findViewById(R.id.tv_person_list_count);    //列表显示拼单人数
        m_tvCommentCount = header.findViewById(R.id.tv_comment_count);              //商品评价数
        m_tvCommentCount1 = header.findViewById(R.id.tv_comment_count1);            //正品
        m_tvCommentCount2 = header.findViewById(R.id.tv_comment_count2);            //质量很好
        m_tvCommentCount3 = header.findViewById(R.id.tv_comment_count3);            //划算
        m_tvCommentCount4 = header.findViewById(R.id.tv_comment_count4);            //好用
        m_ivCommentIcon = header.findViewById(R.id.iv_commnet_icon);
        m_tvCommentName = header.findViewById(R.id.tv_commnet_name);
        m_tvCommentText = header.findViewById(R.id.tv_commnet_text);
        m_ivCompanyPic = header.findViewById(R.id.iv_company_pic);
        m_tvCompanyName = header.findViewById(R.id.tv_company_name);
        m_tvCompanyCount = header.findViewById(R.id.tv_company_count);              //商家商品数量
        m_tvCompanyCounts = header.findViewById(R.id.tv_company_counts);            //商家已拼数
        m_ivDetails = header.findViewById(R.id.iv_details);
        m_tvDetails = header.findViewById(R.id.tv_details);
        m_llBtn = header.findViewById(R.id.ll_company);

        m_recyclerViewJoin = header.findViewById(R.id.recycler_view_join);
        m_recyclerViewJoin.setLayoutManager(new LinearLayoutManager(this));
        m_recyclerViewJoin.setHasFixedSize(true);
        m_recyclerViewJoin.setAdapter(m_groupHotCommentAdapter);

        m_groupHotCommentAdapter.onDoClickListener(new BaseRecyclerAdapter.DoClickListener()
        {
            @Override
            public void DoClick(Object obj)
            {
                GroupHotCommentBean data = (GroupHotCommentBean)obj;
            }
        });

        mRecyclerViewAdapter.addHeaderView(header);

        int spacing = getResources().getDimensionPixelSize(R.dimen.eight);
        mRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(spacing, spacing, manager.getSpanCount(),getResources().getColor(R.color.app_backgrount_color)));

        mRecyclerView.setLoadMoreEnabled(true);

        initHeadData();
    }

    @SuppressLint("SetTextI18n")
    private void initHeadData(){
        m_tvTitle.setText("[Fotile/方太] 方太 EN05E＋FD21GE 高效静吸");
        m_tvText.setText("纯钢触控，欧式爆款, 5年质保");
        m_tvAmount.setText("1688");
        m_tvAmounts.setText("￥3666");
        m_tvCount.setText("0");                                 //已拼件数
        m_tvPersonCount.setText("2");                           //拼单人数
        getM_tvPersonListCount.setText("2");                    //列表显示拼单人数
        m_tvCommentCount.setText("200");                        //商品评价数
        m_tvCommentCount1.setText("正品(0)");                   //正品
        m_tvCommentCount2.setText("质量很好(0)");               //质量很好
        m_tvCommentCount3.setText("划算(0)");                   //划算
        m_tvCommentCount4.setText("好用(0)");                   //好用
        m_ivCommentIcon.setBackgroundResource(R.color.dark);
        m_tvCommentName.setText("走路带风");
        m_tvCommentText.setText("好好好");
        m_ivCompanyPic.setBackgroundResource(R.color.dark);
        m_tvCompanyName.setText("方太电器");
        m_tvCompanyCount.setText("11");                         //商家商品数量
        m_tvCompanyCounts.setText("0");                         //商家已拼数
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496996959&di=13c094ba73675a24df2ad1d2c730c02c&imgtype=jpg&er=1&src=http%3A%2F%2Fdasouji.com%2Fwp-content%2Fuploads%2F2015%2F07%2F%25E9%2595%25BF%25E8%258A%25B1%25E5%259B%25BE-6.jpg").into(m_ivDetails);
        m_tvDetails.setText("商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情商品详情");

        if(DataUtil.initGroupHotCommentBean().size() > 0)
        {
            m_groupHotCommentAdapter.setDataList(DataUtil.initGroupHotCommentBean());
        }
        else
        {
            findViewById(R.id.ll_join).setVisibility(View.GONE);
        }

        m_llBtn.setOnClickListener(new View.OnClickListener()//进店逛逛
        {
            @Override
            public void onClick(View view)
            {

            }
        });
    }

    @OnClick({R.id.ll_collection,R.id.ll_customer,R.id.ll_all_amount,R.id.ll_amount})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.ll_collection://收藏

                break;
            case R.id.ll_customer://客服

                break;
            case R.id.ll_all_amount://单独购买

                break;
            case R.id.ll_amount://发起拼单

                break;
        }
    }

    protected void requestData()
    {
        executeOnLoadDataSuccess(DataUtil.initGroupHotSimilarBean(),true);
    }
}

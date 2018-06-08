package com.qlzs.sjt;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.google.gson.Gson;
import com.qlzs.sjt.adapter.ModuleSelectionAdapter;
import com.qlzs.sjt.base.BaseFragment;
import com.qlzs.sjt.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Response;

/**
 *
 *
 * */
public class FragmentHall extends BaseFragment
{

	@BindView(R.id.gridview_functions)
	GridView m_gridView;
	private List<Map<String, Object>> m_listData;
	private ModuleSelectionAdapter m_adapter;

	private int[] m_arrIcon = { R.mipmap.maijianvaiwill, R.mipmap.maijianvaiwill, R.mipmap.maijianvaiwill,R.mipmap.maijianvaiwill,
								R.mipmap.maijianvaiwill, R.mipmap.maijianvaiwill,R.mipmap.maijianvaiwill, R.mipmap.maijianvaiwill };

	private String[] m_arrText = { "建材商店", "装修公司", "附近工地","装修金融",
								   "生活缴费", "推荐客户","加盟合作", "更多"};

	private enum FunctionIndex{	RENOVATION, BUILDING, REDUCE_WEIGHT ,DESIGNER_ENTREPRENEURSHIP ,
								MANAGER_ENTREPRENEURSHIP , QUIT_SMOKING,QUIT_DRINKING , GIVE_UP_GAMBLING
	}

	@Override
	protected int setLayoutResourceId()
	{
		return R.layout.fragment_hall;
	}

	@Override
	protected void initView()
	{
		Utils.initCommonTitle(getContentView(),"赏金堂");
	}

	@Override
	protected void initData()
	{
		// 换算gridview中item高度
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
		int nWidth = (dm.widthPixels - 3)/4;

		// 获取数据
		m_listData = getData(m_arrIcon, m_arrText);
		m_adapter = new ModuleSelectionAdapter(getMContext(), m_listData, nWidth);
		m_gridView.setAdapter(m_adapter);
		m_gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));

		m_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
			{
//				if(!AppSettings.isAutoLogin()){
////					Intent it = new Intent(getMContext(),LoginActivity.class);
////					startActivity(it);
//					return;
//				}
				Intent it ;
				switch (FunctionIndex.values()[position])
				{
					case RENOVATION:
					{

					}
					break;

					case BUILDING:
					{

					}
					break;

					case REDUCE_WEIGHT:
					{

					}
					break;

					case DESIGNER_ENTREPRENEURSHIP:
					{

					}
					break;

					case MANAGER_ENTREPRENEURSHIP:
					{

					}
					break;

					case QUIT_SMOKING:
					{

					}
					break;

					case QUIT_DRINKING:
					{

					}
					break;

					case GIVE_UP_GAMBLING:
					{

					}
					break;
				}
			}
		});
	}

	private List<Map<String, Object>> getData(int[] arrIcon, String[] arrText)
	{
		ArrayList<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();

		for(int i = 0; i < arrIcon.length; i ++)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("icon", arrIcon[i]);
			map.put("text", arrText[i]);
			listData.add(map);
		}

		return listData;
	}
}
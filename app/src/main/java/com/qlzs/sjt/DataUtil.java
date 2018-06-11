package com.qlzs.sjt;

import com.qlzs.sjt.bean.base.GroupHotBean;
import com.qlzs.sjt.bean.base.GroupHotCommentBean;
import com.qlzs.sjt.bean.base.GroupHotSimilarBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2018/4/9.
 */

public class DataUtil {

    public static List<GroupHotBean> initGroupHotBean(){
        List<GroupHotBean> videoPlayBackBeans = new ArrayList<>();
        videoPlayBackBeans.add(new GroupHotBean(R.mipmap.pic,"[Fotile/方太] 方太 EN05E＋FD21GE 高效静吸 ","纯钢触控，欧式爆款, 5年质保","1688","1"));
        videoPlayBackBeans.add(new GroupHotBean(R.mipmap.pic,"[Fotile/方太] 方太 EN05E＋FD21GE 高效静吸 ","纯钢触控，欧式爆款, 5年质保","1688","1"));
        videoPlayBackBeans.add(new GroupHotBean(R.mipmap.pic,"[Fotile/方太] 方太 EN05E＋FD21GE 高效静吸 ","纯钢触控，欧式爆款, 5年质保","1688","1"));
        videoPlayBackBeans.add(new GroupHotBean(R.mipmap.pic,"[Fotile/方太] 方太 EN05E＋FD21GE 高效静吸 ","纯钢触控，欧式爆款, 5年质保","1688","1"));
        return videoPlayBackBeans;
    }

    public static List<GroupHotSimilarBean> initGroupHotSimilarBean(){
        List<GroupHotSimilarBean> videoPlayBackBeans = new ArrayList<>();
        videoPlayBackBeans.add(new GroupHotSimilarBean(R.mipmap.pic,"[Fotile/方太]","方太 EN05E＋FD21GE 高效静吸","纯钢触控，欧式爆款, 5年质保","1688","1"));
        videoPlayBackBeans.add(new GroupHotSimilarBean(R.mipmap.pic,"[Fotile/方太]","方太 EN05E＋FD21GE 高效静吸","纯钢触控，欧式爆款, 5年质保","1688","1"));
        return videoPlayBackBeans;
    }

    public static List<GroupHotCommentBean> initGroupHotCommentBean(){
        List<GroupHotCommentBean> videoPlayBackBeans = new ArrayList<>();
        videoPlayBackBeans.add(new GroupHotCommentBean(R.mipmap.pic,"走路带风","1","22:50:32"));
        videoPlayBackBeans.add(new GroupHotCommentBean(R.mipmap.pic,"走路带风","1","22:50:32"));
        return videoPlayBackBeans;
    }

}

package com.qlzs.sjt.bean.base;

import java.io.Serializable;

/**
 * Created by vip on 2018/5/2.
 */

public class GroupHotCommentBean implements Serializable{
    private int pic;
    private String name;
    private String count;
    private String time;

    public GroupHotCommentBean(int pic, String name, String count, String time) {
        this.pic = pic;
        this.name = name;
        this.count = count;
        this.time = time;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

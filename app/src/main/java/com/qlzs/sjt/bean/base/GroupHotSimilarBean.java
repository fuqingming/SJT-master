package com.qlzs.sjt.bean.base;

import java.io.Serializable;

/**
 * Created by vip on 2018/5/2.
 */

public class GroupHotSimilarBean implements Serializable{
    private int pic;
    private String title;
    private String titleText;
    private String text;
    private String amount;
    private String count;

    public GroupHotSimilarBean(int pic, String title,String titleText, String text, String amount, String count) {
        this.pic = pic;
        this.title = title;
        this.titleText = titleText;
        this.text = text;
        this.amount = amount;
        this.count = count;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

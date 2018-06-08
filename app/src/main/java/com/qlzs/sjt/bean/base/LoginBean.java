package com.qlzs.sjt.bean.base;

import com.qlzs.sjt.bean.response.ResponseBaseBean;

/**
 * Created by vip on 2018/5/2.
 */

public class LoginBean extends ResponseBaseBean {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{
        private String uid;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}

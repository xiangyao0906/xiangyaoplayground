package com.xiangyao.train.data;

import com.xiangyao.train.bean.BannerBean;

import java.util.List;

public class BannerData {
    private Integer status;
    private List<BannerBean> data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<BannerBean> getData() {
        return data;
    }

    public void setData(List<BannerBean> data) {
        this.data = data;
    }
}


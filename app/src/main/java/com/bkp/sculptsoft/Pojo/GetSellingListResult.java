package com.bkp.sculptsoft.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 24-12-2016.
 */

public class GetSellingListResult {
    @SerializedName("isnext")
    @Expose
    private String isnext;
    @SerializedName("sellingList")
    @Expose
    private List<SellingList> sellingList = null;

    public String getIsnext() {
        return isnext;
    }

    public void setIsnext(String isnext) {
        this.isnext = isnext;
    }

    public GetSellingListResult withIsnext(String isnext) {
        this.isnext = isnext;
        return this;
    }

    public List<SellingList> getSellingList() {
        return sellingList;
    }

    public void setSellingList(List<SellingList> sellingList) {
        this.sellingList = sellingList;
    }

    public GetSellingListResult withSellingList(List<SellingList> sellingList) {
        this.sellingList = sellingList;
        return this;
    }

}

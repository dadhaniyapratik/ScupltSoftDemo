package com.bkp.sculptsoft.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 24-12-2016.
 */

public class AddPostResponse {
    @SerializedName("GetSellingListResult")
    @Expose
    private GetSellingListResult getSellingListResult;

    public GetSellingListResult getGetSellingListResult() {
        return getSellingListResult;
    }

    public void setGetSellingListResult(GetSellingListResult getSellingListResult) {
        this.getSellingListResult = getSellingListResult;
    }

    public AddPostResponse withGetSellingListResult(GetSellingListResult getSellingListResult) {
        this.getSellingListResult = getSellingListResult;
        return this;
    }

}
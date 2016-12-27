package com.bkp.sculptsoft.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 24-12-2016.
 */

/**
 * Added
 */

public class RootRequest {
    @SerializedName("request")
    @Expose
    private Request request;


    public RootRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
}

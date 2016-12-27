package com.bkp.sculptsoft.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 24-12-2016.
 */

public class AddPostRequest {
    @SerializedName("request")
    @Expose
    private Request request;

    public AddPostRequest(Request request) {
        this.request= request;

    }

    public AddPostRequest(String s, String s1, String s2, String s3, String s4) {
    }


    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public AddPostRequest withRequest(Request request) {
        this.request = request;
        return this;
    }

}


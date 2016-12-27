package com.bkp.sculptsoft.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by User on 24-12-2016.
 */

public class Request {
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("pageIndex")
    @Expose
    private String pageIndex;
    @SerializedName("pageSize")
    @Expose
    private String pageSize;
    @SerializedName("sorttype")
    @Expose
    private String sorttype;

    public Request(String s, String s1, String s2, String s3, String s4) {
        this.latitude=s;
        this.longitude=s1;
        this.pageIndex=s2;
        this.pageSize=s3;
        this.sorttype=s4;

    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Request withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Request withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Request withPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Request withPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getSorttype() {
        return sorttype;
    }

    public void setSorttype(String sorttype) {
        this.sorttype = sorttype;
    }

    public Request withSorttype(String sorttype) {
        this.sorttype = sorttype;
        return this;
    }

    public JSONObject toJSON() {
        JSONObject rootJsonObject = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("latitude", this.latitude);
            jsonObject.put("longitude", this.longitude);
            jsonObject.put("pageIndex", this.pageIndex);
            jsonObject.put("pageSize", this.pageSize);
            jsonObject.put("sorttype", this.sorttype);
            rootJsonObject.put("request", jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rootJsonObject;
    }
}

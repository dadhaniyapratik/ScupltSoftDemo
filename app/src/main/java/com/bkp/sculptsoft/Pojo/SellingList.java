package com.bkp.sculptsoft.Pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24-12-2016.
 */

public class SellingList implements Parcelable {
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("imagelist")
    @Expose
    private List<String> imagelist = null;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("miles")
    @Expose
    private String miles;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("shareurl")
    @Expose
    private String shareurl;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("videolist")
    @Expose
    private List<Object> videolist = null;
    @SerializedName("year")
    @Expose
    private String year;

    public boolean getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(boolean checkBox) {
        this.checkBox = checkBox;
    }

    private boolean checkBox;





    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public SellingList withDistance(String distance) {
        this.distance = distance;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SellingList withId(Integer id) {
        this.id = id;
        return this;
    }

    public List<String> getImagelist() {
        return imagelist;
    }

    public void setImagelist(List<String> imagelist) {
        this.imagelist = imagelist;
    }

    public SellingList withImagelist(List<String> imagelist) {
        this.imagelist = imagelist;
        return this;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public SellingList withMake(String make) {
        this.make = make;
        return this;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public SellingList withMiles(String miles) {
        this.miles = miles;
        return this;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public SellingList withModel(String model) {
        this.model = model;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public SellingList withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getShareurl() {
        return shareurl;
    }

    public void setShareurl(String shareurl) {
        this.shareurl = shareurl;
    }

    public SellingList withShareurl(String shareurl) {
        this.shareurl = shareurl;
        return this;
    }

//    public Object getShareurl() {
//        return shareurl;
//    }
//
//    public void setShareurl(Object shareurl) {
//        this.shareurl = shareurl;
//    }
//
//    public SellingList withShareurl(Object shareurl) {
//        this.shareurl = shareurl;
//        return this;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SellingList withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Object> getVideolist() {
        return videolist;
    }

    public void setVideolist(List<Object> videolist) {
        this.videolist = videolist;
    }

    public SellingList withVideolist(List<Object> videolist) {
        this.videolist = videolist;
        return this;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public SellingList withYear(String year) {
        this.year = year;
        return this;
    }

    public SellingList() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.distance);
        dest.writeValue(this.id);
        dest.writeStringList(this.imagelist);
        dest.writeString(this.make);
        dest.writeString(this.miles);
        dest.writeString(this.model);
        dest.writeString(this.price);

        dest.writeString(this.status);
        dest.writeList(this.videolist);
        dest.writeString(this.year);

    }

    protected SellingList(Parcel in) {
        this.distance = in.readString();
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.imagelist = in.createStringArrayList();
        this.make = in.readString();
        this.miles = in.readString();
        this.model = in.readString();
        this.price = in.readString();

        this.status = in.readString();
        this.videolist = new ArrayList<Object>();
        in.readList(this.videolist, Object.class.getClassLoader());
        this.year = in.readString();

    }

    public static final Creator<SellingList> CREATOR = new Creator<SellingList>() {
        @Override
        public SellingList createFromParcel(Parcel source) {
            return new SellingList(source);
        }

        @Override
        public SellingList[] newArray(int size) {
            return new SellingList[size];
        }
    };
}

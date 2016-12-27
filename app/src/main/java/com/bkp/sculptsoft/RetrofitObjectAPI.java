package com.bkp.sculptsoft;

import com.bkp.sculptsoft.Pojo.AddPostResponse;
import com.bkp.sculptsoft.Pojo.RootRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by User on 24-12-2016.
 */

public interface RetrofitObjectAPI {


    @POST("GetSellingList")
    Call<AddPostResponse> addPost(@Body RootRequest addPostRequest);
}
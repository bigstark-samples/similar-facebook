package com.bigstark.similarfacebook.rest;

import com.bigstark.similarfacebook.model.PictureModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PictureService {

    @GET("/list")
    Call<List<PictureModel>> getPictures();
}
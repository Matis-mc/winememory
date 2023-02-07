package com.sherbrooke.winememory.api;

import android.graphics.Bitmap;
import android.media.Image;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    String URL_API = "https://wine-recognition2.p.rapidapi.com/v1/results/";
    String HEADER_KEY = "X-RapidAPI-Key";
    String HEADER_VALUE = "c884ea828emshbfe1321d9bcbad5p194006jsn5f4f0ffb0cff";

    @Headers({"X-RapidAPI-Key:c884ea828emshbfe1321d9bcbad5p194006jsn5f4f0ffb0cff","X-RapidAPI-Host:ine-recognition2.p.rapidapi.com"})
    @POST("/")
    Call<String> analyzeImpage( @Body Image image);


}

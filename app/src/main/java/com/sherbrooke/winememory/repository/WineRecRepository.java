package com.sherbrooke.winememory.repository;

import android.graphics.Bitmap;
import android.media.Image;

import com.sherbrooke.winememory.api.Client;

import retrofit2.Call;
import retrofit2.Callback;

public class WineRecRepository {

    private static WineRecRepository instance;

    private WineRecRepository(){
    }

    public static WineRecRepository getInstance(){
        if(instance == null){
            instance = new WineRecRepository();
        }
        return instance;
    }

    public void sendImage(Image image, Callback<String> callback){
        Call<String> call = Client.getInstance().getApi().analyzeImpage(image);
        call.enqueue(callback);
    }


}

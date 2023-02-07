package com.sherbrooke.winememory.viewmodel;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.sherbrooke.winememory.repository.WineRecRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends ViewModel {

    private Bitmap bitmap;

    public void analyzeImage(Image image){
        WineRecRepository.getInstance().sendImage(image, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("response ok :", response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("response not ok :", t.getMessage());
            }
        });
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}

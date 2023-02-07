package com.sherbrooke.winememory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.extensions.HdrImageCaptureExtender;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.common.util.concurrent.ListenableFuture;
import com.sherbrooke.winememory.viewmodel.MainActivityViewModel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ImageButton addBottleBtn, goToCaveBtn, searchBtn, penBtn, cameraBtn;

    private static final int pic_id = 123;

    private MainActivityViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        penBtn.setVisibility(View.INVISIBLE);
        cameraBtn.setVisibility(View.INVISIBLE);

        addBottleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penBtn.setVisibility(View.VISIBLE);
                cameraBtn.setVisibility(View.VISIBLE);
                addBottleBtn.setVisibility(View.INVISIBLE);
            }
        });

        penBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddBottle.class));
                overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
            }
        });

        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);*/
                startActivity(new Intent(MainActivity.this, CameraActivity.class));

            }
        });

        goToCaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DegustationView.class));
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            //model.setBitmap(photo);
            Log.i("photo ok", "!");
        }
    }




    public void init(){
        addBottleBtn = findViewById(R.id.add_btn);
        goToCaveBtn = findViewById(R.id.go_to_cave_btn);
        searchBtn = findViewById(R.id.search_btn);
        penBtn = findViewById(R.id.pen_btn);
        cameraBtn = findViewById(R.id.camera_btn);
    }
}
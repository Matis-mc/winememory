package com.sherbrooke.winememory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.sherbrooke.winememory.adapter.DegustationPageAdapter;
import com.sherbrooke.winememory.dao.DegustationDao;
import com.sherbrooke.winememory.database.DegustationDatabase;
import com.sherbrooke.winememory.model.Degustation;

import java.util.List;

public class DegustationView extends AppCompatActivity {

    private ViewPager viewPager;
    private DegustationDao dao;
    private DegustationDatabase database;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_degustation_view);
        database = Room.databaseBuilder(getApplicationContext(), DegustationDatabase.class, "wmDb").allowMainThreadQueries().build();
        dao = database.degustationDao();

        List<Degustation> degustations = dao.getAll();

        init();

        viewPager.setAdapter(new DegustationPageAdapter(getSupportFragmentManager(), degustations));

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DegustationView.this, MainActivity.class));
            }
        });

    }

    private void init(){
        viewPager = findViewById(R.id.degustation_view_pager);
        backBtn = findViewById(R.id.back_btn);
    }
}
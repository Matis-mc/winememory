package com.sherbrooke.winememory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.sherbrooke.winememory.dao.DegustationDao;
import com.sherbrooke.winememory.database.DegustationDatabase;
import com.sherbrooke.winememory.model.Degustation;
import com.sherbrooke.winememory.model.Type;

import java.util.Optional;

public class AddBottle extends AppCompatActivity {

    ImageView bottleView;
    EditText nom, appelation, annee, commentaire;
    SeekBar equilibre, harmonie, complexite, persistance, note;
    RadioButton blancRd, rougeRd, roseRd, petillantRd;
    ImageButton valider;

    private DegustationDao dao;
    private DegustationDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bottle);
        init();
        database = Room.databaseBuilder(getApplicationContext(), DegustationDatabase.class, "wmDb").allowMainThreadQueries().build();
        dao = database.degustationDao();

        roseRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getResources().getIdentifier("@drawable/rose", null, getPackageName());
                Drawable res = getResources().getDrawable(id);
                bottleView.setImageDrawable(res);
            }
        });

        blancRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getResources().getIdentifier("@drawable/blanc", null, getPackageName());
                Drawable res = getResources().getDrawable(id);
                bottleView.setImageDrawable(res);
            }
        });

        rougeRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getResources().getIdentifier("@drawable/rouge", null, getPackageName());
                Drawable res = getResources().getDrawable(id);
                bottleView.setImageDrawable(res);
            }
        });

        petillantRd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = getResources().getIdentifier("@drawable/petillant", null, getPackageName());
                Drawable res = getResources().getDrawable(id);
                bottleView.setImageDrawable(res);
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Degustation degustation = setDegustationFromForm().orElseThrow(
                            () -> new IllegalArgumentException()
                    );
                    dao.insert(degustation);
                    Toast.makeText(getApplicationContext(), "Enregistré", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AddBottle.this, MainActivity.class));
                } catch (IllegalArgumentException e){
                    Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private Optional<Degustation> setDegustationFromForm(){
        if(this.nom.getText().toString().equals("")
                || this.appelation.getText().toString().equals("")
                || this.annee.getText().toString().equals("")){
            return Optional.empty();
        }
        Type type = getTypeForm();
        Degustation degustation = new Degustation(type,
                appelation.getText().toString(),
                Integer.valueOf(annee.getText().toString()),
                nom.getText().toString(),
                equilibre.getProgress(),
                harmonie.getProgress(),
                complexite.getProgress(),
                persistance.getProgress(),
                note.getProgress(),
                commentaire.getText().toString()
                );
        return Optional.of(degustation);

    }

    private Type getTypeForm(){
        if(blancRd.isChecked()){
            return Type.BLANC;
        } else if(rougeRd.isChecked()){
            return Type.ROUGE;
        } else if(roseRd.isChecked()){
            return Type.ROSE;
        }
        return Type.PETILLANT;
    }

    private void init(){
        bottleView = findViewById(R.id.bottle_view);
        nom = findViewById(R.id.name);
        appelation = findViewById(R.id.appelation_txt);
        annee = findViewById(R.id.year_txt);
        commentaire = findViewById(R.id.commentaire_txt);
        equilibre = findViewById(R.id.seekBar_equilibre);
        harmonie = findViewById(R.id.seekBar_harmonie);
        complexite = findViewById(R.id.seekBar_complexite);
        persistance = findViewById(R.id.seekBar_persistance);
        note = findViewById(R.id.seekBar);
        blancRd = findViewById(R.id.blanc_btn);
        rougeRd = findViewById(R.id.rouge_btn);
        roseRd = findViewById(R.id.rose_btn);
        petillantRd = findViewById(R.id.petillant_btn);
        valider = findViewById(R.id.valider_btn);
    }
}
package com.sherbrooke.winememory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherbrooke.winememory.model.Degustation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DegustationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DegustationFragment extends Fragment {

    private TextView nom, year, appelation, noteEquilibre, noteHarmonie, notePersistance, noteComplexite, noteGenerale;
    private ImageView vinImg;
    private static final String KEY_POSITION="position";
    private static final String KEY_DEGUSTATION="degustation";


    public DegustationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param position Parameter 1.
     * @param degustation Parameter 2.
     * @return A new instance of fragment DegustationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DegustationFragment newInstance(int position, Degustation degustation) {
        DegustationFragment fragment = new DegustationFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putSerializable(KEY_DEGUSTATION, degustation);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_degustation, container, false);

        nom = result.findViewById(R.id.fr_nom);
        year = result.findViewById(R.id.fr_annee);
        appelation = result.findViewById(R.id.fr_appelation);
        noteEquilibre = result.findViewById(R.id.fr_note_equilibre);
        noteHarmonie = result.findViewById(R.id.fr_note_harmonie);
        notePersistance = result.findViewById(R.id.fr_note_persistance);
        noteComplexite = result.findViewById(R.id.fr_note_complexite);
        noteGenerale = result.findViewById(R.id.fr_note_general);
        vinImg = result.findViewById(R.id.fr_vin_img);

        Degustation degustation = (Degustation)getArguments().getSerializable(KEY_DEGUSTATION);
        nom.setText(degustation.getNom());
        appelation.setText(degustation.getAppelation());
        year.setText(String.valueOf(degustation.getYear()));
        noteEquilibre.setText(String.valueOf(degustation.getEquilibre()));
        noteComplexite.setText(String.valueOf(degustation.getComplexite()));
        noteHarmonie.setText(String.valueOf(degustation.getHarmonie()));
        notePersistance.setText(String.valueOf(degustation.getPersistance()));
        noteGenerale.setText(String.valueOf(degustation.getNote()));

        String imgPath = "";

        switch (degustation.getType()){
            case ROSE :
                imgPath = "@drawable/rose";
                break;

            case BLANC :
                imgPath = "@drawable/blanc";
                break;

            case ROUGE :
                imgPath = "@drawable/rouge";
                break;

            case PETILLANT :
                imgPath = "@drawable/petillant";
                break;
        }

        int id = getResources().getIdentifier(imgPath, null, getActivity().getPackageName());
        Drawable res = getResources().getDrawable(id);
        vinImg.setImageDrawable(res);

        return result;
    }
}
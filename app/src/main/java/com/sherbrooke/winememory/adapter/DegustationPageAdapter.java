package com.sherbrooke.winememory.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sherbrooke.winememory.DegustationFragment;
import com.sherbrooke.winememory.model.Degustation;

import java.util.List;

public class DegustationPageAdapter extends FragmentPagerAdapter {

    private List<Degustation> degustations;

    public DegustationPageAdapter(@NonNull FragmentManager fm, List<Degustation> degustations) {
        super(fm);
        this.degustations = degustations;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return DegustationFragment.newInstance(position, this.degustations.get(position));
    }

    @Override
    public int getCount() {
        return degustations.size();
    }
}

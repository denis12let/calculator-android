package com.example.lab1_calcularor.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.lab1_calcularor.fragments.AddFragment;
import com.example.lab1_calcularor.fragments.RemoveFragment;
import com.example.lab1_calcularor.fragments.ShowFragment;
import com.example.lab1_calcularor.fragments.UpdateFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    static final int FRAGMENTS_COUNT = 4;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ShowFragment();
            case 1:
                return new AddFragment();
            case 2:
                return new UpdateFragment();
            case 3:
                return new RemoveFragment();
            default:
                return new ShowFragment();
        }
    }

    @Override
    public int getCount() {
        return FRAGMENTS_COUNT;
    }
}
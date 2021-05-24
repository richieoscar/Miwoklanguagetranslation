package com.richieoscar.miwok.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.richieoscar.miwok.ui.ColorFragment;
import com.richieoscar.miwok.ui.FamilyFragment;
import com.richieoscar.miwok.ui.NumberFragment;
import com.richieoscar.miwok.ui.PhraseFragment;

public class WordPagerAdapter extends FragmentPagerAdapter {
    public WordPagerAdapter(@NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumberFragment();
            case 1:
                return new FamilyFragment();
            case 2:
                return new ColorFragment();
            case 3:
                return new PhraseFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Numbers";
            case 1:
                return "Family";
            case 2:
                return "Colors";
            case 3:
                return "Phrase";
        }
        return super.getPageTitle(position);
    }
}

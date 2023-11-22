package com.maturanec.pmalv1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new StudentFragment();
            case 1:
                return new PredmetFragment();
            case 2:
                return new SveFragment();
            default:
                return new StudentFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

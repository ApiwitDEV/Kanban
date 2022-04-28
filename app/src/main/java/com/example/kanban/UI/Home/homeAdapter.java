package com.example.kanban.UI.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.kanban.addTab_Fragment;

public class homeAdapter extends FragmentStateAdapter {

    public homeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:return new workDone_Fragment();
            case 2:return new addTab_Fragment();
            default:return new unfinished_Work_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return Home_Fragment.NTab;
    }
}

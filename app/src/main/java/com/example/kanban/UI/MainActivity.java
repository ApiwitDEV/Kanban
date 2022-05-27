package com.example.kanban.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.example.kanban.R;
import com.example.kanban.UI.Home.Home_Fragment;
import com.example.kanban.viewModel.LayoutInfo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static LayoutInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        info = new ViewModelProvider(this).get(LayoutInfo.class);

        info.heightPx = displayMetrics.heightPixels;
        info.widthPx = displayMetrics.widthPixels;

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainframe,new Home_Fragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home_nav:selectedFragment = new Home_Fragment();break;
                case R.id.statistic_nav:selectedFragment = new Statistic_Fragment();break;
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainframe,selectedFragment)
                    .commit();

            return true;
        }
    };
}
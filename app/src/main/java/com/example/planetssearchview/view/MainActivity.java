package com.example.planetssearchview.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.planetssearchview.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflateFragment();
    }

    private void inflateFragment() {
        getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.main_activity_root_layout, PlanetsFragment.newInstance())
          .commit();
    }

}

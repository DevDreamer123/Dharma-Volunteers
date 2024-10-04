package com.example.dharmavolunteers;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dharmavolunteers.UI.CommunityFragment;
import com.example.dharmavolunteers.UI.EventsFragment;
import com.example.dharmavolunteers.UI.HomeFragment;
import com.example.dharmavolunteers.UI.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showHomeFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                int id = item.getItemId();

                if(id == R.id.home) {
                    transaction.replace(R.id.container, new HomeFragment());
                }

                    if (id == R.id.events) {
                        transaction.replace(R.id.container, new EventsFragment());

                    }
                    if (id == R.id.community) {
                        transaction.replace(R.id.container, new CommunityFragment());
                    }

                        if (id == R.id.profile) {
                            transaction.replace(R.id.container, new ProfileFragment());

                        }
                        transaction.commit();
                        return true;
                    }
        });


    }

    private void showHomeFragment() {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();
    }
}
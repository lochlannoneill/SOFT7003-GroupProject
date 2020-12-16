package com.example.groupapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class ActivityLogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

        DrawerLayout drawerLayout;
        ActionBarDrawerToggle toggle;
        NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        final TextView txtRegisterLink = this.findViewById(R.id.textviewRegisterLink);
        txtRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityLogin.this.startActivity(new Intent(ActivityLogin.this, ActivityRegister.class));
            }
        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        //            setContentView(R.layout.activity_login);

        if (item.getItemId() == R.id.menu_home) {
            setContentView(R.layout.activity_main);
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
        }
//        else if (item.getItemId() == R.id.menu_login_or_register) {
//            Intent newIntent = new Intent(this, ActivityLogin.class);
//            startActivity(newIntent);
//        }
        else if (item.getItemId() == R.id.menu_logout) {
            Toast.makeText(this, "Placeholder Text", Toast.LENGTH_SHORT).show();
            Intent newIntent = new Intent(this, ActivityLogin.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_reviews) {
            Intent newIntent = new Intent(this, ActivityReviews.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_specifications) {
            Intent newIntent = new Intent(this, ActivitySpecifications.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_history) {
            Intent newIntent = new Intent(this, ActivityHistory.class);
            startActivity(newIntent);
        }
        else if (item.getItemId() == R.id.menu_support) {
            Intent newIntent = new Intent(this, ActivitySupport.class);
            startActivity(newIntent);
        }
        return false;
    }

}
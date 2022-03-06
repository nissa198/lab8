package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    boolean appBarIconClicked = false;
    TextView textView;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView appBarIcon;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     setContentView(getLayoutResourceId());
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        appBarIcon = findViewById(R.id.appbar_icon);
        appBarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appBarIconClicked == false) {
                    drawerLayout.openDrawer(GravityCompat.START);
                    appBarIcon.setImageResource(R.drawable.ic_back_arrow);
                    appBarIconClicked = true;
                } else {
                    appBarIcon.setImageResource(R.drawable.ic_menu);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    appBarIconClicked = false;
                }
            }
        });
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nav_home && CheckActivity.onHomeActivity == false) {
                    intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.nav_dad_joke && CheckActivity.onDadActivity == false) {
                    intent = new Intent(getBaseContext(), DadJoke.class);
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                if (item.getItemId() == R.id.nav_exit) {
                    finishAffinity();
                }
                return true;
            }
        });
    }
   protected abstract int getLayoutResourceId();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_file, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        try {
            if (item.getItemId() == R.id.item1) {
                Toast.makeText(getApplicationContext(), "You clicked on item 1", Toast.LENGTH_LONG).show();
                return true;
            }
            if (item.getItemId() == R.id.item2) {
                Toast.makeText(getApplicationContext(), "You clicked on item 2", Toast.LENGTH_LONG).show();
                return true;
            }
        } catch (Exception e) {
            Log.i("my bug", e.toString());
        }
        return super.onOptionsItemSelected(item);
    }
}


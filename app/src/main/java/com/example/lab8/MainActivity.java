package com.example.lab8;



import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Slide;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckActivity.onHomeActivity = true;
        CheckActivity.onDadActivity = false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

}
package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DadJoke extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CheckActivity.onDadActivity = true;
        CheckActivity.onHomeActivity = false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_dad_joke;
    }
}
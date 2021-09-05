package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ColorConfigActivity extends AppCompatActivity {

    private Button buttonAzul;
    private Button buttonBlanco;
    private Button buttonGris;
    private ConstraintLayout backLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_config);

        backLayout = findViewById(R.id.backLayout);
        SharedPreferences sp= getSharedPreferences("grades_app",MODE_PRIVATE);

        buttonBlanco= findViewById(R.id.buttonBlanco);
        buttonBlanco.setOnClickListener((view)->{
            sp.edit().putString("color","#FFFFFF").apply();
            finish();

        });
        buttonAzul= findViewById(R.id.buttonAzul);
        buttonAzul.setOnClickListener((view)->{
            sp.edit().putString("color","#0000FF").apply();
            finish();

        });

        buttonGris = findViewById(R.id.buttonGris);
        buttonGris.setOnClickListener((view)->{
            sp.edit().putString("color","#AAAAAA").apply();
            finish();

        });
    }

    protected void onResume(){
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app", MODE_PRIVATE);
        String color= sp.getString("color",  "#FFFFFF");
        backLayout.setBackgroundColor(Color.parseColor(color));
    }
}
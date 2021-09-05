package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;
public class MainActivity extends AppCompatActivity {

   // private Button login;
    private ConstraintLayout backLayout;
    private Button configBtn;
    private Button nextBtn;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backLayout = findViewById(R.id.backLayout);
        configBtn = findViewById(R.id.configBtn);
        nextBtn = findViewById(R.id.nextBtn);
        name = findViewById(R.id.name);
        SharedPreferences sp= getSharedPreferences("grades_app",MODE_PRIVATE);
        onResume();
        configBtn.setOnClickListener((view) -> {
                 Intent configIntent = new Intent(this, ColorConfigActivity.class);
                 startActivity(configIntent);
                });

       //cuando ingresa el nombre y click en el boton de continuar

        nextBtn.setOnClickListener((view) -> {
            if(!name.getText().toString().replaceAll(" ","").isEmpty()){
                sp.edit().putString("name",name.getText().toString().trim()).apply();
                Intent notaIntent = new Intent(this, CalcularNotaActivity.class);
                startActivity(notaIntent);
            }


        });

    }
        protected void onResume(){
        super.onResume();
            SharedPreferences sp= getSharedPreferences("grades_app",MODE_PRIVATE);
            String color= sp.getString("color",  "#FFFFFF");

            backLayout.setBackgroundColor(Color.parseColor(color));
        }



    }

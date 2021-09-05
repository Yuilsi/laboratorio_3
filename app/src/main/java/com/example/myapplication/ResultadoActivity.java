package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textEnunciado;
    private TextView textNotaFinal;
    private Button calcularOtraVezBtn;
    private ConstraintLayout backLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        backLayout = findViewById(R.id.backLayout);
        textEnunciado = findViewById(R.id.textEnunciado);
        textNotaFinal = findViewById(R.id.textNotaFinal);
        calcularOtraVezBtn = findViewById(R.id.calcularOtraVezBtn);



        calcularOtraVezBtn.setOnClickListener(
                (v)->{
                    Intent calcularOtraVez= new Intent(this,MainActivity.class);
                    startActivity(calcularOtraVez);
                }
        );

    }
    protected void onResume(){
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app",MODE_PRIVATE);
        String color= sp.getString("color",  "#FFFFFF");

        backLayout.setBackgroundColor(Color.parseColor(color));
        textEnunciado.setText("Hola" + sp.getString("name","")+",tu nota final es de: ");
        String nota= Float.toString((getIntent().getExtras().getFloat("nota")));
        String total= nota.substring(0,3);
        textNotaFinal.setText(total);

    }
}
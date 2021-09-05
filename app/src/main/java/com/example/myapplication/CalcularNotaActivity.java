package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CalcularNotaActivity extends AppCompatActivity {

    private ConstraintLayout backLayout;
    private EditText proyectoParcial1Editx;
    private EditText proyectoParcial2Editx;
    private EditText QuicesEditx;
    private EditText parcial1Editx;
    private EditText parcial2Editx;
    private Button calcularBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_nota);
        backLayout = findViewById(R.id.backLayout);
        proyectoParcial1Editx = findViewById(R.id.proyectoParcial1Editx);
        proyectoParcial2Editx = findViewById(R.id.proyectoParcial2Editx);
        QuicesEditx = findViewById(R.id.QuicesEditx);
        parcial1Editx = findViewById(R.id.parcial1Editx);
        parcial2Editx = findViewById(R.id.parcial2Editx);
        calcularBtn = findViewById(R.id.calcularBtn);

        calcularBtn.setOnClickListener(
        (v)->{
            if(!proyectoParcial1Editx.getText().toString().isEmpty()&&!proyectoParcial2Editx.getText().toString().isEmpty()&&
                    !QuicesEditx.getText().toString().isEmpty()&& !parcial1Editx.getText().toString().isEmpty()&&!parcial2Editx.getText().toString().isEmpty()) {
                float total = (float) notaFinal();
                Intent resultado= new Intent(this,ResultadoActivity.class);
                resultado.putExtra("nota",total);
                startActivity(resultado);
            }
        }
        );
    }

    public double notaFinal(){
        float pp1;
        float pp2;
        float quices;
        float p1;
        float p2;
        float total;

        pp1= Float.parseFloat(proyectoParcial1Editx.getText().toString());
        pp2= Float.parseFloat(proyectoParcial2Editx.getText().toString());
        quices = Float.parseFloat(QuicesEditx.getText().toString());
        p1= Float.parseFloat(parcial1Editx.getText().toString());
        p2= Float.parseFloat(parcial2Editx.getText().toString());

        total= (float)((pp1*0.25)+(pp2*0.25)+(quices*0.15)+(p1*0.15)+(p2*0.15));
        return total;
    }

    protected void onResume(){
        super.onResume();
        SharedPreferences sp= getSharedPreferences("grades_app", MODE_PRIVATE);
        String color= sp.getString("color",  "#FFFFFF");
        backLayout.setBackgroundColor(Color.parseColor(color));
    }


}
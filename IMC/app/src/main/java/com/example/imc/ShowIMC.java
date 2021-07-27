package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowIMC extends AppCompatActivity {

    private TextView nome, peso, altura, imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_imc);

        nome = findViewById(R.id.stcNome);
        peso = findViewById(R.id.stcPeso);
        altura = findViewById(R.id.stcAltura);
        imc = findViewById(R.id.stcIMC);

        Bundle bundle = getIntent().getExtras();
        String strNome = bundle.getString("nome");
        String strPeso = bundle.getString("peso");
        String strAltura = bundle.getString("altura");

        double dPeso = Double.parseDouble(strPeso);
        double dAltura = Double.parseDouble(strAltura);
        Double dIMC = dPeso / (dAltura * dAltura);

        nome.setText(strNome);
        peso.setText(strPeso);
        altura.setText(strAltura);
        imc.setText(String.format("IMC %.2f", dIMC));
    }
}
package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowIMC extends AppCompatActivity {

    private TextView nome, peso, altura, imc, imcInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_imc);

        nome = findViewById(R.id.stcNome);
        peso = findViewById(R.id.stcPeso);
        altura = findViewById(R.id.stcAltura);
        imc = findViewById(R.id.stcIMC);
        imcInfo = findViewById(R.id.stcIMCInfo);

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
        imcInfo.setText(getIMCInfo(dIMC));
    }

    private String getIMCInfo(double imc) {
        if (imc <= 18.5)
            return "Abaixo do peso";
        if (imc <= 24.9)
            return "Peso ideal";
        if (imc <= 29.9)
            return "Levemente acima do peso";
        if (imc <= 34.9)
            return "Obesidade grau 1";
        if (imc <= 39.9)
            return "Obesidade grau 2 (severa)";

        return "Obesidade grau 3 (mórbida)";
    }
}
package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nome, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.edtNome);
        peso = findViewById(R.id.edtPeso);
        altura = findViewById(R.id.edtAltura);
    }

    public void abrirTela(View view) {
        Intent i = new Intent(this, ShowIMC.class);

        String strNome = nome.getText().toString();
        i.putExtra("nome", strNome);

        String strPeso = peso.getText().toString();
        i.putExtra("peso", strPeso);

        String strAltura = altura.getText().toString();
        i.putExtra("altura", strAltura);

        startActivity(i);

    }
}
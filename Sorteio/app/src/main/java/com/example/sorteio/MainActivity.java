package com.example.sorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView n1, n2, value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortear(View view) {
        n1 = findViewById(R.id.edtN1);
        n2 = findViewById(R.id.edtN2);

        int number1 = Integer.parseInt(n1.getText().toString());
        int number2 = Integer.parseInt(n2.getText().toString());

        if (number1 > number2)
        {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        /*
        n1.setText("");
        n2.setText("");
        */

        value = findViewById(R.id.stcResultado);
        value.setText(String.valueOf((int) Math.floor(Math.random() * (number2 - number1 + 1) + number1)));
    }
}
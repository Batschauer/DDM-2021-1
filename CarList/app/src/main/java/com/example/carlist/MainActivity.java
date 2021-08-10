package com.example.carlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvCarros);

        CarroController controller = new CarroController();

        CarroAdapter adapter = new CarroAdapter(this, R.layout.layout_carros, new ArrayList<Carro>(Arrays.asList(controller.CARROS)));
        listView.setAdapter(adapter);
    }
}
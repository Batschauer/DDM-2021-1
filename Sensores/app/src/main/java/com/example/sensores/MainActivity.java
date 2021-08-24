package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        List<Sensor> listSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        ArrayList<String> listNameSensors = new ArrayList<String>();

        for (Sensor s : listSensors) {
            listNameSensors.add(s.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.custom_textview,
                listNameSensors
        );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Sensor> listSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
                int type = listSensors.get(position).getType();

                Intent intent = new Intent(getApplicationContext(), DetailSensor.class);
                intent.putExtra("type", type);
                startActivity(intent);
            }
        });
    }
}
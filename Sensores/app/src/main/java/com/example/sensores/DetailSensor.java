package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailSensor extends AppCompatActivity implements SensorEventListener {

    TextView mTextView;
    ListView mListView;

    Sensor mSensor;
    SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sensor);

        mTextView = findViewById(R.id.stcSensor);
        mListView = findViewById(R.id.listViewDetails);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        Bundle bundle = getIntent().getExtras();
        int typeSensor = bundle.getInt("type");

        mSensor = mSensorManager.getDefaultSensor(typeSensor);
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();

        ArrayList<String> values = new ArrayList<String>();
        for (int idx = 0; idx < event.values.length; ++idx){
            values.add(Float.toString(event.values[idx]));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.custom_textview,
                values
        );

        mListView.setAdapter(arrayAdapter);
        mTextView.setText(event.sensor.getName());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        mSensorManager.unregisterListener(this, mSensor);

        super.onDestroy();
    }
}
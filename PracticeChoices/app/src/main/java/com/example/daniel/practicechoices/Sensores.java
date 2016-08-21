package com.example.daniel.practicechoices;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.R;
import android.R.*;

public class Sensores extends AppCompatActivity {
    SensorManager sensorManager;
    Sensor sensor;
    EditText x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_sensores);

        x = (EditText)findViewById(id.etxtejex);
        y = (EditText)findViewById(id.etxtEjeY);
        z = (EditText)findViewById(id.etxtEjeZ);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    //@Override
    public void onSensorChanged(SensorEvent sensorEvent){
        float a = sensorEvent.values[0];
        float b = sensorEvent.values[1];
        float c = sensorEvent.values[2];

        x.setText("Posicion x: "+a+" ");
        y.setText("Posicion y: "+b+" ");
        z.setText("Posicion z: "+c+" ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener((SensorEventListener) this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        // The activity has become visible (it is now "resumed").
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener((SensorEventListener) this);
        // Another activity is taking focus (this activity is about to be "paused").
    }
}

package com.example.parcial3_castaneda;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.widget.LinearLayout;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    private SensorManager sensorManager;
    Sensor luz;
    Sensor acelerometro;
    Sensor temperatura;
    Sensor orientacion;
    Sensor posicion;
    LinearLayout front;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        front = (LinearLayout) findViewById(R.id.fondo);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sm.getDefaultSensor(Sensor.TYPE_LIGHT) != null){
            // Success! There's a magnetometer.
            //front.setBackgroundColor(Color.parseColor("#0000FF"));
        } else {
            // Failure! No magnetometer.

        }
        if (sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            // Success! There's a magnetometer.
            //front.setBackgroundColor(Color.parseColor("#0000FF"));
        } else {
            // Failure! No magnetometer.

        }
        if (sm.getDefaultSensor(Sensor.TYPE_ORIENTATION) != null){
            // Success! There's a magnetometer.
            //front.setBackgroundColor(Color.parseColor("#0000FF"));
        } else {
            // Failure! No magnetometer.

        }
        if (sm.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR) != null){
            // Success! There's a magnetometer.
            //front.setBackgroundColor(Color.parseColor("#0000FF"));
        } else {
            // Failure! No magnetometer.

        }
        if (sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
            // Success! There's a magnetometer.
            //front.setBackgroundColor(Color.parseColor("#0000FF"));
        } else {
            // Failure! No magnetometer.

        }


    }
}
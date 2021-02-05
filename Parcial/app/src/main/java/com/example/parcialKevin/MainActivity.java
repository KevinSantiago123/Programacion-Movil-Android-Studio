package com.example.parcialKevin;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sm;
    Sensor acelerometro;
    LinearLayout front;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        front = (LinearLayout) findViewById(R.id.fondo);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro  =sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener((SensorEventListener) this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent valores) {
        final Vibrator vibrador = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);

        if(valores.values[2] <=-46){
            front.setBackgroundColor(Color.parseColor("#0000FF"));
            vibrador.vibrate(600);
        }else if(valores.values[2] <=10 && valores.values[1] >=-10){
            front.setBackgroundColor(Color.parseColor("#F0FFFF"));
            vibrador.vibrate(50);
        }else if(valores.values[2] >=46) {
            front.setBackgroundColor(Color.parseColor("#FFD700"));
            vibrador.vibrate(250);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
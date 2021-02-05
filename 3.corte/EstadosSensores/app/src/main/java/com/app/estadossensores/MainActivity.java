package com.app.estadossensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView sensorLuztext, acelerometrotext, orientaciontext, temperaturatext, posiciongpstext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorLuztext = (TextView) findViewById(R.id.lightsensor);
        acelerometrotext = (TextView) findViewById(R.id.accelerometro);
        orientaciontext = (TextView) findViewById(R.id.orientacion);
        temperaturatext = (TextView) findViewById(R.id.temperatura);
        posiciongpstext = (TextView) findViewById(R.id.posicion);


        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        Sensor LightSensor = mySensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        Sensor accelerometro = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        Sensor orientacion = mySensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        Sensor tempraturaambiente = mySensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            posiciongpstext.setText("Sensor de posicion activo: Si");
        } else {
            posiciongpstext.setText("Sensor de posicion activo: No");
        }

        if(LightSensor != null){
            sensorLuztext.setText("Sensor de luz activo: Si");
        }else{
            //Sensor.TYPE_LIGHT NOT Available;
            sensorLuztext.setText("Sensor de luz activo: No");
        }

        if(orientacion != null){
            orientaciontext.setText("Sensor de orientacion activo: Si");
        }else{
            //Sensor.TYPE_LIGHT NOT Available;
            orientaciontext.setText("Sensor de orientacion activo: No");
        }

        if(tempraturaambiente != null){
            temperaturatext.setText("Sensor de temperatura activo: Si");
        }else{
            //Sensor.TYPE_LIGHT NOT Available;
            temperaturatext.setText("Sensor de temperatura activo: No");
        }

        if(accelerometro != null){
            acelerometrotext.setText("Sensor de acelerometro activo: Si");
        }else{
            //Sensor.TYPE_LIGHT NOT Available;
            acelerometrotext.setText("Sensor de acelerometro activo: No");
        }
    }
}

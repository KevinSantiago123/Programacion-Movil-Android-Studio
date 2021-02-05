package com.example.projectautentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class ActDashboard extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_dashboard);

        textView = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle!=null) {
            textView.setText( "Bienvenido señor(a): " + bundle.get("usuario").toString());
        }
    }
}
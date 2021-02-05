package com.app.session8;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
    Button button;
    CheckBox checkA, checkB, checkC;
    RadioGroup radioGroup;
    TextView txtInicio, txtProgreso, txtFinal;
    SeekBar seekBar;
    String[] elementos = {"Jeisson", "Pedro", "Maria", "Juan", "Simon"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkA = (CheckBox)  findViewById(R.id.checkBox);
        checkB = (CheckBox) findViewById(R.id.checkBox2);
        checkC= (CheckBox)  findViewById(R.id.checkBox3);
        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        txtInicio = (TextView) findViewById(R.id.txtStart);
        txtProgreso = (TextView) findViewById(R.id.txtProgress);
        txtFinal = (TextView) findViewById(R.id.txtStop);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        listView = (ListView) findViewById(R.id.usuarios);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, elementos);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Toast.makeText(getApplicationContext(), listView.getItemAtPosition(posicion).toString(), Toast.LENGTH_LONG).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuffer result = new StringBuffer();
                result.append("Televisión: ").append(checkA.isChecked());
                result.append("Deportes: ").append(checkB.isChecked());
                result.append("Cultura: ").append(checkC.isChecked());
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idChecked) {
                if (idChecked == R.id.radioButton){
                    Toast.makeText(getApplicationContext(), "Seleccionaste SI", Toast.LENGTH_LONG).show();
                } else if(idChecked == R.id.radioButton2){
                    Toast.makeText(getApplicationContext(), "Seleccionaste NO", Toast.LENGTH_LONG).show();
                } else if(idChecked == R.id.radioButton3){
                    Toast.makeText(getApplicationContext(), "Seleccionaste No sabe/No responde", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int valor, boolean b) {
        txtProgreso.setText(valor);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        txtInicio.setText(seekBar.getProgress());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        txtFinal.setText(seekBar.getProgress());
    }
}
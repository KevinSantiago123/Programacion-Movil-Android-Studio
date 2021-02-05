package com.example.fragmentos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Fragment fragment1, fragment2, fragment3, fragment4, fragment5; //Definimos las variables para los fragmentos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inicializamos las instancias
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        //Establecemos el fragmento de inicio
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments,
                fragment1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.fragment1) {
            FragmentTransaction mTransactiont = getSupportFragmentManager().beginTransaction();
            mTransactiont.replace(R.id.contenedorFragments, fragment1, fragment1.getClass().getName());
            mTransactiont.commit();
        } else if(item.getItemId() == R.id.fragment2) {
            FragmentTransaction mTransactiont = getSupportFragmentManager().beginTransaction();
            mTransactiont.replace(R.id.contenedorFragments, fragment2, fragment2.getClass().getName());
            mTransactiont.commit();
        } else if(item.getItemId() == R.id.fragment3) {
            FragmentTransaction mTransactiont = getSupportFragmentManager().beginTransaction();
            mTransactiont.replace(R.id.contenedorFragments, fragment3, fragment2.getClass().getName());
            mTransactiont.commit();
        } else if(item.getItemId() == R.id.fragment4) {
            FragmentTransaction mTransactiont = getSupportFragmentManager().beginTransaction();
            mTransactiont.replace(R.id.contenedorFragments, fragment4, fragment4.getClass().getName());
            mTransactiont.commit();
        } else if(item.getItemId() == R.id.fragment5) {
            FragmentTransaction mTransactiont = getSupportFragmentManager().beginTransaction();
            mTransactiont.replace(R.id.contenedorFragments, fragment5, fragment5.getClass().getName());
            mTransactiont.commit();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
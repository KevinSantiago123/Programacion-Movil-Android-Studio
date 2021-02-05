package com.example.mimensajero;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mimensajero.ui.main.CustomAdapter;

public class TabContactos extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View rootView = inflater.inflate(R.layout.activity_grid, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            GridView gridview = (GridView) view.findViewById(R.id.grid_view);
            CustomAdapter customAdapter = new CustomAdapter(view.getContext(), names, image);
            gridview.setAdapter(customAdapter);
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(view.getContext(), "Tu Equipo Seleccionado Fue : " + position, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }

    }

    String TAG = TabContactos.class.getSimpleName();

    int image[] = {R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3,
            R.drawable.imagen4, R.drawable.imagen5, R.drawable.imagen_6,
            R.drawable.imagem_7, R.drawable.imagen_8, R.drawable.imagen_9,
            R.drawable.imagen_10, R.drawable.imagen_11, R.drawable.imagen_12};
    String names[] = {"Lasagna", "Hambur", "Sandwich", "Pechuga","Sushi" ,"Hambur", "Empanad", "Chicharro", "Cereal", "P. Plancha", "Panzeroti" , "Hot Dog"};

}



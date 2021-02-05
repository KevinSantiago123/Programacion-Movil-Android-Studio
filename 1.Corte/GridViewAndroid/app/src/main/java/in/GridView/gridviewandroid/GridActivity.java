package in.GridView.gridviewandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import in.GridView.adapter.CustomAdapter;

public class GridActivity extends AppCompatActivity {
    String TAG = GridActivity.class.getSimpleName();

    int image[] = {R.drawable.imagen1, R.drawable.imagen2, R.drawable.imagen3,
            R.drawable.imagen4, R.drawable.imagen5, R.drawable.imagen_6,
            R.drawable.imagem_7, R.drawable.imagen_8, R.drawable.imagen_9,
            R.drawable.imagen_10, R.drawable.imagen_11, R.drawable.imagen_12};
    String names[] = {"Ajax", "Atalanta", "Bayern", "Barcelona","Arsenal" ,"Juventus", "Liverpool", "ManCity", "Milan", "Real Madrid", "Atletico de Madrid" , "Inter de Milan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        try {
            GridView gridview = (GridView) findViewById(R.id.grid_view);
            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), names, image);
            gridview.setAdapter(customAdapter);
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(GridActivity.this, "Tu Equipo Seleccionado Fue : " + position, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
    }
}
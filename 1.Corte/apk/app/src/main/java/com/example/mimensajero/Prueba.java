package com.example.mimensajero;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;

public class Prueba extends Fragment {

    RatingBar ratingBar;
    Button changeColorBtn;
    EditText numberOfStars;
    EditText ratingInput;
    Button sentBtn;
    public int initialNumberOfStars = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View rootView = inflater.inflate(R.layout.raitingbar, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ratingBar = (RatingBar) view.findViewById(R.id.ratingBar2);
        ratingBar.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        changeColorBtn = (Button) view.findViewById(R.id.cambiarColor);
        numberOfStars = (EditText) view.findViewById(R.id.starNumberInput);
        ratingInput = (EditText) view.findViewById(R.id.ratingInput);
        sentBtn = (Button) view.findViewById(R.id.sentBtn);
        SetInitialStates();

        sentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                int numberOfStars = ratingBar.getNumStars();
                Toast.makeText(view.getContext(), "Su calificación: " + rating + "/" + numberOfStars, Toast.LENGTH_LONG).show();
            }
        });

        ratingInput.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    String newValue = s.toString();
                    int value = Integer.parseInt(newValue);
                    ratingBar.setRating(value);
                } catch (Exception e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        numberOfStars.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                try {
                    String newValue = s.toString();
                    int value = Integer.parseInt(newValue);
                    if (value <= 7) {
                        SetNumberOfStars(value);
                    } else {
                        Toast.makeText(view.getContext(), "Numero de estrellas muy grande", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {

                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });

        changeColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int nextInt = random.nextInt(0xffffff + 1);
                String colorCode = String.format("#%06x", nextInt);
                int red = Color.parseColor(colorCode);
                ratingBar.setBackgroundColor(red);
            }
        });
    }

    private void SetInitialStates()
    {
        ratingBar.setNumStars(initialNumberOfStars);
        numberOfStars.setText("" + initialNumberOfStars);
    }

    private void SetNumberOfStars(int number)
    {
        ratingBar.setNumStars(number);
    }
}

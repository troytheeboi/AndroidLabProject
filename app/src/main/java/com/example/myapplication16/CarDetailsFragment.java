package com.example.myapplication16;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CarDetailsFragment extends Fragment {

    private ImageView carImageView;
    private TextView carNameTextView;
    private TextView carModelTextView;
    private TextView carPriceTextView;

    private ImageButton fav;

    private ImageView reserve;

    View view;

    public CarDetailsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_car_details, container, false);

        // Initialize UI components
        carImageView = view.findViewById(R.id.carImageView);
        carNameTextView = view.findViewById(R.id.carNameTextView);
        carModelTextView = view.findViewById(R.id.carModelTextView);
        carPriceTextView = view.findViewById(R.id.carPriceTextView);
        fav = view.findViewById(R.id.favButton4);
        reserve = view.findViewById(R.id.reserveButton3);

        reserve.setOnClickListener(v -> {

            Toast.makeText(carImageView.getContext(), "clicked!", Toast.LENGTH_SHORT).show();


        });



        return view;
    }


}

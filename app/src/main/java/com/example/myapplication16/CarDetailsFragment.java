package com.example.myapplication16;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CarDetailsFragment extends Fragment {

    private ImageView carImageView;
    private TextView carNameTextView;
    private TextView carModelTextView;
    private TextView carPriceTextView;

    public CarDetailsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_details, container, false);

        // Initialize UI components
        carImageView = view.findViewById(R.id.carImageView);
        carNameTextView = view.findViewById(R.id.carNameTextView);
        carModelTextView = view.findViewById(R.id.carModelTextView);
        carPriceTextView = view.findViewById(R.id.carPriceTextView);

        // Populate UI components with details of the selected car (replace with actual data)
        populateCarDetails("Car Name", "Car Model", "$25,000", R.drawable.car);

        return view;
    }

    // Helper method to populate car details
    private void populateCarDetails(String carName, String carModel, String carPrice, int imageResourceId) {
        carImageView.setImageResource(imageResourceId);
        carNameTextView.setText(carName);
        carModelTextView.setText(carModel);
        carPriceTextView.setText(carPrice);
    }
}

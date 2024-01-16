package com.example.myapplication16;import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class CarMenuFragment extends Fragment {

    private RecyclerView carRecyclerView;
    private List<CarType> carTypesList;

    public CarMenuFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_menu, container, false);

        // Initialize UI components
        carRecyclerView = view.findViewById(R.id.carRecyclerView);

        // Initialize and populate the list of car types (you need to create a CarType class)
        carTypesList = getCarTypesList();

        // Set up RecyclerView
        CarTypeAdapter carTypeAdapter = new CarTypeAdapter(carTypesList);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        carRecyclerView.setAdapter(carTypeAdapter);

        return view;
    }

    // Helper method to get a list of car types (replace with your actual data)
    private List<CarType> getCarTypesList() {
        List<CarType> carTypes = new ArrayList<>();
        // Add your car type data here
        return carTypes;
    }
}

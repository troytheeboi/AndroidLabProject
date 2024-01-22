package com.example.myapplication16;

import static com.example.myapplication16.ConnectionAsyncTask.cars;

import android.os.Bundle;
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
    private CarAdapter carAdapter;


    public CarMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_menu, container, false);

        carRecyclerView = view.findViewById(R.id.carRecyclerView);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        carAdapter = new CarAdapter(cars);
        carRecyclerView.setAdapter(carAdapter);

        return view;
    }

}

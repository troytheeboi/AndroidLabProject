package com.example.myapplication16;

import static com.example.myapplication16.DatabaseHelper.DATABASE_NAME;
import static com.example.myapplication16.LoginRegistrationActivity1.currentUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReservationsFragment extends DialogFragment {

    public ReservationsFragment() {
        // Required empty public constructor
    }

    private RecyclerView carRecyclerView;
    private CarAdapter carAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_menu, container, false);

        DatabaseHelper dbHelper =new DatabaseHelper(view.getContext(),DATABASE_NAME,null,1);

        carRecyclerView = view.findViewById(R.id.carRecyclerView);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Car> cars = dbHelper.getReservationsByUser(currentUser);
        carAdapter = new CarAdapter(cars);
        carRecyclerView.setAdapter(carAdapter);

        dbHelper.close();

        return view;
    }
}

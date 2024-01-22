package com.example.myapplication16;

import static com.example.myapplication16.ConnectionAsyncTask.cars;
import static com.example.myapplication16.DatabaseHelper.DATABASE_NAME;
import static com.example.myapplication16.LoginRegistrationActivity1.currentUser;


import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarHolder>{

    private List<Car> carList;

    public CarAdapter(List<Car> carList) {

        this.carList = carList;
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_car_details,parent,false);
        return new CarHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {

        Car car = carList.get(position);
        holder.carName.setText(car.getCompany());
        holder.carModel.setText(car.getType());
        holder.carPrice.setText(String.valueOf(car.getPrice()));
        Picasso.with(holder.carImage.getContext()).load(car.getImageURL()).into(holder.carImage);

        holder.fav.setOnClickListener(v -> {

            int userId = currentUser;

            Car clickedCar = null;
            int clickedPosition = holder.getAdapterPosition();
            if (clickedPosition != RecyclerView.NO_POSITION) {
                // Get the clicked car item
                clickedCar = carList.get(clickedPosition);
            }

            DatabaseHelper dbHelper =new DatabaseHelper(holder.carImage.getContext(),DATABASE_NAME,null,1);

            dbHelper.insertFav(userId,clickedCar.getId());

            dbHelper.close();

            Toast.makeText(holder.carImage.getContext(), "Added to favourites!" + clickedCar.getType(), Toast.LENGTH_SHORT).show();

            TransitionDrawable transitionDrawable = (TransitionDrawable) holder.fav.getDrawable();
            transitionDrawable.startTransition(1000);


        });

        holder.reserve.setOnClickListener(v -> {

            int userId = currentUser;

            Car clickedCar = null;
            int clickedPosition = holder.getAdapterPosition();
            if (clickedPosition != RecyclerView.NO_POSITION) {
                // Get the clicked car item
                clickedCar = carList.get(clickedPosition);
            }

            DatabaseHelper dbHelper =new DatabaseHelper(holder.carImage.getContext(),DATABASE_NAME,null,1);

            dbHelper.insertReservation(userId,clickedCar.getId());

            dbHelper.close();

            Toast.makeText(holder.carImage.getContext(), "Added Reservation!" + clickedCar.getType(), Toast.LENGTH_SHORT).show();


        });

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }


    public static class CarHolder extends RecyclerView.ViewHolder{
        ImageView carImage;
        TextView carName;
        TextView carModel;
        TextView carPrice;

        ImageButton fav;

        ImageView reserve;

        public CarHolder(@NonNull View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.carImageView);
            carName = (TextView) itemView.findViewById(R.id.carNameTextView);
            carModel = (TextView) itemView.findViewById(R.id.carModelTextView);
            carPrice = (TextView) itemView.findViewById(R.id.carPriceTextView);
            fav = (ImageButton) itemView.findViewById(R.id.favButton4);
            reserve = (ImageButton) itemView.findViewById(R.id.reserveButton3);
        }
    }
}

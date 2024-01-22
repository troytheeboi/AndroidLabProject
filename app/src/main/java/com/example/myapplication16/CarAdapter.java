package com.example.myapplication16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        public CarHolder(@NonNull View itemView) {
            super(itemView);
            carImage = (ImageView) itemView.findViewById(R.id.carImageView);
            carName = (TextView) itemView.findViewById(R.id.carNameTextView);
            carModel = (TextView) itemView.findViewById(R.id.carModelTextView);
            carPrice = (TextView) itemView.findViewById(R.id.carPriceTextView);
        }
    }
}

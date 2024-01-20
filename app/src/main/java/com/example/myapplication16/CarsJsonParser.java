package com.example.myapplication16;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CarsJsonParser {
    public static List<Car> getObjectFromJson(String json) {

        List<Car> cars;

        try {
            JSONArray jsonArray = new JSONArray(json);

            cars = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject;

                jsonObject = (JSONObject) jsonArray.get(i);

                Car typeForAPI = new Car();

                typeForAPI.setId(jsonObject.getInt("id"));
                typeForAPI.setType(jsonObject.getString("type"));
                typeForAPI.setCompany(jsonObject.getString("COMPANY"));
                typeForAPI.setPrice(jsonObject.getInt("PRICE"));
                typeForAPI.setOffer(jsonObject.getInt("OFFER"));
                typeForAPI.setYear(jsonObject.getString("YEAR"));
                typeForAPI.setFuelType(jsonObject.getString("FUEL TYPE"));
                typeForAPI.setRating(jsonObject.getInt("RATING"));
                typeForAPI.setAccident(jsonObject.getString("ACCIDENT"));
                typeForAPI.setSpare(jsonObject.getString("SPARE"));
                typeForAPI.setColor(jsonObject.getString("COLOR"));
                typeForAPI.setDoors(jsonObject.getInt("DOORS"));
                typeForAPI.setImageURL(jsonObject.getString("IMAGE"));

                cars.add(typeForAPI);
            }
        } catch (JSONException e) {
            e.printStackTrace(); return null;
        } return cars;
    }
}
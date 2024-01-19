package com.example.myapplication16;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TypeJsonParser {
    public static List<CarTypeForAPI> getObjectFromJson(String json) {

        List<CarTypeForAPI> carTypeForAPIS;

        try {
            JSONArray jsonArray = new JSONArray(json);

            carTypeForAPIS = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = new JSONObject();
                jsonObject = (JSONObject) jsonArray.get(i);
                CarTypeForAPI typeForAPI = new CarTypeForAPI();
                typeForAPI.setId(jsonObject.getInt("id"));
                typeForAPI.setType(jsonObject.getString("type"));
                carTypeForAPIS.add(typeForAPI);
            }
        } catch (JSONException e) {
            e.printStackTrace(); return null;
        } return carTypeForAPIS;
    }
}
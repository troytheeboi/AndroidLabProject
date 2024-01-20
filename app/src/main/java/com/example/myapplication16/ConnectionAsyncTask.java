package com.example.myapplication16;

import static com.example.myapplication16.DatabaseHelper.DATABASE_NAME;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConnectionAsyncTask extends AsyncTask<String, String, String> {
    Activity activity;
    public static List<Car> cars = new ArrayList<>();

    private Context context;

    public ConnectionAsyncTask(Activity activity, Context context) {

        this.activity = activity;
        this.context = context;
    }

    @Override protected void onPreExecute() {
        ((introductionActivity) activity).setButtonText("connecting");
        super.onPreExecute();
        ((introductionActivity) activity).setProgress(true);
    }

    @Override
    protected String doInBackground(String... params) {

        String data = HttpManager.getData(params[0]);
        return data;
    }

    @Override
    protected void onPostExecute(String s) {

        if (s != null) {
        super.onPostExecute(s);
        ((introductionActivity) activity).setProgress(false);
        ((introductionActivity) activity).setButtonText("connected");
        cars = CarsJsonParser.getObjectFromJson(s);
        ((introductionActivity) activity).toLogin();

        //first time the db was created this was run to get data from api in local db

        for(Car car : cars){

            DatabaseHelper dataBaseHelper =new DatabaseHelper(context,DATABASE_NAME,null,1);

            // Perform registration and insert data into the database
            dataBaseHelper.insertCarData(car);

        }

        }else{
            Toast.makeText(activity, "No Internet Connection or Failed to Fetch Data", Toast.LENGTH_SHORT).show();
        }



    }

}




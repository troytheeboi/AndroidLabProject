package com.example.myapplication16;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ConnectionAsyncTask extends AsyncTask<String, String, String> {
    Activity activity;
    public static List<CarTypeForAPI> carTypeForAPIS = new ArrayList<>();

    private Context context;

    public ConnectionAsyncTask(Activity activity) {

        this.activity = activity;
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
        carTypeForAPIS = TypeJsonParser.getObjectFromJson(s);
        ((introductionActivity) activity).toLogin();
        }else{
            Toast.makeText(activity, "No Internet Connection or Failed to Fetch Data", Toast.LENGTH_SHORT).show();
        }



    }
    boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // For Android M and newer versions
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
            } else {
                // For older versions
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        }

        return false;
    }


}




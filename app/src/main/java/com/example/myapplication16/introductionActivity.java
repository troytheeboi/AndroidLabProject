package com.example.myapplication16;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class introductionActivity extends AppCompatActivity {

    private Button connectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, "onCreate: Hello World!");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        setProgress(false);


        // Find the Connect button by its ID
        connectButton = findViewById(R.id.connectButton);

        // Set a click listener for the Connect button
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Execute the AsyncTask to connect to the server
                ConnectionAsyncTask connectionAsyncTask = new ConnectionAsyncTask(introductionActivity.this);
                connectionAsyncTask.execute("https://658582eb022766bcb8c8c86e.mockapi.io/api/mock/rest-apis/encs5150/car-types");
            }
        });
    }

    void setButtonText(String text) {
        connectButton.setText(text);
    }

    public void setProgress(boolean progress) {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        if (progress) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public void toLogin(){
        startActivity(new Intent(introductionActivity.this,LoginRegistrationActivity1.class));
    }
}

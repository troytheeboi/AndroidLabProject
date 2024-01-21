package com.example.myapplication16;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Connect button by its ID
        Button connectButton = findViewById(R.id.connectButton);

        // Set a click listener for the Connect button
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to the IntroductionActivity when the Connect button is clicked
                startActivity(new Intent(MainActivity.this, introductionActivity.class));
            }
        });
    }

}



package com.example.myapplication16;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class introductionActivity extends AppCompatActivity {

    private Button connectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        // Find the Connect button by its ID
        connectButton = findViewById(R.id.connectButton);

        // Set a click listener for the Connect button
        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Execute the AsyncTask to connect to the server
                new ConnectToServerTask().execute();
            }
        });
    }

    // AsyncTask to handle the connection to the server
    private class ConnectToServerTask extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            // Implement the logic to connect to the server using REST
            // Return true if successful, false otherwise
            return makeServerRequest();
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                // Connection successful, proceed to the login and registration section
                startActivity(new Intent(introductionActivity.this,LoginRegistrationActivity1.class));
            } else {
                // Connection unsuccessful, display an error message
                Toast.makeText(introductionActivity.this, "Connection failed. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Example method to make a server request
    private boolean makeServerRequest() {
        // Implement the logic to make a server request
        // Return true if successful, false otherwise
        return false; // Placeholder, replace with actual implementation
    }
}

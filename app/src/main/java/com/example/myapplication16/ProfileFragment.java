package com.example.myapplication16;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private TextView userNameTextView;
    private TextView userEmailTextView;
    private Button changePasswordButton;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize UI components
        userNameTextView = view.findViewById(R.id.userNameTextView);
        userEmailTextView = view.findViewById(R.id.userEmailTextView);
        changePasswordButton = view.findViewById(R.id.changePasswordButton);

        // Set up click listener for the change password button
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for changing the password
                // You can open a dialog, navigate to a new activity, etc.
            }
        });

        // Populate user details (replace with actual user data)
        populateUserDetails("John Doe", "john.doe@example.com");

        return view;
    }

    // Helper method to populate user details
    private void populateUserDetails(String userName, String userEmail) {
        userNameTextView.setText("User: " + userName);
        userEmailTextView.setText("Email: " + userEmail);
    }
}

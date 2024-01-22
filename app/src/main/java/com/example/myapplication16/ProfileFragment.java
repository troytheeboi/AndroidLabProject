package com.example.myapplication16;
import static com.example.myapplication16.LoginRegistrationActivity1.currentUser;
import static com.example.myapplication16.signUp.isPasswordValid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileFragment extends Fragment {

    private EditText FirstNameEdit;
    private EditText LastNameEdit;

    private EditText PasswordEdit;

    private EditText PhoneNumberEdit;

    private EditText EmailEdit;
    private Button saveChanges;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize UI components
        FirstNameEdit = view.findViewById(R.id.FirstNameEditText);
        LastNameEdit = view.findViewById(R.id.LastNameEditText);
        saveChanges = view.findViewById(R.id.SaveChnages);
        PasswordEdit = view.findViewById(R.id.editTextTextPassword);
        PhoneNumberEdit = view.findViewById(R.id.ProfilePhoneNum);
        EmailEdit = view.findViewById(R.id.editTextTextEmailAddress);

        // Set up click listener for the change password button

        DatabaseHelper dbHelper = new DatabaseHelper(view.getContext(),DatabaseHelper.DATABASE_NAME,null,1 );
        System.out.println(currentUser + "---------");
        User user = dbHelper.getUserById(currentUser);

        FirstNameEdit.setText(user.getFirstName());
        LastNameEdit.setText(user.getLastName());
        PasswordEdit.setText(user.getPassword());
        EmailEdit.setText(user.getEmailAddress());
        PhoneNumberEdit.setText(user.getPhoneNum());
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FirstNameEdit.getText().length() < 3 || LastNameEdit.getText().length() < 3) {

                    Toast.makeText(view.getContext(), "First name and last name must be at least 3 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!isPasswordValid(String.valueOf(PasswordEdit.getText()))) {
                    Toast.makeText(view.getContext(), "Password must be at least 5 characters and include a character, a number, and a special character", Toast.LENGTH_SHORT).show();

                    return;
                }

                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(EmailEdit.getText());
                boolean matchFound = m.matches();

                if(!matchFound){
                    Toast.makeText(view.getContext(), "Email Not Valid", Toast.LENGTH_SHORT).show();

                    return;
                }

                User user = dbHelper.getUserById(currentUser);

                user.setFirstName(String.valueOf(FirstNameEdit.getText()));
                user.setLastName(String.valueOf(LastNameEdit.getText()));
                user.setPassword(String.valueOf(PasswordEdit.getText()));
                user.setEmailAddress(String.valueOf(EmailEdit.getText()));
                user.setPhoneNum(String.valueOf(PhoneNumberEdit.getText()));

                DatabaseHelper dbHelper = new DatabaseHelper(view.getContext(),DatabaseHelper.DATABASE_NAME,null,1);

                System.out.println(user.getId() + "-----------");

                dbHelper.UpdateUserData(user);





            }
        });


        return view;
    }

    // Helper method to populate user details
}

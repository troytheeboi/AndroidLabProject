package com.example.myapplication16;


import static com.example.myapplication16.DatabaseHelper.DATABASE_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUp extends AppCompatActivity {

        private EditText firstNameEditText;
        private EditText lastNameEditText;
        private EditText passwordEditText;
        private EditText confirmPasswordEditText;
        private Spinner genderSpinner;
        private Spinner countrySpinner;
        private Spinner citySpinner;
        private EditText phoneNumberEditText;
        private Button registerButton;

        private EditText email;

        // You can add more countries and cities as needed
        private static final String[] countries = {"Palestine", "UK","USA","Qatar"};
        private static final String[][] cities = {{"Ramallah", "Nablus", "Bethlahem"}, {"london", "liverpool", "Birmingham"},{"florida","dalles","houston"},{"doha","al khor","mesaieed","al wakrah"}};

        private static final String [] phoneCodes= {"+970","+44","+1","+974"};

        String currentCode = "+970";
        private DatabaseHelper dbHelper;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up);

            // Initialize UI components
            firstNameEditText = findViewById(R.id.firstNameEditText);
            lastNameEditText = findViewById(R.id.lastNameEditText);
            passwordEditText = findViewById(R.id.passwordEditText);
            confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
            genderSpinner = findViewById(R.id.genderSpinner);
            countrySpinner = findViewById(R.id.countrySpinner);
            citySpinner = findViewById(R.id.citySpinner);
            phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
            registerButton = findViewById(R.id.registerButton);
            email = findViewById(R.id.EmailEditText);

            // Set up spinners
            setUpGenderSpinner();
            setUpCountrySpinner();


            // Set a click listener for the "Register" button
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle the registration process
                    handleRegistration();
                }
            });
        }

        private void setUpGenderSpinner() {
            // Set up the gender spinner without using resources
            String[] genders = {"Male", "Female", "Other"};

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            genderSpinner.setAdapter(adapter);
        }

        private void setUpCountrySpinner() {
            // Set up the country spinner without using resources
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countrySpinner.setAdapter(adapter);

            // Set up a listener for the country spinner to update the city spinner based on the selected country
            countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    updateCitySpinner(position);
                    currentCode = phoneCodes[position];
                    phoneNumberEditText.setText(currentCode + " ");
                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // Do nothing here
                }
            });
        }

        private void updateCitySpinner(int selectedCountryIndex) {
            // Update the city spinner based on the selected country
            ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities[selectedCountryIndex]);
            cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            citySpinner.setAdapter(cityAdapter);
        }

        private void handleRegistration() {
            // Retrieve user inputs
            String firstName = firstNameEditText.getText().toString().trim();
            String lastName = lastNameEditText.getText().toString().trim();
            String gender = genderSpinner.getSelectedItem().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();
            String country = countrySpinner.getSelectedItem().toString();
            String city = citySpinner.getSelectedItem().toString();
            String phoneNumber = phoneNumberEditText.getText().toString().trim();
            String emailAdd = email.getText().toString().trim();

            // Validate inputs
            if (firstName.length() < 3 || lastName.length() < 3) {
                showToast("First name and last name must be at least 3 characters");
                return;
            }

            if (!isPasswordValid(password)) {
                showToast("Password must be at least 5 characters and include a character, a number, and a special character");
                return;
            }

            if (!password.equals(confirmPassword)) {
                showToast("Passwords do not match");
                return;
            }

            Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
            Matcher m = p.matcher(emailAdd);
            boolean matchFound = m.matches();

            if(!matchFound){
                showToast("Add Valid Email");
                return;
            }

            User toInsert = new User();

            toInsert.setCity(city);
            toInsert.setCountry(country);
            toInsert.setGender(gender);
            toInsert.setFirstName(firstName);
            toInsert.setLastName(lastName);
            toInsert.setPhoneNum(phoneNumber);
            toInsert.setPassword(password);
            toInsert.setEmailAddress(emailAdd);
            toInsert.setIsAdmin(0);

            DatabaseHelper dataBaseHelper =new DatabaseHelper(signUp.this,DATABASE_NAME,null,1);


            // Perform registration and insert data into the database
            dataBaseHelper.insertUserData(toInsert);

            dataBaseHelper.close();

            // Show a success message
            showToast("Registration successful! User: " + firstName + " " + lastName + ", Country: " + country + ", City: " + city + ", Phone: " + phoneNumber);

            Intent intent=new Intent(signUp.this, LoginRegistrationActivity1.class);
            intent.putExtra("email",emailAdd);
            startActivity(intent);

        }

        private boolean isPasswordValid(String password) {
            // Password must be at least 5 characters and include a character, a number, and a special character
            return password.length() >= 5 && password.matches(".*[a-zA-Z]+.*") && password.matches(".*\\d+.*") && password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]+.*");
        }

        private void showToast(String message) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }


    }



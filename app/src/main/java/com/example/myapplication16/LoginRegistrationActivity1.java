package com.example.myapplication16;

import static com.example.myapplication16.DatabaseHelper.DATABASE_NAME;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRegistrationActivity1 extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private CheckBox rememberMeCheckBox;

    SharedPrefManager sharedPrefManager;

//    public static Cursor getUserByMail;

    public static int currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registration1);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);

        sharedPrefManager =SharedPrefManager.getInstance(this);

        emailEditText.setText(getIntent().getStringExtra("email"));

        // Check if the email is already saved in shared preferences
        String savedEmail = sharedPrefManager.readString("email","noValue");

        if (!savedEmail.equals("noValue")) {
            emailEditText.setText(savedEmail);
            rememberMeCheckBox.setChecked(true);
        }

        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean loginSuccess = true;

                // Get the entered email and password
                String enteredEmail = emailEditText.getText().toString().trim();
                String enteredPassword = passwordEditText.getText().toString();

                Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                Matcher m = p.matcher(enteredEmail);
                boolean matchFound = m.matches();

                if(!matchFound){
                    Toast.makeText(LoginRegistrationActivity1.this, "No Account with this email exists", Toast.LENGTH_SHORT).show();
                    loginSuccess = false;
                }


                if( !enteredEmail.isEmpty() && !enteredPassword.isEmpty()){
                    
                    DatabaseHelper dbHelper =new DatabaseHelper(LoginRegistrationActivity1.this,DATABASE_NAME,null,1);


                    Cursor getUserByMail = dbHelper.getByEmail(enteredEmail);

                    getUserByMail.moveToFirst();

                    currentUser = getUserByMail.getInt(0);


                    boolean exists = dbHelper.isCursorEmpty(getUserByMail);

                    if (exists) {
                        Toast.makeText(LoginRegistrationActivity1.this, "No Account with this email exists", Toast.LENGTH_SHORT).show();
                        loginSuccess = false;
                    }else{

                        String password = getUserByMail.getString(5);

                        dbHelper.close();

                        if(password.equals(enteredPassword)){
                            loginSuccess = true;
                        }else{
                            Toast.makeText(LoginRegistrationActivity1.this, "Password doesn't match!", Toast.LENGTH_SHORT).show();
                            loginSuccess = false;
                        }

                    }
                }

                

                if (loginSuccess) {
                    // If login is successful, save the email in shared preferences if "Remember Me" is checked
                    if (rememberMeCheckBox.isChecked()) {
                        sharedPrefManager.writeString("email",emailEditText.getText().toString());
                        sharedPrefManager.writeString("password",passwordEditText.getText().toString());
                    }
                    startActivity(new Intent(LoginRegistrationActivity1.this,HomeActivity.class));
                } else {
                    Toast.makeText(LoginRegistrationActivity1.this, "Login failed. Check your credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button signUpButton = findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the EmptyActivity when the "Sign Up" button is clicked
                startActivity(new Intent(LoginRegistrationActivity1.this, signUp.class));
            }
        });
    }



    private boolean validFields(String email, String password) {
        return !email.isEmpty() && !password.isEmpty();
    }
}

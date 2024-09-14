package com.example.lab1_calcularor.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1_calcularor.R;
import com.example.lab1_calcularor.entities.UserData;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber;
    EditText name;
    EditText surname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registerPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        auth();
    }

    private void auth(){
        Button authButton = findViewById(R.id.registrationButton);

        phoneNumber = findViewById(R.id.userPhoneNumber);
        name = findViewById(R.id.userName);
        surname = findViewById(R.id.userSurname);

        UserData user = getUser();
        if (user != null){
            authButton.setText("LOG IN");
        }else{
            authButton.setText("REGISTRATION");
        }

        if (user != null){
            phoneNumber.setText(user.getPhone());
            name.setText(user.getName());
            surname.setText(user.getSurname());
        }

        authButton.setOnClickListener(this::handleAuthClick);
    }

    private void handleAuthClick(View view) {
        String userPhoneNumber = phoneNumber.getText().toString();
        String userName = name.getText().toString();
        String userSurname = name.getText().toString();

        if (userPhoneNumber.isEmpty() || userName.isEmpty() || userSurname.isEmpty()) return;

        UserData user = new UserData(userPhoneNumber, userName, userSurname);
        saveUser(user);

        Intent intent = new Intent(this, PersonalPageActivity.class);
        startActivity(intent);

    }

    private void saveUser(UserData user){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(user);

        editor.putString("user", json);
        editor.apply();
    }

    private UserData getUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String json = sharedPreferences.getString("user", null);

        Gson gson = new Gson();
        UserData user = gson.fromJson(json, UserData.class);

        return user;
    }
}
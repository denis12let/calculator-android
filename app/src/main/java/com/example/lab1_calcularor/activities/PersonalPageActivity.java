package com.example.lab1_calcularor.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab1_calcularor.R;
import com.example.lab1_calcularor.entities.RouteData;
import com.example.lab1_calcularor.entities.UserData;
import com.google.gson.Gson;

public class PersonalPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profilePage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initAccount();
        buttonsHandler();
    }

    private void initAccount(){
        Button taxiButton = findViewById(R.id.taxiButton);
        Bundle arguments = getIntent().getExtras();

        UserData user = getUser();
        RouteData route = null;

        if (arguments != null){
            route = (RouteData) arguments.getSerializable(RouteData.class.getSimpleName());
            taxiButton.setEnabled(true);
        }else{
            taxiButton.setEnabled(false);
        }

        TextView userNameSurname = findViewById(R.id.userName);
        TextView userPhone = findViewById(R.id.userPhoneNumber);

        userNameSurname.setText(user.getName().concat(" " + user.getSurname()));
        userPhone.setText(user.getPhone());

        TextView routeInfo = findViewById(R.id.routeInfo);

        if (route != null){
            routeInfo.setText(route.toString());
        }
    }

    private void buttonsHandler(){
        Button routeButton = findViewById(R.id.routeButton);
        Button taxiButton = findViewById(R.id.taxiButton);

        routeButton.setOnClickListener(this::handleRouteButtonClick);
        taxiButton.setOnClickListener(this::handleTaxiButton);
    }

    private void handleRouteButtonClick(View view){
        Intent intent = new Intent(this, RouteActivity.class);
        startActivity(intent);
    }

    private void handleTaxiButton(View view){
        Toast.makeText(this, "Успешный вызов такси", Toast.LENGTH_SHORT).show();
    }

    private UserData getUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String json = sharedPreferences.getString("user", null);

        Gson gson = new Gson();
        UserData user = gson.fromJson(json, UserData.class);

        return user;
    }
}

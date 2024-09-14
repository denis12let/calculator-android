package com.example.lab1_calcularor.activities;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
//Новый метод из onCreate, который будет смотреть: регался ли юзер или не регался. Если регался, то в
//переход в LOG IN, иначе - REGISTRATION. Для этого создать класс, который будет сохранять и загружатьы инфу юзера.

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
        phoneNumber = findViewById(R.id.userPhoneNumber);
        name = findViewById(R.id.userName);
        surname = findViewById(R.id.userSurname);

        Button authButton = findViewById(R.id.registrationButton);
        authButton.setOnClickListener(this::handleAuthClick);
    }

    private void handleAuthClick(View view) {
        String userPhoneNumber = phoneNumber.getText().toString();
        String userName = name.getText().toString();
        String userSurname = name.getText().toString();

        if (userPhoneNumber.isEmpty() || userName.isEmpty() || userSurname.isEmpty()) return;

        UserData user = new UserData(userPhoneNumber, userName, userSurname);

        Intent intent = new Intent(this, PersonalPageActivity.class);
        intent.putExtra(UserData.class.getSimpleName(), user);
        startActivity(intent);
    }

}
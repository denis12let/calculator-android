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
import com.example.lab1_calcularor.entities.RouteData;
import com.example.lab1_calcularor.entities.UserData;

import java.util.List;

public class RouteActivity extends AppCompatActivity {

    EditText streetFromView;
    EditText streetToView;
    EditText houseFromView;
    EditText houseToView;
    EditText flatFromView;
    EditText flatToView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_route);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.routePage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        route();
    }

    private void route(){
        Button routeButton = findViewById(R.id.confirmButton);
        routeButton.setOnClickListener(this::handleRouteButton);
    }

    private void handleRouteButton(View view){

        streetFromView = findViewById(R.id.streetFrom);
        streetToView = findViewById(R.id.streetTo);
        houseFromView = findViewById(R.id.houseFrom);
        houseToView = findViewById(R.id.houseTo);
        flatFromView = findViewById(R.id.flatFrom);
        flatToView = findViewById(R.id.flatTo);

        List<String> routeData = List.of(streetFromView.getText().toString(),
                streetToView.getText().toString(),
                houseFromView.getText().toString(),
                houseToView.getText().toString(),
                flatFromView.getText().toString(),
                flatToView.getText().toString()
        );

        if (routeData.stream().anyMatch(String::isEmpty)) {
            return;
        }

        RouteData route = new RouteData(
                streetFromView.getText().toString(),
                streetToView.getText().toString(),
                houseFromView.getText().toString(),
                houseToView.getText().toString(),
                flatFromView.getText().toString(),
                flatToView.getText().toString()
        );

        Intent intent = new Intent(this, PersonalPageActivity.class);
        intent.putExtra(RouteData.class.getSimpleName(), route);
        startActivity(intent);
    }
}

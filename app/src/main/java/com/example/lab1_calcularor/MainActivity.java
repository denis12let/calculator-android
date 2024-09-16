package com.example.lab1_calcularor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnShow, btnAdd, btnRemove, btnUpdate;
    private FrameLayout fl;

    ShowFragment showFragment = new ShowFragment();
    RemoveFragment removeFragment = new RemoveFragment();
    AddFragment addFragment = new AddFragment();
    UpdateFragment updateFragment = new UpdateFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        btnShow = findViewById(R.id.buttonShow);
        btnAdd = findViewById(R.id.buttonAdd);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);

        btnShow.setOnClickListener(v -> setNewFragment(showFragment));
        btnAdd.setOnClickListener(v -> setNewFragment(addFragment));
        btnRemove.setOnClickListener(v -> setNewFragment(removeFragment));
        btnUpdate.setOnClickListener(v -> setNewFragment(updateFragment));

    }

    private void setNewFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }
}
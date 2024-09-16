package com.example.lab1_calcularor;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.lab1_calcularor.adapters.PagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnShow, btnAdd, btnRemove, btnUpdate;
    private FrameLayout fl;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

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

        pager = findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        btnShow.setOnClickListener(v -> pager.setCurrentItem(0));
        btnAdd.setOnClickListener(v -> pager.setCurrentItem(1));
        btnUpdate.setOnClickListener(v -> pager.setCurrentItem(2));
        btnRemove.setOnClickListener(v -> pager.setCurrentItem(3));
    }
}
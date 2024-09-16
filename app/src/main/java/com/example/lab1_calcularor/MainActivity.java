package com.example.lab1_calcularor;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.lab1_calcularor.adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    private Button btnShow, btnAdd, btnRemove, btnUpdate;
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        setSlideButtons();

        pager = findViewById(R.id.viewPager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        btnShow.setOnClickListener(v -> pager.setCurrentItem(0));
        btnAdd.setOnClickListener(v -> pager.setCurrentItem(1));
        btnUpdate.setOnClickListener(v -> pager.setCurrentItem(2));
        btnRemove.setOnClickListener(v -> pager.setCurrentItem(3));
    }

    private void setSlideButtons(){
        btnShow = findViewById(R.id.buttonShow);
        btnAdd = findViewById(R.id.buttonAdd);
        btnRemove = findViewById(R.id.buttonRemove);
        btnUpdate = findViewById(R.id.buttonUpdate);
    }
}
package com.example.lab1_calcularor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout;
    private LayoutInflater layoutInflater;
    ListView listView;
    ArrayList<Product> products = new ArrayList<Product>();
    private ProductAdapter productAdapter;
    private final int LIST_SIZE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        layoutInflater = LayoutInflater.from(this);

        setupListView();
        createViews();

        View viewHeader = initHeader(layoutInflater);
        View viewFooter = initFooter(layoutInflater);

        productAdapter = new ProductAdapter(this, products);

        listView.addHeaderView(viewHeader);
        listView.addFooterView(viewFooter);

        listView.setAdapter(productAdapter);
    }

    private void setupListView(){
        listView = findViewById(R.id.listView);
    }

    private View initHeader(LayoutInflater layoutInflater){
        View viewHeader = layoutInflater.inflate(R.layout.shop_header, null);
        return viewHeader;
    }

    private View initFooter(LayoutInflater layoutInflater){
        View viewFooter = layoutInflater.inflate(R.layout.shop_footer, null);

        Button cardButton = viewFooter.findViewById(R.id.showCheckedItemsButton);
        cardButton.setOnClickListener(this);

        return viewFooter;
    }

    private void createViews(){
        for (int i = 0; i <= LIST_SIZE; i++){
            products.add(new Product(i, String.format("# item%d", i), false));
        }
    }

    @Override
    public void onClick(View view) {
    }
}
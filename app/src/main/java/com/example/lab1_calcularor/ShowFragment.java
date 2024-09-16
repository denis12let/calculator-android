package com.example.lab1_calcularor;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lab1_calcularor.adapters.ProductsAdapter;
import com.example.lab1_calcularor.entities.Product;

import java.util.ArrayList;

public class ShowFragment extends Fragment {

    private ListView listView;
    private ProductsAdapter productsAdapter;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show, container, false);

        setListView(view);
        createViews();

        productsAdapter = new ProductsAdapter(getContext(), products);
        listView.setAdapter(productsAdapter);

        return view;
    }

    private void createViews(){
        for (int i = 0; i < 50; i++){
            products.add(new Product(i, String.format("   item%d", i)));
        }
    }

    private void setListView(View view){
        listView = view.findViewById(R.id.listView);
    }
}
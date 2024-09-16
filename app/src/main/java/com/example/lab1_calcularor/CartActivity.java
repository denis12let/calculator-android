package com.example.lab1_calcularor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private LayoutInflater layoutInflater;
    private LinearLayout linearLayout;
    ListView listView;
    TextView textCountChecked;
    private ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        init();
    }

    private void init(){
        linearLayout = findViewById(R.id.productsList);
        layoutInflater = LayoutInflater.from(this);

        getProducts();
        setupListView();
        showProduct();
    }

    private void showProduct() {
        textCountChecked = findViewById(R.id.productCardProducts);
        int productsArrSize = products.size();
        int countProductsChecked = 0;

        for (int i = 0; i < productsArrSize; i++) {
            if (products.get(i).isCheck()) {
                countProductsChecked++;
                View viewProduct = layoutInflater.inflate(R.layout.catalog_card, linearLayout, false);

                TextView itemId = viewProduct.findViewById(R.id.itemId);
                itemId.setText(String.valueOf(products.get(i).getId()));

                TextView itemName = viewProduct.findViewById(R.id.itemName);
                itemName.setText(products.get(i).getName());

                CheckBox itemCheckBox = viewProduct.findViewById(R.id.itemCheckBox);

                ((ViewGroup) itemCheckBox.getParent()).removeView(itemCheckBox);

                linearLayout.addView(viewProduct);
            }
        }

        textCountChecked.setText("Количество продуктов в корзине: " + countProductsChecked);
    }

    private void getProducts(){
        Bundle arguments = getIntent().getExtras();
        products = null;

        if (arguments != null){
            products = (ArrayList<Product>) arguments.getSerializable(Product.class.getSimpleName());
        }
    }

    private void setupListView(){
        listView = findViewById(R.id.listView);
    }
}

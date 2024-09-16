package com.example.lab1_calcularor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private Context context;
    private ArrayList<Product> productsAdapter;
    private LayoutInflater layoutInflater;
    private ArrayList<Product> selectedProductsAdapter = new ArrayList<>();
    private ProductsObserver productsObserver;

    public ProductAdapter(Context context, ArrayList<Product> productsAdapter, ProductsObserver productsObserver) {
        this.context = context;
        this.productsAdapter = productsAdapter;
        this.productsObserver = productsObserver;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productsAdapter.size();
    }

    @Override
    public Object getItem(int posId) {
        return productsAdapter.get(posId);
    }

    @Override
    public long getItemId(int posId) {
        return posId;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        view = (view == null) ? layoutInflater.inflate(R.layout.catalog_card, null, false) : view;

        Product productTemp = productsAdapter.get(pos);

        TextView productId = view.findViewById(R.id.itemId);
        productId.setText(Integer.toString(productTemp.getId()));

        TextView productName = view.findViewById(R.id.itemName);
        productName.setText(productTemp.getName());

        CheckBox productCheckBox = view.findViewById(R.id.itemCheckBox);
        productCheckBox.setChecked(productTemp.isCheck());
        productCheckBox.setTag(pos);
        productCheckBox.setOnCheckedChangeListener(this);

        return view;
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.isShown()){
            int tag = (int) compoundButton.getTag();
            productsAdapter.get(tag).setCheck(isChecked);
            notifyDataSetChanged();

            if (isChecked){
                selectedProductsAdapter.add(productsAdapter.get(tag));
            }else{
                selectedProductsAdapter.remove(productsAdapter.get(tag));
            }

            productsObserver.onDataChanged();
        }
    }

    public ArrayList<Product> getSelectedProductsAdapter() {
        return selectedProductsAdapter;
    }
}

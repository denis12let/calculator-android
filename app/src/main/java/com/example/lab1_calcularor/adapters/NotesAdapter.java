package com.example.lab1_calcularor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.lab1_calcularor.R;
import com.example.lab1_calcularor.entities.Note;


public class NotesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Note> productsAdapter = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public NotesAdapter(Context context, ArrayList<Note> productsAdapter) {
        this.context = context;
        this.productsAdapter = productsAdapter;
        layoutInflater = LayoutInflater.from(context);
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
        view = (view == null) ? layoutInflater.inflate(R.layout.note_item, null, false) : view;

        Note productTemp = productsAdapter.get(pos);

        TextView productId = view.findViewById(R.id.itemId);
        productId.setText(Integer.toString(productTemp.getId()));

        TextView productName = view.findViewById(R.id.itemName);
        productName.setText(productTemp.getName());

        return view;
    }
}

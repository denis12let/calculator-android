package com.example.lab1_calcularor.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lab1_calcularor.R;
import com.example.lab1_calcularor.adapters.NotesAdapter;
import com.example.lab1_calcularor.entities.Note;

import java.util.ArrayList;

public class ShowFragment extends Fragment {

    private ListView listView;
    private NotesAdapter productsAdapter;
    private ArrayList<Note> products = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_show, container, false);

        setListView(view);
        createViews();

        productsAdapter = new NotesAdapter(getContext(), products);
        listView.setAdapter(productsAdapter);

        return view;
    }

    private void createViews(){
        for (int i = 0; i < 50; i++){
            products.add(new Note(i, String.format("   item%d", i)));
        }
    }

    private void setListView(View view){
        listView = view.findViewById(R.id.listView);
    }
}
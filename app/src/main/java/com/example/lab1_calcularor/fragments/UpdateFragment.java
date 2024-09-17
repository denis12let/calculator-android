package com.example.lab1_calcularor.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lab1_calcularor.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.lab1_calcularor.R;
import com.example.lab1_calcularor.database.DatabaseHelper;

public class UpdateFragment extends Fragment {

    private EditText editTextId, editTextName;
    private Button buttonUpdate;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        editTextId = view.findViewById(R.id.updateID);
        editTextName = view.findViewById(R.id.updateName);
        buttonUpdate = view.findViewById(R.id.buttonUpdateNote);
        databaseHelper = new DatabaseHelper(getContext());

        buttonUpdate.setOnClickListener(v -> {
            Log.e("123", editTextId.getText().toString());
            int id = Integer.parseInt(editTextId.getText().toString());
            String name = editTextName.getText().toString();
            databaseHelper.updateNote(id, name);
            Toast.makeText(getContext(), "Заметка обновлена", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
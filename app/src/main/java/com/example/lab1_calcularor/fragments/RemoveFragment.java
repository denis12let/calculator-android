package com.example.lab1_calcularor.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

public class RemoveFragment extends Fragment {

    private EditText editTextId;
    private Button buttonRemove;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remove, container, false);
        editTextId = view.findViewById(R.id.removeId);
        buttonRemove = view.findViewById(R.id.buttonRemoveNote);
        databaseHelper = new DatabaseHelper(getContext());

        buttonRemove.setOnClickListener(v -> {
            int id = Integer.parseInt(editTextId.getText().toString());
            databaseHelper.deleteNote(id);
            Toast.makeText(getContext(), "Заметка удалена", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
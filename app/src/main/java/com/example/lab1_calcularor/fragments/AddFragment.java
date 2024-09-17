package com.example.lab1_calcularor.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.example.lab1_calcularor.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.lab1_calcularor.database.DatabaseHelper;

public class AddFragment extends Fragment {

    private EditText editTextName;
    private Button buttonAdd;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        editTextName = view.findViewById(R.id.addName);
        buttonAdd = view.findViewById(R.id.buttonAddNote);
        databaseHelper = new DatabaseHelper(getContext());

        buttonAdd.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            if (!name.isEmpty()) {
                databaseHelper.addNote(name);
                Toast.makeText(getContext(), "Заметка добавлена", Toast.LENGTH_SHORT).show();
                editTextName.setText("");
            } else {
                Toast.makeText(getContext(), "Введите название заметки", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
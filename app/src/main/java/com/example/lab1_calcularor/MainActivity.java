package com.example.lab1_calcularor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText numberField;
    private TextView resultField;
    private TextView operationField;

    private String currentOperation = "";
    private String firstOperand = "";
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numberField = findViewById(R.id.numberField);
        resultField = findViewById(R.id.resultField);
        operationField = findViewById(R.id.operationField);

        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] numberButtonIds = {
                R.id.n0, R.id.n1, R.id.n2, R.id.n3,
                R.id.n4, R.id.n5, R.id.n6, R.id.n7,
                R.id.n8, R.id.n9, R.id.point
        };

        for (int id : numberButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(v -> onNumberClick(((Button) v).getText().toString()));
        }

        findViewById(R.id.plus).setOnClickListener(v -> onOperationClick("+"));
        findViewById(R.id.minus).setOnClickListener(v -> onOperationClick("-"));
        findViewById(R.id.multiply).setOnClickListener(v -> onOperationClick("*"));
        findViewById(R.id.divide).setOnClickListener(v -> onOperationClick("/"));
        findViewById(R.id.root).setOnClickListener(v -> onOperationClick("√"));
        findViewById(R.id.reverse).setOnClickListener(v -> onOperationClick("1/x"));

        findViewById(R.id.plusminus).setOnClickListener(v -> upend());

        findViewById(R.id.deleteAll).setOnClickListener(v -> clear());
        findViewById(R.id.deleteOne).setOnClickListener(v -> deleteLastCharacter());

        findViewById(R.id.equals).setOnClickListener(v -> calculateResult());
    }

    private void onNumberClick(String number) {
        if (isNewOperation && number.equals(".")) isNewOperation = false;
        if (isNewOperation) {
            if (!currentOperation.isEmpty() && resultField.getText().toString().isEmpty()){
                resultField.setText(numberField.getText().toString());
            }
            numberField.setText("");
            isNewOperation = false;
        }
        if (number.equals(".")){
            if (!pointCheck(numberField)) return;
        }
        numberField.append(number);
    }

    private void onOperationClick(String operation) {
        if (!numberField.getText().toString().isEmpty()) {
            firstOperand = !resultField.getText().toString().isEmpty() ?
                    resultField.getText().toString() : numberField.getText().toString();
            currentOperation = operation;
            operationField.setText(currentOperation);
            isNewOperation = true;
        }
    }

    private void calculateResult() {
        if (!firstOperand.isEmpty() && !numberField.getText().toString().isEmpty()) {
            double num1 = Double.parseDouble(firstOperand);
            double num2 = Double.parseDouble(numberField.getText().toString());
            double result = 0;

            switch (currentOperation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultField.setText("Ошибка");
                        return;
                    }
                    break;
                case "√":
                    result = Math.sqrt(num1);
                    break;
                case "1/x":
                    if (num1 != 0) {
                        result = 1 / num1;
                    } else {
                        resultField.setText("Ошибка");
                        return;
                    }
                    break;
            }

            resultField.setText(String.valueOf(result));
            firstOperand = String.valueOf(result);
            isNewOperation = true;
        }
    }

    private void clear() {
        numberField.setText("");
        resultField.setText("");
        operationField.setText("");
        firstOperand = "";
        currentOperation = "";
        isNewOperation = true;
    }

    private void upend(){
        if (numberField.getText().toString().isEmpty()) return;

        numberField.setText(numberField.getText().toString().charAt(0) != '-' ?
                "-".concat(numberField.getText().toString()) :
                numberField.getText().toString().substring(1));
    }

    private void deleteLastCharacter() {
        String currentText = numberField.getText().toString();
        if (!currentText.isEmpty()) {
            numberField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    private boolean pointCheck(EditText number){
        String currNumber = number.getText().toString();
        return !(currNumber.isEmpty() || currNumber.indexOf('.') != -1);

    }
}
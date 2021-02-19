package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Spinner spinner;
    Button button;
    TextView textView;
    ArrayAdapter<String> adapter;
    String [] options = { "sumar", "restar", "multiplicar", "dividir" };

    public void calcular(View view) {

        et2.setError(null);
        et1.setError(null);

        if (TextUtils.isEmpty(et1.getText())){
            et1.setError(getString(R.string.error));
            return;
        } else if(TextUtils.isEmpty(et2.getText())){
            et2.setError(getString(R.string.error));
            return;
        }

        String input1 = et1.getText().toString();
        String input2 = et2.getText().toString();

        int value1 = Integer.parseInt(input1);
        int value2 = Integer.parseInt(input2);
        int result = 0;

        String option = spinner.getSelectedItem().toString();
        String textResult;

        switch (option) {
            case "sumar":
                result = value1 + value2;
                break;
            case "restar":
                result = value1 - value2;
                break;
            case "multiplicar":
                result = value1 * value2;
                break;
            case "dividir":
                if (value2 == 0){
                    et2.setError(getString(R.string.division_error));
                    return;
                } else {
                    result = value1 / value2;
                }
                break;
        }

        textResult = String.valueOf(result);
        textView.setText(textResult);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        spinner = findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        adapter = new ArrayAdapter<>(this, R.layout.spinner_item, options);
        spinner.setAdapter(adapter);
    }
}
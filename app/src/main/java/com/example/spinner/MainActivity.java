package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinnerFrom);
        Spinner spinner2 = findViewById(R.id.spinner2);

        // Настраиваем адаптер
        ArrayAdapter<?> adapter =
                ArrayAdapter.createFromResource(this, R.array.catNames,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Вызываем адаптер
        spinner.setAdapter(adapter);

        // Настраиваем адаптер
        ArrayAdapter<?> adapter2 =
                ArrayAdapter.createFromResource(this, R.array.catNames,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Вызываем адаптер
        spinner2.setAdapter(adapter);

        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
        selected = spinner.getSelectedItem().toString();

        String selected2 = spinner2.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected2, Toast.LENGTH_SHORT).show();
        selected2 = spinner2.getSelectedItem().toString();
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editValue = findViewById(R.id.valuefrom);
                if(!editValue.getText().toString().trim().isEmpty())
                {
                    double value = Double.parseDouble(editValue.getText().toString());
                    int spinnerFromPos = spinner.getSelectedItemPosition();
                    switch (spinnerFromPos) {
                        case 0:
                            value = value / 1000;
                            break;
                        case 1:
                            value = value / 100;
                            break;
                        case 3:
                            value = value * 1000;
                            break;
                    }
                            ((TextView)findViewById(R.id.textView3)).setText(Double.toString(value));

                }
                else
                {
                    ((TextView)findViewById(R.id.textView3)).setText("данные введены неверно");
                }
            }
        });


    }

}
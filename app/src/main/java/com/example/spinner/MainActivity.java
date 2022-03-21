package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

        Spinner spinnerF = findViewById(R.id.spinnerFrom);
        Spinner spinnerT = findViewById(R.id.spinner2);

        // Настраиваем адаптер//
        ArrayAdapter<?> adappterLenghtNames =
                ArrayAdapter.createFromResource(this, R.array.lenghtNames,
                        android.R.layout.simple_spinner_item);
        adappterLenghtNames.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Вызываем адаптер


        // Настраиваем адаптер
        ArrayAdapter<?> adapterWeithNames =
                ArrayAdapter.createFromResource(this, R.array.weithNames,
                        android.R.layout.simple_spinner_item);
        adappterLenghtNames.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Вызываем адаптер

        String selected = spinnerT.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
        selected = spinnerT.getSelectedItem().toString();

        String selected2 = spinnerT.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), selected2, Toast.LENGTH_SHORT).show();
        selected2 = spinnerT.getSelectedItem().toString();
        Button button = findViewById(R.id.button2);

        RadioGroup radioGroup =findViewById(R.id.rg);
        //--------------------------------------------------------------------------
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (radioGroup.getCheckedRadioButtonId() == -1)
            {
                // no radio buttons are checked
            }
            else if (radioGroup.getCheckedRadioButtonId() == 0)
            {
                spinnerT.setAdapter(adappterLenghtNames);

            }
            else
            {
                spinnerF.setAdapter(adappterLenghtNames);

            }

        });
        button.setOnClickListener(view -> {
            EditText editValue = findViewById(R.id.valuefrom);
            if(!editValue.getText().toString().trim().isEmpty())
            {
                double value = Double.parseDouble(editValue.getText().toString());
                int spinnerFromPos = spinnerF.getSelectedItemPosition();
                int spinnerTo = spinnerT.getSelectedItemPosition();
                switch (spinnerTo){
                    case 0:
                        switch (spinnerFromPos) {
                            case 0:
                                break;
                            case 1:
                                value *= 10;
                                break;
                            case 2:
                                value *= 1000;
                                break;
                                }
                    break;
                    case 1:
                        switch (spinnerFromPos) {
                            case 0:
                                value /= 10;
                                break;
                            case 1:
                                break;
                            case 2:
                                value *= 100;
                                break;
                        }
                        break;
                    case 2:
                        switch (spinnerFromPos) {
                            case 0:
                                value /= 1000;
                                break;
                            case 1:
                                value /= 100;
                                break;
                            case 2:
                                break;
                        }
                        break;

                }
                DecimalFormat decimalFormat = new DecimalFormat("#.################");

                        ((TextView)findViewById(R.id.valueTo)).setText(decimalFormat.format(value));

            }
            else
            {
                ((TextView)findViewById(R.id.valueTo)).setText("данные введены неверно");
            }

        });


    }

}
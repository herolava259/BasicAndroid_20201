package com.example.unitconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;

public class ConvertActivity extends AppCompatActivity {

    public final String[] currencíes = {"U.S dollar", "Vietnamese dong", "Euro", "Japanese yen", "British pound"};
    public final double[] parValueRates = {1.0000, 22678.0000, 0.8835, 113.3600, 0.7495};

    public final String[] masses = {"Ton(t)", "Kilogram(kg)", "Decagram(dag)", "Gram(g)", "Cara"};
    public final double[] parMassRates = {0.0010, 1.0000, 100, 1000.0000, 5000};

    private int convertType;

    private int itemFrom = 0;
    private int itemTo = 0;

    public EditText editText;
    public String typeUnit = "^.^";
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        editText = (EditText) findViewById(R.id.convert_unit);
        //editText.setInputType(InputType.Typ

        result = (TextView) findViewById(R.id.result_title);

        Intent intent = getIntent();
        convertType = Integer.parseInt(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
        ArrayAdapter<String> adapterFrom;
        ArrayAdapter<String> adapterTo;
        Spinner spinnerFrom = findViewById(R.id.measure_from);
        Spinner spinnerTo = findViewById(R.id.measure_to);


        switch (convertType) {
            case R.id.currency_btn:
                typeUnit = currencíes[0];
                ((TextView) findViewById(R.id.convert_title)).setText("Currency");
                adapterFrom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currencíes);
                adapterTo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currencíes);
                spinnerFrom.setAdapter(adapterFrom);

                spinnerTo.setAdapter(adapterTo);
                break;
            case R.id.mass_btn:
                typeUnit = masses[0];
                ((TextView) findViewById(R.id.convert_title)).setText("Mass");
                adapterFrom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, masses);
                adapterTo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, masses);
                spinnerFrom.setAdapter(adapterFrom);

                spinnerTo.setAdapter(adapterTo);
                break;

            default:
                ((TextView) findViewById(R.id.convert_title)).setText("Currency");
                adapterFrom = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currencíes);
                adapterTo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, currencíes);
                spinnerFrom.setAdapter(adapterFrom);

                spinnerTo.setAdapter(adapterTo);
                break;
        }
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemFrom = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemTo = i;
                switch (convertType) {
                    case R.id.currency_btn:
                        typeUnit = currencíes[i];
                        break;
                    case R.id.mass_btn:
                        typeUnit = masses[i];
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private double caculate(double in) {
        double res = 0.0;
        switch (convertType) {
            case R.id.currency_btn:
                res = (parValueRates[itemTo] / parValueRates[itemFrom]) * in;
                break;
            case R.id.mass_btn:
                res = (parMassRates[itemTo] / parMassRates[itemFrom]) * in;
            default:
                break;
        }

        return res;
    }


    public void showResult(View view) {
        double input_convert = Double.parseDouble(editText.getText().toString());
        result.setText(Double.toString(caculate(input_convert)) + " " + typeUnit);
    }
}
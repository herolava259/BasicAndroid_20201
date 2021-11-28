package com.example.unitconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_MESSAGE = "com.example.android.unitconversionapp.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button currency_btn = (Button)findViewById(R.id.currency_btn);
        currency_btn.setOnClickListener(this);
        Button length_btn = (Button)findViewById(R.id.length_btn);
        length_btn.setOnClickListener(this);

        Button vol_btn = (Button)findViewById(R.id.vol_btn);
        vol_btn.setOnClickListener(this);

        Button mass_btn = (Button)findViewById(R.id.mass_btn);
        mass_btn.setOnClickListener(this);

        Button area_btn = (Button)findViewById(R.id.area_btn);
        area_btn.setOnClickListener(this);

        Button speed_btn = (Button)findViewById(R.id.speed_btn);
        speed_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int btnClickedId = view.getId();

        Intent intent  = new Intent(this, ConvertActivity.class);
        String message = Integer.toString(btnClickedId);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
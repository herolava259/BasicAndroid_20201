package com.example.HelloConstraint;

import static HelloConstraint.R.color.button_material_dark;
import static HelloConstraint.R.color.design_default_color_primary_dark;
import static HelloConstraint.R.color.purple_500;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import HelloConstraint.R;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView) findViewById(R.id.show_count);
    }


    public void showToast(View view) {

        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);

        toast.show();
    }


    @SuppressLint("ResourceAsColor")
    public void countUp(View view){
        Set_ButtonCount(false);
        if(mShowCount != null) mShowCount.setText(Integer.toString(mCount));
    }

    @SuppressLint("ResourceAsColor")
    public void resetZero(View view) {

        Set_ButtonCount(true);
        //Button btn = (Button)view;
        //btn.setBackgroundColor(purple_200);
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    @SuppressLint("ResourceAsColor")
    private void Set_ButtonCount(boolean reset ){
        View view = findViewById(R.id.button_count);
        if(!reset){
            mCount++;

        }else {
            mCount = 0;

        }
        if(mCount%2 == 0){
            view.setBackgroundColor(getResources().getColor(R.color.teal_200));

        }else {
            view.setBackgroundColor(R.color.purple_200);
        }

    }
}
package com.example.classassignment_week06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    EditText Name;
    EditText Mssv;
    EditText Birth;
    RadioButton male;
    RadioButton female;
    EditText Address;
    EditText PhoneNumber;
    EditText Email;
    CheckBox sp, ms, dl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = findViewById(R.id.Name);
        Mssv = findViewById(R.id.Mssv);
        Birth = findViewById(R.id.Birth);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        Address = findViewById(R.id.address);
        PhoneNumber = findViewById(R.id.phonenumber);
        Email = findViewById(R.id.email);

        sp = findViewById(R.id.sport);
        ms = findViewById(R.id.music);
        dl = findViewById(R.id.Travel);
        Name.setText("");
        Mssv.setText("");
        Birth.setText("");
        PhoneNumber.setText("");
        Email.setText("");

    }

    public void onSubmit(View view) {
        boolean checked = true;
        String notify = "";
        if(Name.getText().toString().equals("")){
            notify += "Name is not null\n";
            checked = false;
        }
        if(Mssv.getText().toString().equals("")){
            notify += "Mssv is not null\n";
            checked = false;
        }
        if(Birth.getText().toString().equals("")){
            notify += "Birth is not null\n";
            checked = false;
        }
        if(PhoneNumber.getText().toString().equals("")){
            notify += "Phone Number is not null\n";
            checked=false;
        }
        if(Email.getText().toString().equals("")){
            notify += "Email is not null\n";
            checked=false;
        }
        if(checked){
            notify = "Submit is successful!";
        }else{
            notify += "You need to the above field !";
        }

        Toast toast = Toast.makeText(this, notify,Toast.LENGTH_SHORT );
        toast.show();
    }
}
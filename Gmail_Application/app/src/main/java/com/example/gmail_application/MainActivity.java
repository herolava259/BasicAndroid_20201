package com.example.gmail_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    DATABASE database_records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List database = new DATABASE().dbList;

        CustomDataAdapter adapter = new CustomDataAdapter(this, database, R.layout.custom_item_layout);
        ListView myListGmail = (ListView)findViewById(R.id.message_list);

        myListGmail.setAdapter(adapter);
    }
}
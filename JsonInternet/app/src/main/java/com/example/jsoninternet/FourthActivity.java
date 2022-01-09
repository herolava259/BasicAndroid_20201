package com.example.jsoninternet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class FourthActivity extends AppCompatActivity {

    private static final String IMGSRC = "https://lebavui.github.io";

    private ImageView imgThumb;
    private ImageView imgPhoto;

    private TextView   nameField;
    private TextView   idField;
    private TextView   userNameField;
    private TextView   emailField;
    private TextView   websiteField;
    private TextView   addrField;
    private TextView   zipcodeField;
    private TextView   geoField;
    private TextView   phoneField;
    private TextView   companyField;
    private TextView   catchPharseField;
    private TextView   bsField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        imgPhoto = (ImageView) findViewById(R.id.img_photo);
        imgThumb = (ImageView) findViewById(R.id.img_thumb);

        nameField = (TextView) findViewById(R.id.name_field);
        idField = (TextView) findViewById(R.id.id_field);
        userNameField = (TextView) findViewById(R.id.username_field);
        emailField = (TextView) findViewById(R.id.email_field);
        websiteField = (TextView) findViewById(R.id.website_field);
        addrField = (TextView) findViewById(R.id.addr_field);
        zipcodeField = (TextView) findViewById(R.id.zipcode_field);
        geoField = (TextView) findViewById(R.id.geo_field);
        phoneField = (TextView) findViewById(R.id.phone_field);
        companyField = (TextView) findViewById(R.id.company_name);
        catchPharseField = (TextView) findViewById(R.id.catchPharse_field);
        bsField = (TextView) findViewById(R.id.bs_field);


        Intent intent = getIntent();

        int idx = Integer.parseInt(intent.getStringExtra(ThirdActivity.EXTRA_MESSAGE));
        ProfileModel profile = JsonLoader.getStructData().get(idx);

        nameField.setText(profile.getName());
        idField.setText(Integer.toString(profile.getId()));
        userNameField.setText(profile.getUserName());
        emailField.setText(profile.getEmail());
        websiteField.setText(profile.getWebsite());

        ProfileModel.Address adr = profile.getAddr();

        String addr =adr.suite + ", " + adr.street + " street, " + adr.city + " city";
        addrField.setText(addr);

        zipcodeField.setText(adr.zipcode);
        geoField.setText(adr.geo.lat + "     " + adr.geo.lng);

        phoneField.setText(profile.getPhone());
        companyField.setText(profile.getCompany().name);
        catchPharseField.setText(profile.getCompany().catchPharse);
        bsField.setText(profile.getCompany().bs);


        checkNetWork();
        Picasso.get().load(IMGSRC + profile.getAvt().photoPath).into(imgPhoto);
        Picasso.get().load(IMGSRC + profile.getAvt().thumbPath).into(imgThumb);


    }

    private void checkNetWork(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            Log.v("TAG", "Connected");
        else
            Log.v("TAG", "Not connected");

        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo.isConnected())
            Log.v("TAG", "Wifi");

        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo.isConnected())
            Log.v("TAG", "Mobile");
    }
}
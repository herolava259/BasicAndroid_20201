package com.example.jsoninternet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.jsoninternet.ProfileModel;
import com.squareup.picasso.Picasso;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity implements ItemClickListener{

    private static final String origSrc = "https://lebavui.github.io/";
    public static final String EXTRA_MESSAGE = "com.example.android.unitconversionapp.extra.INDEX";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ArrayList<ProfileModel> models =  JsonLoader.getStructData();

        if(models == null){
            Log.v("Tag", "Third Activity don't load data");
            models = new ArrayList<ProfileModel>();
        }
//        TextView txt = findViewById(R.id.text_demo);
//        ProfileModel model = models.get(0);
//        txt.setText(model.getName()+ ", " + model.getWebsite());

//        (ArrayList<ProfileModel>) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);
        checkNetWork();

        RecyclerView profileViews = (RecyclerView) findViewById(R.id.profile_list);
        profileViews.setHasFixedSize(true);
        profileViews.setLayoutManager(new LinearLayoutManager(this));
        profileViews.setAdapter(new ProfileAdapter(models, this));

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

    @Override
    public void onAction(int idx) {
        Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
        intent.putExtra(ThirdActivity.EXTRA_MESSAGE, Integer.toString(idx));
        startActivity(intent);
    }
}
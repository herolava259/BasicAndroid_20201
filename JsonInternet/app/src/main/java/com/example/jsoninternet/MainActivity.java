package com.example.jsoninternet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private boolean isLoad = false;
    private static JsonLoader loader;
    public static final String PATH = "https://lebavui.github.io/jsons/users.json";
    public static final String EXTRA_MESSAGE = "com.example.android.unitconversionapp.extra.PROFILES";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn_load);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isLoad){
//                    isLoad = true;
                    new LoadJsonData().execute();
                }
            }
        });
        loader = new JsonLoader(PATH);

        ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()){
            Log.v("TAG", "Connected");
        }else{
            Log.v("TAG", "Not Connected");
        }

        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if(networkInfo.isConnected()){
            Log.v("TAG", "Wifi");
        }

        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(networkInfo.isConnected()){
            Log.v("TAG", "Mobile");
        }
    }

    public static ArrayList<ProfileModel> getStructureData(){
        return loader.getStructData();
    }

    private class LoadJsonData extends AsyncTask<Void, Void, Void>{

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMessage("Loading Data...");
            dialog.show();

            Log.v("TAG", "Download started");
        }

        @Override
        protected Void doInBackground(Void... booleans) {
            try{
                loader.loadData();
            }catch(Exception ex){
                ex.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void s) {
            dialog.dismiss();
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
//            intent.putExtra(MainActivity.EXTRA_MESSAGE, "loader.getStructData()");
            startActivity(intent);


        }
    }
}
package com.example.jsoninternet;

import android.util.Log;

import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
//import org.json.JSONObject;
import org.json.JSONArray;
//import com.example.jsoninternet.ProfileModel;

public class JsonLoader {
    private String path;
    private JSONArray jsonArr;
    private String dataString;
    private static ArrayList<ProfileModel> profiles;
    private static boolean isLoad = false;
    public JsonLoader(String path){
        this.path = path;
        profiles = new ArrayList<ProfileModel>();
    }

    public void loadData() throws Exception{

        if(isLoad){
            return;
        }

        URL url = new URL(path);
        HttpURLConnection conn =(HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");

        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        while((line = reader.readLine() )!= null){
            builder.append(line);
        }
        dataString = builder.toString();
        Log.v("TAG", dataString);

        jsonArr = new JSONArray(dataString);
        Log.v("TAG", Integer.toString(jsonArr.length()));
        for(int i=0; i < jsonArr.length(); i++){
            profiles.add(new ProfileModel(jsonArr.getJSONObject(i)));
        }
        Log.v("TAG", Integer.toString(profiles.size()));
        reader.close();
        isLoad = true;
    }

   public static ArrayList<ProfileModel> getStructData(){
        return profiles;
   }

}

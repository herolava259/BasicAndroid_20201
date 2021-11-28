package com.example.gmail_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

class CustomDataAdapter extends BaseAdapter {

    Context context;
    int layoutInflatedID;
    List<DATABASE.DbRecord> dbRecordList;

    public CustomDataAdapter(Context context, List<DATABASE.DbRecord> databaseList, int resource){
        this.context = context;
        this.dbRecordList = databaseList;
        this.layoutInflatedID = resource;

    }
    @Override
    public int getCount() {
        return dbRecordList.size();
    }

    @Override
    public DATABASE.DbRecord getItem(int i) {
        return dbRecordList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        View row = convertView;

        if(row == null){
            LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
            row = inflater.inflate(layoutInflatedID,null);

            holder = new MyViewHolder();

            holder.btn = (Button) row.findViewById(R.id.btn_content);
            holder.gmailTitle = (TextView) row.findViewById(R.id.text_title);
            holder.messageContent = (TextView) row.findViewById(R.id.text_content);

            row.setTag(holder);
        }else{
            holder = (MyViewHolder) row.getTag();
        }
        DATABASE.DbRecord dbRec = getItem(position);
        holder.btn.setText(dbRec.firstLetter);
        // process style
        holder.gmailTitle.setText(dbRec.gmail);
        holder.messageContent.setText(dbRec.message);

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Message of " +dbRec.gmail + " is opened", Toast.LENGTH_SHORT).show();
            }
        });



        return row;
    }

    public class MyViewHolder{
        Button btn;
        TextView gmailTitle;
        TextView messageContent;
    }
}

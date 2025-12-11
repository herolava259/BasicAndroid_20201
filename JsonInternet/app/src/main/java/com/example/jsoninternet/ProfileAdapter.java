package com.example.jsoninternet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>{

    private static final String IMGSRC = "https://lebavui.github.io";
    private ArrayList<ProfileModel> models;
    private ItemClickListener listener;

    public ProfileAdapter(ArrayList<ProfileModel> items , ItemClickListener listener){
        this.models = items;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ProfileViewHolder holder, int position) {
        ProfileModel profile = models.get(position);

        String path = IMGSRC + profile.getAvt().thumbPath;
        Picasso.get().load(path).into(holder.img);

        holder.title.setText(profile.getUserName());
        holder.setIdx(position);

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    @NonNull
    @Override
    public ProfileAdapter.ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ProfileViewHolder(view, listener);
    }

    public ProfileAdapter(ArrayList<ProfileModel> models) {
        super();
        this.models = models;

    }

    class ProfileViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        Button btnSelect;
        ItemClickListener listener;
        int idx;

        public ProfileViewHolder(@NonNull View itemView, ItemClickListener listener) {


            super(itemView);
            title = (TextView)itemView.findViewById(R.id.user_title);
            img = (ImageView)itemView.findViewById(R.id.image_avatar);
            btnSelect = (Button)itemView.findViewById(R.id.btnSelect);
            btnSelect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onAction(idx);
                }
            });
            this.listener = listener;



        }

        public void setIdx(int idx){
            this.idx = idx;
        }
    }
}

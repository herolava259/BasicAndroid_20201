package com.example.grid_view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount(){
        return mThumbIds.length;
    }
    public Object getItem(int postion){
        return null;
    }
    public long getItemId(int postion){
        return 0;
    }

    public View getView(int postion, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(85,85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[postion]);
        return imageView;
    }

    private Integer[] mThumbIds = {
    };
//    R.drawable.sample_2, R.drawable.sample_3,
//    R.drawable.sample_4, R.drawable.sample_5,
//    R.drawable.sample_6, R.drawable.sample_7,
//    R.drawable.sample_0, R.drawable.sample_1,
//    R.drawable.sample_2, R.drawable.sample_3,
//    R.drawable.sample_4, R.drawable.sample_5,
//    R.drawable.sample_6, R.drawable.sample_7,
//    R.drawable.sample_0, R.drawable.sample_1,
//    R.drawable.sample_2, R.drawable.sample_3,
//    R.drawable.sample_4, R.drawable.sample_5,
//    R.drawable.sample_6, R.drawable.sample_7

}

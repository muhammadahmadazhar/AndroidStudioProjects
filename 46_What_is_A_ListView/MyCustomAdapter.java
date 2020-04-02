package com.example.application46;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class MyCustomAdapter extends ArrayAdapter<String> {
    public MyCustomAdapter(@NonNull Context context, String [] fruits) {
        super(context, R.layout.custome_row, fruits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customview = myInflater.inflate(R.layout.custome_row, parent,false);

        TextView mytext = (TextView) customview.findViewById(R.id.textView2);
        ImageView myimage = (ImageView) customview.findViewById((R.id.imageView));
        String singelfruititem = getItem(position);

        mytext.setText(singelfruititem);
        myimage.setImageResource(R.drawable.apple);
        return customview;
    }
}

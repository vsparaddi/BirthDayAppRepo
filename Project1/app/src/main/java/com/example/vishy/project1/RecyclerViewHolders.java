package com.example.vishy.project1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageView;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imageView = (ImageView) itemView.findViewById(R.id.image1);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), " Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();

    }
}
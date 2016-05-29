package com.example.vishy.project1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.vishy.project1.Model.StoryModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<StoryModel> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<StoryModel> itemList) {
        this.itemList = itemList;
        this.context = context;

    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {

        //ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.image1);
        ImageButton imageView = (ImageButton) holder.itemView.findViewById(R.id.image1);
        StoryModel story = itemList.get(position);
        if (imageView != null) {
            imageView.setImageResource(story.getIconId());
        }
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

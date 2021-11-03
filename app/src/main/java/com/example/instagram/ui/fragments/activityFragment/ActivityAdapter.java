package com.example.instagram.ui.fragments.activityFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.ui.models.Model;
import com.example.instagram.ui.models.Model_activity;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    private ArrayList<Model_activity> list;

    public void setList(ArrayList<Model_activity> list) {
        this.list = new ArrayList<>();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_activity,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  ActivityAdapter.ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView,imageView2;
        private TextView post;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.oval_iv);
            imageView2 = itemView.findViewById(R.id.liked_photo_iv);
            post = itemView.findViewById(R.id.timeLiked_tv);
        }
        public void onBind(Model_activity model) {
            imageView.setImageResource(model.getImage());
            imageView2.setImageResource(model.getLiked_photo());
            post.setText(model.getPost());

        }
    }
}

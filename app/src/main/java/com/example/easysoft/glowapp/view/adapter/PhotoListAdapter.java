package com.example.easysoft.glowapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.easysoft.glowapp.R;
import com.example.easysoft.glowapp.model.PhotoList;

import java.util.List;

/**
 * Created by YATRAONLINE\sushant.kumar on 24/8/18.
 */

public class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {
    private Context mContext;
    private List<PhotoList> photoLists;
    private static final long FADE_DURATION = 300;
    private int lastPosition = -1;

    public PhotoListAdapter(Context context,List<PhotoList> photoLists){
        this.mContext = context;
        this.photoLists = photoLists;
    }

    @Override
    public PhotoListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new View
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PhotoList photoList = photoLists.get(position);
        if (photoList != null) {
            holder.mTextView.setText(photoList.getTitle());
            if (photoList.getImageUrl() != null) {
                Glide.with(mContext)
                        .load(photoList.getImageUrl())
                        .into(holder.mImageView);
            }
            setScaleAnimation(holder.itemView, position);
        }
    }

    private void setScaleAnimation(View view, int position) {
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.75f, 1.0f, 0.75f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
        }
    }

    @Override
    public int getItemCount() {
        return photoLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView =  v.findViewById(R.id.tv);
            mImageView = v.findViewById(R.id.iv_image);
        }

    }
}

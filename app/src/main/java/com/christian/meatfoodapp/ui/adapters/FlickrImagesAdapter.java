package com.christian.meatfoodapp.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.christian.meatfoodapp.R;
import com.christian.meatfoodapp.data.FlickrImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FlickrImagesAdapter extends RecyclerView.Adapter {
    private ArrayList<FlickrImage> images = new ArrayList<>();

    public void addImages(ArrayList<FlickrImage> images) {
        this.images.addAll(images);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FlickrImageViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.adapter_flickrimage, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FlickrImageViewHolder) holder).render(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    private class FlickrImageViewHolder extends RecyclerView.ViewHolder {

        public FlickrImageViewHolder(View itemView) {
            super(itemView);
        }

        public void render(FlickrImage image) {
            Picasso.with(itemView.getContext()).load(image.getUrl())
                    .fit()
                    .into((ImageView) itemView.findViewById(R.id.flickr_imageview));
        }
    }
}

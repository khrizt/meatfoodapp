package com.christian.meatfoodapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.christian.meatfoodapp.R;
import com.christian.meatfoodapp.data.FlickrImage;
import com.christian.meatfoodapp.ui.ProductsView;
import com.christian.meatfoodapp.ui.adapters.FlickrImagesAdapter;
import com.christian.meatfoodapp.ui.presenters.ProductsPresenter;

import java.util.ArrayList;

public class ProductsFragment extends BaseFragment implements ProductsView {
    private ProductsPresenter presenter;
    private RecyclerView list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_products, container, false);

        list = (RecyclerView) rootView.findViewById(R.id.products_list);
        list.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));
        if (list.getAdapter() == null) {
            list.setAdapter(new FlickrImagesAdapter());
        }

        presenter = new ProductsPresenter();
        presenter.setView(this);
        presenter.setFlickrApiKey(getString(R.string.flickr_api_key));

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void loadImages(ArrayList<FlickrImage> images) {
        rootView.findViewById(R.id.loading).setVisibility(View.GONE);
        rootView.findViewById(R.id.products_list).setVisibility(View.VISIBLE);

        ((FlickrImagesAdapter) list.getAdapter()).addImages(images);
        list.getAdapter().notifyDataSetChanged();
    }
}

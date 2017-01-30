package com.christian.meatfoodapp.ui;

import com.christian.meatfoodapp.data.FlickrImage;

import java.util.ArrayList;

public interface ProductsView extends BaseView {
    void loadImages(ArrayList<FlickrImage> images);
}

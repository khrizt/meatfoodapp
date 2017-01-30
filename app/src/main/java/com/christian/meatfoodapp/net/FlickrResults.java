package com.christian.meatfoodapp.net;

import com.christian.meatfoodapp.data.FlickrImage;

import java.util.ArrayList;

public interface FlickrResults {
    void loadResults(ArrayList<FlickrImage> results);
}

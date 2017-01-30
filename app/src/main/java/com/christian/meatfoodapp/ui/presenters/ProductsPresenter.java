package com.christian.meatfoodapp.ui.presenters;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.christian.meatfoodapp.AppApplication;
import com.christian.meatfoodapp.R;
import com.christian.meatfoodapp.data.FlickrImage;
import com.christian.meatfoodapp.net.FlickrParse;
import com.christian.meatfoodapp.net.FlickrResults;
import com.christian.meatfoodapp.ui.BaseView;
import com.christian.meatfoodapp.ui.ProductsView;

import java.util.ArrayList;

public class ProductsPresenter implements Presenter, FlickrResults {
    protected ProductsView view;
    protected String flickrApiKey;
    protected AsyncTask<Void, Void, Void> currentTask;

    public void setFlickrApiKey(String flickrApiKey) {
        this.flickrApiKey = flickrApiKey;
    }

    @Override
    public void resume() {
        currentTask = getFlickrClient()
                .setFlickrApiKey(flickrApiKey)
                .setListener(this)
                .execute();
    }

    @Override
    public void pause() {
        if (currentTask != null) {
            currentTask.cancel(true);
        }
    }

    @Override
    public void destroy() {
        if (currentTask != null) {
            currentTask.cancel(true);
        }
    }

    @Override
    public void setView(@NonNull BaseView view) {
        this.view = (ProductsView) view;
    }

    @Override
    public void loadResults(ArrayList<FlickrImage> results) {
        currentTask = null;
        view.loadImages(results);
    }

    protected FlickrParse getFlickrClient() {
        return new FlickrParse();
    }
}

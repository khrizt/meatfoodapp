package com.christian.meatfoodapp.net;

import android.os.AsyncTask;

import com.christian.meatfoodapp.data.FlickrImage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FlickrParse extends AsyncTask<Void, Void, Void> {

    private String baseUrl = "https://api.flickr.com/services/rest/?method=flickr.photos.search&per_page=10&nojsoncallback=1&format=json&";
    private String searchField = "tags=meat";
    private String apiKeyField = "api_key";
    private String flickrApiKey;
    private FlickrResults listener;
    private ArrayList<FlickrImage> results = new ArrayList<>();

    public FlickrParse setFlickrApiKey(String flickrApiKey) {
        this.flickrApiKey = flickrApiKey;

        return this;
    }

    public FlickrParse setListener(FlickrResults listener) {
        this.listener = listener;

        return this;
    }

    @Override
    protected Void doInBackground(Void... params) {
        URL uri;
        try {
            uri = new URL(baseUrl + searchField + "&" + apiKeyField + "=" + flickrApiKey);
        } catch (MalformedURLException e) {
            return null;
        }

        OkHttpClient client = getClient();
        Request request = new Request.Builder()
                .url(uri)
                .build();
        Response responses = null;

        try {
            responses = client.newCall(request).execute();
            String jsonData = responses.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray photos = jsonObject.getJSONObject("photos").getJSONArray("photo");

            for (int i = 0; i < photos.length(); i++) {
                FlickrImage flickrImage = FlickrImage.parse(photos.getJSONObject(i));
                if (flickrImage != null) {
                    results.add(flickrImage);
                }
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (listener != null) {
            listener.loadResults(results);
        }
    }

    protected OkHttpClient getClient() {
        return new OkHttpClient();
    }
}

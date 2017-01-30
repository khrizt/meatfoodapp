package com.christian.meatfoodapp.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FlickrImage {
    private String id;
    private String owner;
    private String secret;
    private String server;
    private String farm;
    private String title;
    private boolean isPublic;
    private boolean isFriend;
    private boolean isFamily;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getFarm() {
        return farm;
    }

    public void setFarm(String farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    public boolean isFamily() {
        return isFamily;
    }

    public void setFamily(boolean family) {
        isFamily = family;
    }

    public String getUrl() {
        return "https://farm" + getFarm() + ".staticflickr.com/"
                + getServer() + "/" + getId() + "_" + getSecret() + ".jpg";
    }

    public FlickrImage() {}

    public static FlickrImage parse(JSONObject jsonObject) {
        FlickrImage flickrImage = new FlickrImage();

        try {
            if (jsonObject.has("id") && jsonObject.get("id") != null) {
                flickrImage.setId(jsonObject.getString("id"));
            }
            if (jsonObject.has("owner") && jsonObject.get("owner") != null) {
                flickrImage.setOwner(jsonObject.getString("owner"));
            }
            if (jsonObject.has("secret") && jsonObject.get("secret") != null) {
                flickrImage.setSecret(jsonObject.getString("secret"));
            }
            if (jsonObject.has("server") && jsonObject.get("server") != null) {
                flickrImage.setServer(jsonObject.getString("server"));
            }
            if (jsonObject.has("farm") && jsonObject.get("farm") != null) {
                flickrImage.setFarm(jsonObject.getString("farm"));
            }
            if (jsonObject.has("title") && jsonObject.get("title") != null) {
                flickrImage.setTitle(jsonObject.getString("title"));
            }
            if (jsonObject.has("isPublic") && jsonObject.get("isPublic") != null) {
                flickrImage.setPublic(jsonObject.getInt("isPublic") == 1);
            }
            if (jsonObject.has("isFriend") && jsonObject.get("isFriend") != null) {
                flickrImage.setFriend(jsonObject.getInt("isFriend") == 1);
            }
            if (jsonObject.has("isFamily") && jsonObject.get("isFamily") != null) {
                flickrImage.setFamily(jsonObject.getInt("isFamily") == 1);
            }
        } catch (JSONException e) {
            flickrImage = null;
        }

        return flickrImage;
    }
}

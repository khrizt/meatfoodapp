package com.christian.meatfoodapp;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class AppApplication extends Application {

    private static AppApplication appSingleton;

    public static AppApplication getInstance() {
        return appSingleton;
    }

    public AppApplication() {
        super();
        appSingleton = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // twitter sdk init
        TwitterAuthConfig authConfig = new TwitterAuthConfig(getString(R.string.fabric_twitter_key), getString(R.string.fabric_twitter_secret));
        Fabric.with(this, new Twitter(authConfig));
    }
}

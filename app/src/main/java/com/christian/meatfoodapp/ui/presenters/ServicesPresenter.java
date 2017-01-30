package com.christian.meatfoodapp.ui.presenters;

import android.support.annotation.NonNull;
import android.view.View;

import com.christian.meatfoodapp.ui.BaseView;
import com.christian.meatfoodapp.ui.ServicesView;
import com.twitter.sdk.android.tweetui.SearchTimeline;

public class ServicesPresenter implements Presenter {
    protected ServicesView view;

    @Override
    public void resume() {
        SearchTimeline searchTimeline = new SearchTimeline.Builder()
                .query("meat is healthy")
                .build();

        view.onTweetsLoaded(searchTimeline);
    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setView(@NonNull BaseView view) {
        this.view = (ServicesView) view;
    }
}

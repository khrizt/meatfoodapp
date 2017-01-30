package com.christian.meatfoodapp.ui;

import com.twitter.sdk.android.tweetui.SearchTimeline;

public interface ServicesView extends BaseView {
    void onTweetsLoaded(SearchTimeline search);
}

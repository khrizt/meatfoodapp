package com.christian.meatfoodapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.christian.meatfoodapp.R;
import com.christian.meatfoodapp.ui.ServicesView;
import com.christian.meatfoodapp.ui.presenters.ServicesPresenter;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

public class ServicesFragment extends BaseFragment implements ServicesView {

    ServicesPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_services, container, false);

        presenter = new ServicesPresenter();
        presenter.setView(this);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onTweetsLoaded(SearchTimeline search) {
        rootView.findViewById(R.id.loading).setVisibility(View.GONE);
        rootView.findViewById(R.id.twitter_list).setVisibility(View.VISIBLE);

        final TweetTimelineListAdapter timelineAdapter = new TweetTimelineListAdapter(getContext(), search);
        ListView list = (ListView) rootView.findViewById(R.id.twitter_list);
        list.setAdapter(timelineAdapter);
    }
}

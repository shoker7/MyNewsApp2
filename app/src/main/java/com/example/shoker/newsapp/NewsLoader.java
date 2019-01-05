package com.example.shoker.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {


    private static final String USGS_REQUEST_URL =
            "https://content.guardianapis.com/search?show-tags=contributor&q=football&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";

    Context c;

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
      List<News> newsList= Query.fetchNewsData(USGS_REQUEST_URL);
      return newsList;
    }

}

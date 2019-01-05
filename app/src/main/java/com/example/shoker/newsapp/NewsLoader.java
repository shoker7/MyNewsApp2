package com.example.shoker.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.widget.Toast;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {


   private String url;
    public NewsLoader(Context context , String url) {
        super(context);
        this.url=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
      List<News> newsList= Query.fetchNewsData(url);
      return newsList;
    }

}

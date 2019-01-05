package com.example.shoker.newsapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private NewsAdpater mAdapter;
    LoaderManager loaderManager;

    String [] sections ;
    private  String url ="https://content.guardianapis.com/search?show-tags=contributor&section=politics&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView newsListView = findViewById(R.id.lv_list);

        sections=getResources().getStringArray(R.array.sections);

        mAdapter = new NewsAdpater(this, new ArrayList<News>());

        newsListView.setAdapter(mAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                News currentNews = mAdapter.getItem(position);
                Uri newsUri = Uri.parse(currentNews.getmUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(websiteIntent);
            }
        });

        loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, this);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                publishUI(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    /**
     * Update the screen to display information from the given {@link News}.
     */

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(this,url);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {

        mAdapter.clear();
        if(news!=null){
        mAdapter.addAll(news);
            Log.d("tracking ","onloadfinish");
        }


    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {

    }


    public void publishUI(int i){
        String selectedSection =sections[i];
        url ="https://content.guardianapis.com/search?show-tags=contributor&section="+selectedSection+"&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";
        loaderManager.restartLoader(0,null,this);
    }


}
/*

 */
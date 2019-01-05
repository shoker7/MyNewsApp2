package com.example.shoker.newsapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private NewsAdpater mAdapter;

    /*String [] sections ;
    String filterdURL =//"https://content.guardianapis.com/search?show-tags=contributor&section=politics&q=football&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";
    "https://content.guardianapis.com/search?show-tags=contributor&q=football&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView newsListView = findViewById(R.id.lv_list);

        mAdapter = new NewsAdpater(this, new ArrayList<News>());

        newsListView.setAdapter(mAdapter);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, this);

    }


    /**
     * Update the screen to display information from the given {@link News}.
     */

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(this);
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


   /* public void publishUI(int i){
        String selectedSection =sections[i];
        filterdURL ="https://content.guardianapis.com/search?show-tags=contributor&section="+selectedSection+"&q=football&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";
        loaderManager.restartLoader(0,null,this);
    }
    */

}
/*
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/filter_by"
        android:layout_marginRight="6dp"
        android:textSize="15sp"/>
   <Spinner
       android:id="@+id/spinner"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:entries="@array/sections_spinner"
       android:background="@color/comb2"
       android:prompt="@string/section_prompt"
       android:clickable="false"
       android:focusable="false"
       android:focusableInTouchMode="false"/>
</LinearLayout>
 */
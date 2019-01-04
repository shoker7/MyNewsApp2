package com.example.shoker.newsapp;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private NewsAdpater mAdapter;

    String [] sections ;
    String filterdURL ="https://content.guardianapis.com/search?show-tags=contributor&section=politics&q=football&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";
    //"https://content.guardianapis.com/search?show-tags=contributor&q="+category+"&api-key=e8efc59a-bc82-4f43-9673-b9c514b68655";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sections=getResources().getStringArray(R.array.sections);

        ListView newsListView = findViewById(R.id.list);
        mAdapter = new NewsAdpater(this, new ArrayList<News>());
        newsListView.setAdapter(mAdapter);

       /* newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("message","okkkkkkkkkkkkkkkkkkk");
                Toast.makeText(MainActivity.this, "hiiii", Toast.LENGTH_SHORT).show();
            }
        });
*/
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(0, null, this);

      /*  Spinner spinner =(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                publishUI(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */
    }


    @NonNull
    @Override
    public Loader<List<News>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new NewsLoader(this,filterdURL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        mAdapter.clear();
        if (news != null ) {
            mAdapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        //mAdapter.clear();
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
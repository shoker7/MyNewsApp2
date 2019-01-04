package com.example.shoker.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdpater extends ArrayAdapter<News> {

    public NewsAdpater(Context context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);
        TextView newsTitleTextView = (TextView) listItemView.findViewById(R.id.tv_title);
        String title = currentNews.getmTitle();
        newsTitleTextView.setText(title);

        TextView newsCategorytextView = (TextView) listItemView.findViewById(R.id.tv_sdetails);
        String category = currentNews.getmCategory();
        newsCategorytextView.setText(category);

        TextView newsDatetextView = (TextView) listItemView.findViewById(R.id.tv_date);
        String date = currentNews.getmDate();
        newsDatetextView.setText(date);

        TextView newsAuthortextView = (TextView) listItemView.findViewById(R.id.tv_author);
        String author = currentNews.getmAuthor();
        newsAuthortextView.setText(author);

        return listItemView;
    }
}
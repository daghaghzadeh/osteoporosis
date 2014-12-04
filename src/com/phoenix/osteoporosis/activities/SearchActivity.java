package com.phoenix.osteoporosis.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;
import com.phoenix.osteoporosis.adapters.SearchAdapter;
import com.phoenix.osteoporosis.util.Article;
import com.phoenix.osteoporosis.util.Global;

import java.util.ArrayList;

public class SearchActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);


    }

    public void search(View view) {

        TextView search_tv = (TextView) findViewById(R.id.searchText);
        ListView search_list = (ListView) findViewById(R.id.search_list);

        final ArrayList<Article> articles = Global.database.search(search_tv.getText().toString().trim());

        SearchAdapter adapter = new SearchAdapter(this, R.layout.search_list_item, articles);
        search_list.setAdapter(adapter);

        search_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Article article = articles.get(i);

                Intent intent = new Intent(SearchActivity.this,ArticleActivity.class);
                intent.putExtra("id",article.id);
                startActivity(intent);

            }
        });

    }
}
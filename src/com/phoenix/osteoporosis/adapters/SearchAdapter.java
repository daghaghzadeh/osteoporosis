package com.phoenix.osteoporosis.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.phoenix.osteoporosis.R;
import com.phoenix.osteoporosis.util.Article;
import com.phoenix.osteoporosis.util.Global;

import java.util.List;

/**
 * Created by phoenix on 04/12/2014.
 */
public class SearchAdapter extends ArrayAdapter<Article> {
    public SearchAdapter(Context context, int textViewResourceId, List<Article> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = Global.INFLATER.inflate(R.layout.search_list_item, null);

        TextView title_tv = (TextView) view.findViewById(R.id.search_item_title);

        Article item = getItem(position);

        title_tv.setText(item.title);

        return view;
    }
}

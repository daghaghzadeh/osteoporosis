package com.phoenix.osteoporosis.util;

import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by phoenix on 11/12/2014.
 */
public class DiagPage {
    public int id = -1;
    public int parent_id = -1;
    public String title = "";
    public String content = "";
    public int yesLink = -1;
    public int noLink = -1;
    public ArrayList<Integer> links;


    public void getFromCursor(Cursor cursor) {

        id = cursor.getInt(cursor.getColumnIndex("id"));
        parent_id = cursor.getInt(cursor.getColumnIndex("parent_id"));
        yesLink = cursor.getInt(cursor.getColumnIndex("yesLink"));
        noLink = cursor.getInt(cursor.getColumnIndex("noLink"));
        content = cursor.getString(cursor.getColumnIndex("content"));
        title = cursor.getString(cursor.getColumnIndex("title"));
        String linksText = cursor.getString(cursor.getColumnIndex("links"));
        String[] split = linksText.split(",");
        for (int i = 0; i < split.length; i++) {
            links.add(Integer.parseInt(split[i]));
        }

    }


}

package com.phoenix.osteoporosis.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by phoenix on 29/11/2014.
 */
public class Database {


    public SQLiteDatabase read() {
        return SQLiteDatabase.openDatabase(Global.DIR_DB + "/osteoporosis.sqlite", null, SQLiteDatabase.OPEN_READONLY);
    }

    public SQLiteDatabase write() {
        return SQLiteDatabase.openDatabase(Global.DIR_DB + "/osteoporosis.sqlite", null, SQLiteDatabase.OPEN_READWRITE);
    }

    public Article getArticle(int id) {
        Article article = null;

        SQLiteDatabase read = read();
        Cursor cursor = read.rawQuery("SELECT * FROM Articles WHERE ID = " + id, null);

        if (cursor.moveToNext()) {

            int fav = cursor.getInt(cursor.getColumnIndex("Fav"));
            String title = cursor.getString(cursor.getColumnIndex("Title"));
            String content = cursor.getString(cursor.getColumnIndex("Content"));

            article = new Article(id, title, content, fav);

        }

        read.close();

        return article;
    }

    public ArrayList<Article> search(String search_value) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ArrayList<Article> articles = new ArrayList<Article>();
        SQLiteDatabase read = read();
        Cursor cursor = read.rawQuery("SELECT * FROM Articles WHERE Title LIKE '%" + search_value + "%' OR Articles.Content LIKE '%" + search_value + "%'", null);
        while (cursor.moveToNext()) {
            ids.add(cursor.getInt(cursor.getColumnIndex("ID")));
        }
        for (int i = 0; i < ids.size(); i++) {
            articles.add(getArticle(ids.get(i)));
        }
        return articles;
    }

    public DiagPage getDiagPage(int id) {

        SQLiteDatabase read = read();
        Cursor cursor = read.rawQuery("SELECT * FROM Diagnosis WHERE id = " + id, null);
        DiagPage page = null;

        if (cursor.moveToNext()) {
            page = new DiagPage();
            page.getFromCursor(cursor);
        }
        return page;

    }


}

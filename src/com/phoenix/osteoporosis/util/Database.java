package com.phoenix.osteoporosis.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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


}

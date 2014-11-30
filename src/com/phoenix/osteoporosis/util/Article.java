package com.phoenix.osteoporosis.util;

/**
 * Created by phoenix on 29/11/2014.
 */
public class Article {
   public int id;
    public String title;
    public String content;
    public int fav;

    public Article(int id, String title, String content, int fav) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.fav = fav;
    }
}

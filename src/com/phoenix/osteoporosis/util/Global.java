package com.phoenix.osteoporosis.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;

import java.io.File;

/**
 * Created by phoenix on 28/11/2014.
 */
public class Global extends Application {
    public static ResourceHandler resourceHandler = new ResourceHandler();
    public static Database database = new Database();
    public static DiagContentSolver diagContentSolver = new DiagContentSolver();

    public static final String DIR_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String DIR_APP = DIR_SDCARD + "/BiP";
    public static final String DIR_TEMP = DIR_APP + "/temp";
    public static final String DIR_FINAL = DIR_APP + "/final";
    public static final String DIR_DB = DIR_APP + "/db";
    public static final String DIR_APP_TO_SEND = DIR_APP + "/app";
    public static final String DB_NAME = "osteoporosis.sqlite";
    public static LayoutInflater INFLATER;

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        new File(DIR_APP).mkdirs();
        new File(DIR_APP_TO_SEND).mkdirs();
        new File(DIR_DB).mkdirs();

        if (!new File(DIR_DB, DB_NAME).exists()) {
            resourceHandler.copyDB();
        }
        INFLATER = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

    }
}

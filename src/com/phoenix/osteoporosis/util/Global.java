package com.phoenix.osteoporosis.util;

import android.os.Environment;

/**
 * Created by phoenix on 28/11/2014.
 */
public class Global {
    public static ResourceHandler resourceHandler= new ResourceHandler();
    public static final String    DIR_SDCARD           = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String    DIR_APP              = DIR_SDCARD + "/BiP";
    public static final String    DIR_TEMP             = DIR_APP + "/temp";
    public static final String    DIR_FINAL            = DIR_APP + "/final";
    public static final String    DIR_APP_TO_SEND      = DIR_APP + "/app";
}

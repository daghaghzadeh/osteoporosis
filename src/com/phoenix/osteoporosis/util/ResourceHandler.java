package com.phoenix.osteoporosis.util;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * Created by phoenix on 28/11/2014.
 */
public class ResourceHandler {


    public void copyDB() {

        try {
            InputStream source = Global.context.getAssets().open("osteoporosis.db");
            File file = new File(Global.DIR_DB, Global.DB_NAME);
            FileOutputStream dest = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
                     int read;
            while((read = source.read(buffer)) !=-1){
                dest.write(buffer,0,read);
            }

            dest.flush();

            source.close();
            dest.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void copyFile(File from, File to) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;

        try {
            inChannel = new FileInputStream(from).getChannel();
            outChannel = new FileOutputStream(to).getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inChannel.close();
                outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } // End CopyFile()

}

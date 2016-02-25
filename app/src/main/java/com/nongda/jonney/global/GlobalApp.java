package com.nongda.jonney.global;

import java.io.File;

import android.annotation.SuppressLint;
import android.app.Application;

public class GlobalApp extends Application {
    // private static DynamicInvoker invoker = null;

    final static String WSDL_URL = "src/wsdl/NDAppWebService.asmx";

    private static GlobalApp instance = null;

    public static GlobalApp getInstance() {

        return instance;
    }

    public String aaao = "sdfasdf";

    public String fdfasdf() {
        return Math.random() + "" + aaao + WSDL_URL;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    @SuppressLint("NewApi")
    @Override
    public File getExternalCacheDir() {
        File[] temp = super.getExternalCacheDirs();
        return temp[temp.length - 1].getAbsoluteFile();
    }

    @SuppressLint("NewApi")
    @Override
    public File getExternalFilesDir(String type) {
        File[] temp = super.getExternalFilesDirs(type);
        return temp[temp.length - 1].getAbsoluteFile();
    }
    //
    // public static DynamicInvoker getInvoker() {
    // if (invoker == null)
    // try {
    // invoker = new DynamicInvoker(WSDL_URL);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return invoker;
    // }

}

// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 

package com.nongda.jonney.common;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;

import com.nongda.jonney.global.GlobalApp;
import com.nongda.jonney.util.MyIOUtil;

public class CacheMgr {

    private static int CONNECT_TIMEOUT = 15000;
    private static String LastErr = "";
    private static int READ_TIMEOUT = 15000;
    private static final String TAG = "CacheMgr";
    public static String cacheFolder = GlobalApp.getInstance().getExternalCacheDir() + File.separator;
    public static File cacheFolder_file = new File(cacheFolder);
    private static HashMap cacheMap = new HashMap();
    private static int defaultExpiresInSeconds = 120;
    private static int tempFileName = 0;

    public CacheMgr() {
    }

    private static Date AddSecond(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, i);
        return calendar.getTime();
    }

    public static void ClearAllCache() {
        if (cacheFolder_file.exists()) {
            DeleteFile(cacheFolder_file);
        }
    }

    public static void ClearExpiresCache() {

    }

    private static boolean DeleteFile(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                DeleteFile(file2);
            }
        }
        return file.delete();
    }

    public static boolean DoExpireCache(String s) {
        try {
            String s1 = new StringBuilder(cacheFolder).append(shortUrl(s)).toString();

            if (new File(s1 + ".body").exists()) {
                File file = new File(s1 + ".head");
                if (file.exists()) {
                    String as[] = (new String(MyIOUtil.getFileContent(file), "UTF-8")).trim().split(";");
                    MyIOUtil.writeFileContent(file, new StringBuilder(as[0]).append(";0").toString().getBytes("UTF-8"));
                    return true;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public static InputStream GetResource(String s, long l, Context context, Boolean boolean1) {

        if (l == 0L)
            l = defaultExpiresInSeconds;
        String sss = new StringBuilder(cacheFolder).append(shortUrl(s)).toString();
        String body = sss + ".body";
        String head = sss + ".head";
        File file = new File(body);
        File file1 = new File(head);
        boolean flag1 = file.exists();
        boolean flag2 = file1.exists();
        boolean flagNet = checkNetwork();
        if (flag1 && flag2) {
            String[] as1 = null;
            try {
                as1 = (new String(MyIOUtil.getFileContent(file1), "UTF-8")).trim().split(";");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            int ll = Integer.parseInt(as1[1]);
            boolean isngq;
            if (ll != -1) {
                isngq = AddSecond(new Date(as1[0]), ll).after(new Date());
            } else {
                isngq = true;
            }

            if (!boolean1 || !flagNet)
                if ((as1 != null && isngq) || (!flagNet && !isngq)) {
                    try {
                        return new FileInputStream(file);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }

        byte[] abyte0;
        try {
            URL url = new URL(s);

            URLConnection urlconnection = url.openConnection();
            urlconnection.setConnectTimeout(CONNECT_TIMEOUT);
            urlconnection.setReadTimeout(READ_TIMEOUT);
            InputStream inputstream = urlconnection.getInputStream();
            abyte0 = InputStream2Byte(inputstream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        DeleteFile(file1);
        DeleteFile(file);
        SetResource(abyte0, body, head, l, context);

        return new ByteArrayInputStream(abyte0);
    }

    public static byte[] InputStream2Byte(InputStream inputstream) throws IOException {
        byte[] content = MyIOUtil.getContent(inputstream);
        if (content == null)
            throw new IOException("ERROR");
        return content;

    }

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void SetResource(byte abyte0[], String s, String s1, long l, Context context) {
        File file = new File(cacheFolder);
        if (!file.exists())
            file.mkdirs();
        File file1 = new File(s1);
        File file2 = new File(s);
        if (!file1.exists())
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        try {
            MyIOUtil.writeFileContent(file1, (new StringBuilder(String.valueOf((new Date()).toGMTString()))).append(";")
                    .append(l).toString().getBytes("UTF-8"));
            if (!file2.exists())
                file2.createNewFile();
            MyIOUtil.writeFileContent(file2, abyte0);
        } catch (IOException e) {
            e.printStackTrace();
            if (file1.exists())
                file1.delete();
            if (file2.exists())
                file2.delete();
        }

    }

    public static boolean checkNetwork() {
        ConnectivityManager connectivitymanager = (ConnectivityManager) GlobalApp.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivitymanager.getActiveNetworkInfo() != null
                && connectivitymanager.getActiveNetworkInfo().isAvailable();
    }

    public static String formatFileSize(long l) {
        String s;
        if (l == 0L) {
            s = "0";
        } else {
            if (l >= 0x40000000L) {
                int i1 = String.valueOf((float) l / 1.073742E+009F).indexOf(".");
                return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((float) l / 1.073742E+009F)))
                        .append("000").toString().substring(0, i1 + 3)))).append("GB").toString();
            }
            if (l >= 0x100000L) {
                int k = String.valueOf((float) l / 1048576F).indexOf(".");
                return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((float) l / 1048576F)))
                        .append("000").toString().substring(0, k + 3)))).append("MB").toString();
            }
            if (l >= 1024L) {
                int j = String.valueOf((float) l / 1024F).indexOf(".");
                return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf((float) l / 1024F)))
                        .append("000").toString().substring(0, j + 3)))).append("KB").toString();
            }
            return (new StringBuilder(Long.toString(l))).append("B").toString();
        }
        return s;
    }

    public static String getCacheSize() {

        if (cacheFolder_file != null && cacheFolder_file.exists() && cacheFolder_file.isDirectory())
            return formatFileSize(getDirectorySize(cacheFolder_file));
        else
            return "0";
    }

    public static long getDirectorySize(File file) {
        long l = 0L;
        if (file == null || !file.exists() || !file.isDirectory())
            return 0;
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory())
                l += getDirectorySize(file1);
            else
                l += file1.length();
        }
        return l;
    }

    public static Drawable getDrawableFromURL(String s, Context context, Boolean boolean1) {
        return getDrawableFromURL(s, 0, context, boolean1);
    }

    public static Drawable getDrawableFromURL(String s, int l, Context context, Boolean boolean1) {
        InputStream is;
        int i;
        try {
            is = GetResource(s, l, context, boolean1);
            i = is.available();
        } catch (Exception exception) {
            return null;
        }
        if (i >= 0x7d000)
            return Drawable.createFromStream(is, "src");
        return Drawable.createFromStream(is, "src");
    }

    public static String getImageSize(Context context, String s) {
        File file = new File(new StringBuilder(cacheFolder).append(shortUrl(s)).append(".body").toString());
        if (!file.exists())
            return "";
        else
            return formatFileSize(file.length());
    }

    public static String shortUrl(String s) {
        String s1 = "";
        int i = 0;
        do {
            if (i >= s.length())
                return s1;
            if (s.charAt(i) != '/' && s.charAt(i) != ':' && s.charAt(i) != '?' && s.charAt(i) != '&'
                    && s.charAt(i) != '.' && s.charAt(i) != '=')
                s1 = (new StringBuilder(String.valueOf(s1))).append(s.charAt(i)).toString();
            i++;
        } while (true);
    }

}

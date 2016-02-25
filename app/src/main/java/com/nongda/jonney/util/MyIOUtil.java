package com.nongda.jonney.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyIOUtil {
    public static byte[] getFileContent(File file) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            return getContent(fis);
        } catch (Exception e) {
            e.printStackTrace();
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

        return null;
    }

    public static byte[] getFileContent(String url) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(url);
            return getContent(fis);
        } catch (Exception e) {
            e.printStackTrace();
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

        return null;
    }

    public static byte[] getContent(InputStream is) {
        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            bis = new BufferedInputStream(is);
            byte[] temp = new byte[1024 * 4];
            int p;
            while ((p = bis.read(temp)) != -1) {
                baos.write(temp, 0, p);
            }
            baos.flush();
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (bis != null)
                try {
                    bis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            if (is != null)
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

        return null;
    }

    public static boolean writeFileContent(File file, byte[] bytes) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean writeFileContent(String filesrc, byte[] bytes) {
        return writeFileContent(new File(filesrc), bytes);
    }
}

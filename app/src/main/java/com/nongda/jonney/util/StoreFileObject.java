package com.nongda.jonney.util;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StoreFileObject
{
  public static Object readObject(String paramString)
    throws IOException, ClassNotFoundException
  {
    Log.v("readObject path=====", paramString);
    FileInputStream localFileInputStream = new FileInputStream(paramString);
    ObjectInputStream localObjectInputStream = new ObjectInputStream(localFileInputStream);
    Object localObject = localObjectInputStream.readObject();
    localObjectInputStream.close();
    if (localFileInputStream != null)
      localFileInputStream.close();
    return localObject;
  }

  public static void writeObject(String paramString, Object paramObject)
    throws IOException
  {
    File localFile1 = new File(paramString);
    File localFile2 = localFile1.getParentFile();
    if (!localFile2.exists())
      localFile2.mkdir();
    if (!localFile1.exists())
      localFile1.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile1);
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localFileOutputStream);
    localObjectOutputStream.writeObject(paramObject);
    if (localFileOutputStream != null)
      localFileOutputStream.close();
    localObjectOutputStream.flush();
    localObjectOutputStream.close();
  }
}

/* Location:           D:\androidfby\classes_dex2jar.jar
 * Qualified Name:     com.hunaupalm.util.StoreFileObject
 * JD-Core Version:    0.6.2
 */
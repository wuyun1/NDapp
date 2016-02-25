package com.nongda.jonney.data;

import java.io.File;

public class DataBaseFactory {

    private static final String DATABASE_FILENAME = "msg005.db";
    private static String DATABASE_PATH = "/com/nongda/jonney/data/com.nongda.jonney.data/com.hunaupalm/databases/";

    public static boolean dbExists(String paramString) {
        boolean bool1 = new File(DATABASE_PATH + paramString).exists();
        boolean bool2 = false;
        if (bool1)
            bool2 = true;
        return bool2;
    }

    // ERROR //
    public static void init(android.content.Context paramContext, String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: new 24	java/lang/StringBuilder
        //   6: dup
        //   7: getstatic 15	com/hunaupalm/com.nongda.jonney.data/DataBaseFactory:DATABASE_PATH	Ljava/lang/String;
        //   10: invokestatic 30	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   13: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   20: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   23: astore_3
        //   24: new 22	java/io/File
        //   27: dup
        //   28: aload_3
        //   29: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
        //   32: invokevirtual 46	java/io/File:exists	()Z
        //   35: istore 4
        //   37: iload 4
        //   39: ifeq +7 -> 46
        //   42: ldc 2
        //   44: monitorexit
        //   45: return
        //   46: new 22	java/io/File
        //   49: dup
        //   50: getstatic 15	com/hunaupalm/com.nongda.jonney.data/DataBaseFactory:DATABASE_PATH	Ljava/lang/String;
        //   53: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
        //   56: astore 5
        //   58: aload 5
        //   60: invokevirtual 46	java/io/File:exists	()Z
        //   63: ifne +9 -> 72
        //   66: aload 5
        //   68: invokevirtual 55	java/io/File:mkdir	()Z
        //   71: pop
        //   72: aconst_null
        //   73: astore 6
        //   75: aconst_null
        //   76: astore 7
        //   78: aload_0
        //   79: invokevirtual 61	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   82: ldc 62
        //   84: invokevirtual 68	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
        //   87: astore 6
        //   89: new 70	java/io/FileOutputStream
        //   92: dup
        //   93: aload_3
        //   94: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   97: astore 14
        //   99: sipush 2048
        //   102: newarray byte
        //   104: astore 15
        //   106: aload 6
        //   108: aload 15
        //   110: invokevirtual 77	java/io/InputStream:read	([B)I
        //   113: istore 16
        //   115: iload 16
        //   117: ifgt +21 -> 138
        //   120: aload 14
        //   122: invokevirtual 82	java/io/OutputStream:flush	()V
        //   125: aload 14
        //   127: invokevirtual 85	java/io/OutputStream:close	()V
        //   130: aload 6
        //   132: invokevirtual 86	java/io/InputStream:close	()V
        //   135: goto -93 -> 42
        //   138: aload 14
        //   140: aload 15
        //   142: iconst_0
        //   143: iload 16
        //   145: invokevirtual 90	java/io/OutputStream:write	([BII)V
        //   148: goto -42 -> 106
        //   151: astore 8
        //   153: aload 14
        //   155: astore 7
        //   157: aload 8
        //   159: invokevirtual 93	java/lang/Exception:printStackTrace	()V
        //   162: aload 7
        //   164: invokevirtual 82	java/io/OutputStream:flush	()V
        //   167: aload 7
        //   169: invokevirtual 85	java/io/OutputStream:close	()V
        //   172: aload 6
        //   174: invokevirtual 86	java/io/InputStream:close	()V
        //   177: goto -135 -> 42
        //   180: astore 13
        //   182: goto -140 -> 42
        //   185: astore 9
        //   187: aload 7
        //   189: invokevirtual 82	java/io/OutputStream:flush	()V
        //   192: aload 7
        //   194: invokevirtual 85	java/io/OutputStream:close	()V
        //   197: aload 6
        //   199: invokevirtual 86	java/io/InputStream:close	()V
        //   202: aload 9
        //   204: athrow
        //   205: astore_2
        //   206: ldc 2
        //   208: monitorexit
        //   209: aload_2
        //   210: athrow
        //   211: astore 18
        //   213: goto -171 -> 42
        //   216: astore 11
        //   218: goto -16 -> 202
        //   221: astore 17
        //   223: goto -93 -> 130
        //   226: astore 10
        //   228: goto -31 -> 197
        //   231: astore 9
        //   233: aload 14
        //   235: astore 7
        //   237: goto -50 -> 187
        //   240: astore 12
        //   242: goto -70 -> 172
        //   245: astore 8
        //   247: aconst_null
        //   248: astore 7
        //   250: goto -93 -> 157
        //
        // Exception table:
        //   from	to	target	type
        //   99	106	151	java/lang/Exception
        //   106	115	151	java/lang/Exception
        //   138	148	151	java/lang/Exception
        //   172	177	180	java/io/IOException
        //   78	99	185	finally
        //   157	162	185	finally
        //   3	37	205	finally
        //   46	72	205	finally
        //   120	130	205	finally
        //   130	135	205	finally
        //   162	172	205	finally
        //   172	177	205	finally
        //   187	197	205	finally
        //   197	202	205	finally
        //   202	205	205	finally
        //   130	135	211	java/io/IOException
        //   197	202	216	java/io/IOException
        //   120	130	221	java/io/IOException
        //   187	197	226	java/io/IOException
        //   99	106	231	finally
        //   106	115	231	finally
        //   138	148	231	finally
        //   162	172	240	java/io/IOException
        //   78	99	245	java/lang/Exception
    }

    // ERROR //
    public static void initNewDB(android.content.Context paramContext, String paramString) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: new 24	java/lang/StringBuilder
        //   6: dup
        //   7: getstatic 15	com/hunaupalm/com.nongda.jonney.data/DataBaseFactory:DATABASE_PATH	Ljava/lang/String;
        //   10: invokestatic 30	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   13: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   16: aload_1
        //   17: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   20: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   23: astore_3
        //   24: new 22	java/io/File
        //   27: dup
        //   28: aload_3
        //   29: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
        //   32: invokevirtual 46	java/io/File:exists	()Z
        //   35: istore 4
        //   37: iload 4
        //   39: ifeq +7 -> 46
        //   42: ldc 2
        //   44: monitorexit
        //   45: return
        //   46: new 22	java/io/File
        //   49: dup
        //   50: getstatic 15	com/hunaupalm/com.nongda.jonney.data/DataBaseFactory:DATABASE_PATH	Ljava/lang/String;
        //   53: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
        //   56: astore 5
        //   58: aload 5
        //   60: invokevirtual 46	java/io/File:exists	()Z
        //   63: ifne +9 -> 72
        //   66: aload 5
        //   68: invokevirtual 55	java/io/File:mkdir	()Z
        //   71: pop
        //   72: aconst_null
        //   73: astore 6
        //   75: aload_0
        //   76: invokevirtual 61	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   79: ldc 62
        //   81: invokevirtual 68	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
        //   84: astore 7
        //   86: new 70	java/io/FileOutputStream
        //   89: dup
        //   90: aload_3
        //   91: invokespecial 71	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
        //   94: astore 8
        //   96: sipush 2048
        //   99: newarray byte
        //   101: astore 18
        //   103: aload 7
        //   105: aload 18
        //   107: invokevirtual 77	java/io/InputStream:read	([B)I
        //   110: istore 19
        //   112: iload 19
        //   114: ifgt +21 -> 135
        //   117: aload 8
        //   119: invokevirtual 82	java/io/OutputStream:flush	()V
        //   122: aload 8
        //   124: invokevirtual 85	java/io/OutputStream:close	()V
        //   127: aload 7
        //   129: invokevirtual 86	java/io/InputStream:close	()V
        //   132: goto -90 -> 42
        //   135: aload 8
        //   137: aload 18
        //   139: iconst_0
        //   140: iload 19
        //   142: invokevirtual 90	java/io/OutputStream:write	([BII)V
        //   145: goto -42 -> 103
        //   148: astore 15
        //   150: aload 8
        //   152: astore 6
        //   154: aload 15
        //   156: invokevirtual 97	java/io/FileNotFoundException:printStackTrace	()V
        //   159: aload 6
        //   161: invokevirtual 82	java/io/OutputStream:flush	()V
        //   164: aload 6
        //   166: invokevirtual 85	java/io/OutputStream:close	()V
        //   169: aload 7
        //   171: invokevirtual 86	java/io/InputStream:close	()V
        //   174: goto -132 -> 42
        //   177: astore 17
        //   179: goto -137 -> 42
        //   182: astore 9
        //   184: aload 9
        //   186: invokevirtual 98	java/io/IOException:printStackTrace	()V
        //   189: aload 6
        //   191: invokevirtual 82	java/io/OutputStream:flush	()V
        //   194: aload 6
        //   196: invokevirtual 85	java/io/OutputStream:close	()V
        //   199: aload 7
        //   201: invokevirtual 86	java/io/InputStream:close	()V
        //   204: goto -162 -> 42
        //   207: astore 14
        //   209: goto -167 -> 42
        //   212: astore 10
        //   214: aload 6
        //   216: invokevirtual 82	java/io/OutputStream:flush	()V
        //   219: aload 6
        //   221: invokevirtual 85	java/io/OutputStream:close	()V
        //   224: aload 7
        //   226: invokevirtual 86	java/io/InputStream:close	()V
        //   229: aload 10
        //   231: athrow
        //   232: astore_2
        //   233: ldc 2
        //   235: monitorexit
        //   236: aload_2
        //   237: athrow
        //   238: astore 21
        //   240: goto -198 -> 42
        //   243: astore 12
        //   245: goto -16 -> 229
        //   248: astore 20
        //   250: goto -123 -> 127
        //   253: astore 11
        //   255: goto -31 -> 224
        //   258: astore 10
        //   260: aload 8
        //   262: astore 6
        //   264: goto -50 -> 214
        //   267: astore 13
        //   269: goto -70 -> 199
        //   272: astore 9
        //   274: aload 8
        //   276: astore 6
        //   278: goto -94 -> 184
        //   281: astore 16
        //   283: goto -114 -> 169
        //   286: astore 15
        //   288: aconst_null
        //   289: astore 6
        //   291: goto -137 -> 154
        //
        // Exception table:
        //   from	to	target	type
        //   96	103	148	java/io/FileNotFoundException
        //   103	112	148	java/io/FileNotFoundException
        //   135	145	148	java/io/FileNotFoundException
        //   169	174	177	java/io/IOException
        //   86	96	182	java/io/IOException
        //   199	204	207	java/io/IOException
        //   86	96	212	finally
        //   154	159	212	finally
        //   184	189	212	finally
        //   3	37	232	finally
        //   46	72	232	finally
        //   75	86	232	finally
        //   117	127	232	finally
        //   127	132	232	finally
        //   159	169	232	finally
        //   169	174	232	finally
        //   189	199	232	finally
        //   199	204	232	finally
        //   214	224	232	finally
        //   224	229	232	finally
        //   229	232	232	finally
        //   127	132	238	java/io/IOException
        //   224	229	243	java/io/IOException
        //   117	127	248	java/io/IOException
        //   214	224	253	java/io/IOException
        //   96	103	258	finally
        //   103	112	258	finally
        //   135	145	258	finally
        //   189	199	267	java/io/IOException
        //   96	103	272	java/io/IOException
        //   103	112	272	java/io/IOException
        //   135	145	272	java/io/IOException
        //   159	169	281	java/io/IOException
        //   86	96	286	java/io/FileNotFoundException
    }
}

/* Location:           D:\androidfby\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     com.hunaupalm.com.nongda.jonney.data.DataBaseFactory
 * JD-Core Version:    0.6.2
 */
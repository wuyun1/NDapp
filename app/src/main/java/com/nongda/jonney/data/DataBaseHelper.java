package com.nongda.jonney.data;

import com.nongda.jonney.util.Preferences;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseHelper {
    private static final String DATABASE_FILENAME = "msg005.db";
    private static final int DATABASE_VERSION = 21;
    private static final int DATABASE_VERSION_DF = 21;
    private static final String TB1_TITLE = "tblTitle";
    private static final String TB2_DEPATER = "tblDepater";
    private static final String TB3_DEPATER = "tblTeacher";
    private static final String TB4_DEPATER = "tblOffice";
    private static final String TB5_DEPATER = "tblPublicTell";
    private static final String TB6_DEPATER = "tblTermOfdate";
    private static final String TB7_DEPATER = "tblPubAllTell";
    private static final String TB8_DEPATER = "tblLDTell";
    private static SQLiteDatabase db;
    private static final Object lock = new Object();
    private static Context mContext;
    private String DATABASE_FILENAME_MSG = "";

    public DataBaseHelper(Context paramContext, boolean paramBoolean) {
        if (paramBoolean)
            ;
        for (this.DATABASE_FILENAME_MSG = "nongda.db"; ; this.DATABASE_FILENAME_MSG = "dongfang.db") {
            mContext = paramContext;
            onCreate(this.DATABASE_FILENAME_MSG);
            return;
        }
    }

    public static boolean ColumnExists(String paramString1, String paramString2) {
        Cursor localCursor = db.rawQuery("select * from " + paramString1, null);
        int i = localCursor.getColumnCount();
        boolean bool = false;
        if (i > 0) {
            int j = localCursor.getColumnIndex(paramString2);
            bool = j != -1;
        }
        return bool;
    }

    public static boolean TableExists(String paramString) {
        int i = db.rawQuery("select * from sqlite_master where type='table' and tbl_name='" + paramString + "' ", null)
                .getCount();
        boolean bool = false;
        if (i > 0)
            bool = true;
        return bool;
    }

    public static void changeMsgReadState() {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("Read", "1");
        db.update("tblXMPPMsg", localContentValues, "Read=0", null);
    }

    public static int deleteData(String paramString1, String paramString2, String[] paramArrayOfString) {
        return db.delete(paramString1, paramString2, paramArrayOfString);
    }

    public static void execCommonSQL(String paramString) {
        db.execSQL(paramString);
    }

    public static void execCommonSQL(String paramString, Object[] paramArrayOfObject) {
        db.execSQL(paramString, paramArrayOfObject);
    }

    public static long insertData(String paramString1, String paramString2, ContentValues paramContentValues) {
        return db.insert(paramString1, null, paramContentValues);
    }

    private void onCreate(String paramString) {
        DataBaseFactory.init(mContext, paramString);
        open(mContext, paramString);
        if (paramString.equalsIgnoreCase("nongda.db")) {
            int i = Preferences.getDbVersion();
            if (i < 21)
                onUpgrade(i, 21);
            Preferences.setDbVersion(21);
            return;
        }
        Preferences.getDbDFVersion();
        Preferences.setDbDFVersion(21);
    }

    private void onUpgrade(int paramInt1, int paramInt2) {
        switch (paramInt1) {
            default:
                return;
            case 1:
                if (!ColumnExists("tblTitle", "Pid"))
                    db.execSQL(" ALTER TABLE tblTitle ADD COLUMN Pid VARCHAR(4) null;");
                if (!ColumnExists("tblTitle", "IconPath"))
                    db.execSQL(" ALTER TABLE tblTitle ADD COLUMN IconPath TEXT NULL;");
            case 2:
            case 3:
                if (!TableExists("tblDepater")) {
                    db.execSQL(
                            " CREATE TABLE tblDepater(Depater_Id  VARCHAR(4) not null,Depater_Name VARCHAR(40) null,Depater_Level VARCHAR(4) not null);");
                    db.execSQL(
                            " CREATE TABLE tblOffice(Office_Id  VARCHAR(4) not null,Office_Name VARCHAR(40) null,Tell_1 VARCHAR(20)  null,Tell_2    VARCHAR(20)  null,Depater_Id VARCHAR(4)  not null);");
                }
            case 4:
                if (!ColumnExists("tblDepater", "Depater_pinyin")) {
                    db.execSQL(" ALTER TABLE tblDepater ADD COLUMN Depater_pinyin VARCHAR(80) NULL;");
                    db.execSQL(" ALTER TABLE tblDepater ADD COLUMN Depater_minPY VARCHAR(40) NULL;");
                }
                if (!TableExists("tblTeacher"))
                    db.execSQL(
                            " CREATE TABLE tblTeacher(Teacher_Id VARCHAR(4) NOT NULL,Teacher_Name VARCHAR(20) NULL,Tell_1 VARCHAR(20) NULL,Tell_2 VARCHAR(20) NULL,Teacher_pinyin VARCHAR(40) NULL,Teacher_minPY VARCHAR(20) NULL);");
            case 5:
                if (!ColumnExists("tblTeacher", "Tell_3"))
                    db.execSQL(" ALTER TABLE tblTeacher ADD COLUMN Tell_3 VARCHAR(20) NULL;");
                if (!ColumnExists("tblTeacher", "Tell_4"))
                    db.execSQL(" ALTER TABLE tblTeacher ADD COLUMN Tell_4 VARCHAR(20) NULL;");
                if (!ColumnExists("tblTeacher", "Tell_5")) {
                    db.execSQL(" ALTER TABLE tblTeacher ADD COLUMN Tell_5 VARCHAR(20) NULL;");
                    db.execSQL(" delete from tblTeacher ;");
                }
            case 6:
                if (!ColumnExists("tblOffice", "Office_pinyin")) {
                    db.execSQL(" ALTER TABLE tblOffice ADD COLUMN Office_pinyin VARCHAR(80) NULL;");
                    db.execSQL(" ALTER TABLE tblOffice ADD COLUMN Office_minPY VARCHAR(40) NULL;");
                }
            case 7:
                if (!ColumnExists("tblTeacher", "Tell_type"))
                    db.execSQL(" ALTER TABLE tblTeacher ADD COLUMN Tell_type VARCHAR(20) NULL;");
            case 8:
                if (!TableExists("tblPublicTell")) {
                    String str = new StringBuilder(String.valueOf(
                            "CREATE TABLE tblPublicTell(Public_Id VARCHAR(4) NOT NULL,Public_Company VARCHAR(80) NULL,Public_Name VARCHAR(20) NULL,Public_Tell1 VARCHAR(20) NULL,"))
                            .append("Public_Tell2 VARCHAR(20) NULL,Public_QQ VARCHAR(20) NULL,Public_Address VARCHAR(100) NULL,Public_Postcode VARCHAR(80) NULL,")
                            .toString()
                            + "Public_HelperType VARCHAR(80) NULL,Public_Log VARCHAR(100) NULL,Public_PxId VARCHAR(4) NULL);";
                    db.execSQL(str);
                }
            case 9:
                if (!ColumnExists("tblPublicTell", "Public_Type"))
                    db.execSQL(" ALTER TABLE tblPublicTell ADD COLUMN Public_Type VARCHAR(4) NULL");
            case 10:
                if (!TableExists("tblTermOfDate"))
                    db.execSQL(
                            "CREATE TABLE tblTermOfDate (Years VARCHAR(4) NULL,Term VARCHAR(10) NULL,B_date VARCHAR(8) NULL,E_date VARCHAR(8) NULL);");
            case 11:
                if (!TableExists("tblPubAllTell"))
                    db.execSQL(
                            "CREATE TABLE tblPubAllTell (ID VARCHAR(4) NULL,Comcode VARCHAR(20) NULL,Vname VARCHAR(20) NULL,Tell_1 VARCHAR(20) NULL,Tell_2 VARCHAR(20) NULL,Condition_name VARCHAR(20) NULL,PinYin VARCHAR(40) NULL,minPY VARCHAR(20) NULL)");
            case 12:
                if (!TableExists("tblLDTell"))
                    db.execSQL(
                            "CREATE TABLE tblLDTell (ID VARCHAR(4) NULL,Vid VARCHAR(20) NULL,Company VARCHAR(100) NULL,vName VARCHAR(20) NULL,Job VARCHAR(50) NULL,TelQ VARCHAR(20) NULL,TelD VARCHAR(20) NULL,PhoneQ VARCHAR(20) NULL,PhoneD VARCHAR(20) NULL,OrderID int NULL,PinYin VARCHAR(40) NULL,minPY VARCHAR(20) NULL)");
            case 13:
                if (!TableExists("tblRead"))
                    db.execSQL(
                            "CREATE TABLE tblRead (Vid VARCHAR(20) NULL, Orderid int null, Menu_code VARCHAR(4) NULL,Menu_name VARCHAR(20) NULL,Menu_level int NULL,Pid VARCHAR(4) NULL, IsSub VARCHAR(4) NULL)");
            case 14:
            case 15:
                if (!ColumnExists("tblTitle", "IsRed"))
                    db.execSQL("ALTER TABLE tblTitle ADD COLUMN IsRed VARCHAR(4) NULL;");
                if (!ColumnExists("tblTitle", "RefreshTime"))
                    db.execSQL("ALTER TABLE tblTitle ADD COLUMN RefreshTime VARCHAR(20) NULL;");
            case 16:
            case 17:
                db.execSQL("update tblTitle set TitleName='新生攻略' where TitleName='新生须知'; ");
            case 18:
                if (!TableExists("tblMessage"))
                    db.execSQL(
                            "CREATE TABLE tblMessage (_id INTEGER PRIMARY KEY AUTOINCREMENT ,UserID VARCHAR(20) NULL,Code VARCHAR(20) NULL,MsgType VARCHAR(4) NULL,Name VARCHAR(20) NULL,Times VARCHAR(20) NULL,HeadImg VARCHAR(100) NULL, IsComMsg VARCHAR(4),IsNew VARCHAR(4),Message VARCHAR(200));");
            case 19:
                if (!ColumnExists("tblXMPPMsg", "UserCode")) {
                    db.execSQL("ALTER TABLE tblXMPPMsg ADD COLUMN UserCode VARCHAR(20) NULL;");
                    db.execSQL("update tblXMPPMsg set UserCode='' where UserCode is NULL");
                }
                break;
            case 20:
        }
        if (!ColumnExists("tblTitle", "IsLogin")) {
            db.execSQL("ALTER TABLE tblTitle ADD COLUMN IsLogin VARCHAR(4) NULL;");
            db.execSQL("ALTER TABLE tblTitle ADD COLUMN MenuUpDate VARCHAR(20) NULL;");
            db.execSQL("ALTER TABLE tblTitle ADD COLUMN MenuAddDate VARCHAR(20) NULL;");
            db.execSQL("ALTER TABLE tblTitle ADD COLUMN isAppShow VARCHAR(4) NULL;");
        }
        db.execSQL("update tblTitle set IsLogin='1',MenuUpdate='',MenuAddDate='',isAppShow='1';");
    }

    private static void open(Context paramContext, String paramString) {
        if ((db != null) && (db.isOpen()))
            db.close();
        db = SQLiteDatabase.openDatabase(
                new StringBuilder("/com/nongda/jonney/data/com.nongda.jonney.data/").append(paramContext.getPackageName()).append("/databases/").toString()
                        + paramString,
                null, 0);
    }

    public static Cursor queryData(String paramString, String[] paramArrayOfString) {
        return db.rawQuery(paramString, paramArrayOfString);
    }

    public static int updateData(String paramString1, ContentValues paramContentValues, String paramString2,
                                 String[] paramArrayOfString) {
        return db.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
    }
}

/*
 * Location: D:\androidfby\jd-gui-0.3.5.windows\classes_dex2jar.jar Qualified
 * Name: com.hunaupalm.com.nongda.jonney.data.DataBaseHelper JD-Core Version: 0.6.2
 */
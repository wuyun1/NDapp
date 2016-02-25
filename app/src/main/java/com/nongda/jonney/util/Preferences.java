package com.nongda.jonney.util;

import android.app.Application;
import android.content.SharedPreferences;

public class Preferences {
    public static final String PERF_COMPANY_NAME = "user_company_name";
    public static final String PREF_ACCESS_TOKEN = "access_token";
    public static final String PREF_ADDRESS = "user_address";
    public static final String PREF_AREAID = "user_areaid";
    public static final String PREF_BDUserID = "BDUserID";
    public static final String PREF_CARDCODE = "user_cardcode";
    public static final String PREF_CLASSES = "user_classes";
    public static final String PREF_CLASSES_ID = "user_classes_id";
    public static final String PREF_COLLEGE = "user_college";
    public static final String PREF_COLLEGE_ID = "user_colloge_id";
    public static final String PREF_COMPANY_ID = "user_company_id";
    public static final String PREF_DBDF_VERSION = "dbdf_version";
    public static final String PREF_DB_VERSION = "db_version";
    public static final String PREF_DEPARTMENT_ID = "user_department_id";
    public static final String PREF_DEPARTMENT_NAME = "user_department_name";
    public static final String PREF_DOORID = "user_doorid";
    public static final String PREF_DORMID = "user_dormid";
    public static final String PREF_ENV_VALUE = "env";
    public static final String PREF_FIRST_RUN = "run";
    public static final String PREF_FROMSCHOOL = "user_fromshcool";
    public static final String PREF_GRADE = "user_grade";
    public static final String PREF_INIT_TIME = "init_time";
    public static final String PREF_ISLOGIN_FLAG = "islogin_flag";
    public static final String PREF_IS_LD = "user_isld";
    public static final String PREF_LAST_UPDATE_TIME = "last_update_time";
    public static final String PREF_LAST_VERSION_DIALOG = "last_version_dialog";
    public static final String PREF_MAJOR = "user_major";
    public static final String PREF_MAJOR_ID = "user_major_id";
    public static final String PREF_MASK_SHOW = "mask_show";
    public static final String PREF_MENU_SHOW = "menu_show_click";
    public static final String PREF_PHONE1 = "user_phone1";
    public static final String PREF_PHONE2 = "user_phone2";
    public static final String PREF_QQ = "user_qq";
    public static final String PREF_RECOMMEND_CODE = "recommend_code";
    public static final String PREF_REGION_GUO = "user_region_guo";
    public static final String PREF_REGION_GUO_NAME = "user_region_guo_name";
    public static final String PREF_REGION_NAME = "user_region_name";
    public static final String PREF_REGION_SHENG = "user_region_sheng";
    public static final String PREF_REGION_SHENG_NAME = "user_region_sheng_name";
    public static final String PREF_REGION_SHI = "user_region_shi";
    public static final String PREF_REGION_SHI_NAME = "user_region_shi_name";
    public static final String PREF_REGION_XIAN = "user_region_xian";
    public static final String PREF_REGION_XIAN_NAME = "user_region_xian_name";
    public static final String PREF_SCHOOL_APIKEY = "school_apikey";
    public static final String PREF_STUDORMDETAIL = "stu_user_dormdetail";
    public static final String PREF_STUNAME = "stu_user_familyname";
    public static final String PREF_STUTELL = "stu_user_familytell";
    public static final String PREF_UDID = "device_udid";
    public static final String PREF_USER_DAYOFBIRTH = "user_dayofbirth";
    public static final String PREF_USER_DISPIX = "user_despix";
    public static final String PREF_USER_HEADIMG = "user_headimg";
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_USER_ISLOOKPHONE = "user_lookphone";
    public static final String PREF_USER_MAJORID = "user_majorid";
    public static final String PREF_USER_NAME = "user_name";
    public static final String PREF_USER_NC = "user_nc";
    public static final String PREF_USER_PASSWORD = "user_password";
    public static final String PREF_USER_REMEMBER = "user_remember";
    public static final String PREF_USER_SEX = "user_sex";
    public static final String PREF_USER_SIGNATURE = "user_signature";
    public static final String PREF_USER_TYPE = "user_type";
    public static final String PREF_USER_ZHANGHAO = "user_zhanghao";
    public static final String PREF_WEIXIN = "user_weixin";
    public static final String PREF_ZZMM = "user_zzmm";
    private static SharedPreferences prefs;

    public static String getAccessToken() {
        return prefs.getString("access_token", "");
    }

    public static String getAreaID() {
        return prefs.getString("user_areaid", "");
    }

    public static String getBDuserid() {
        return prefs.getString("BDUserID", "");
    }

    public static String getCardCode() {
        return prefs.getString("user_cardcode", "");
    }

    public static String getClasses() {
        return prefs.getString("user_classes", "");
    }

    public static String getClasses_Id() {
        return prefs.getString("user_classes_id", "");
    }

    public static String getCollege() {
        return prefs.getString("user_college", "");
    }

    public static String getCollege_Id() {
        return prefs.getString("user_colloge_id", "");
    }

    public static String getCompany_Id() {
        return prefs.getString("user_company_id", "");
    }

    public static String getCompany_name() {
        return prefs.getString("user_company_name", "");
    }

    public static int getDbDFVersion() {
        return prefs.getInt("dbdf_version", 1);
    }

    public static int getDbVersion() {
        return prefs.getInt("db_version", 1);
    }

    public static String getDepartment_Id() {
        return prefs.getString("user_department_id", "");
    }

    public static String getDepartment_Name() {
        return prefs.getString("user_department_name", "");
    }

    public static String getDoorID() {
        return prefs.getString("user_doorid", "");
    }

    public static String getDormID() {
        return prefs.getString("user_dormid", "");
    }

    public static String getEnv() {
        return prefs.getString("env", "PROD");
    }

    public static boolean getFirstRun() {
        return prefs.getBoolean("run", true);
    }

    public static String getFromSchool() {
        return prefs.getString("user_fromshcool", "");
    }

    public static String getGrade() {
        return prefs.getString("user_grade", "");
    }

    public static String getHeadImg() {
        return prefs.getString("user_headimg", "");
    }

    public static String getISLD() {
        return prefs.getString("user_isld", "");
    }

    public static long getInitTime(String paramString) {
        long l1 = 0L;
        String[] arrayOfString = prefs.getString("init_time", "").split(",");
        try {
            if ((arrayOfString[0] != null) && (arrayOfString[0].equalsIgnoreCase(paramString))) {
                long l2 = Long.parseLong(arrayOfString[1]);
                l1 = l2;
            }
            return l1;
        } catch (Exception localException) {
        }
        return l1;
    }

    public static boolean getIsLogin() {
        return prefs.getBoolean("islogin_flag", false);
    }

    public static String getIsLookPhone() {
        return prefs.getString("user_lookphone", "");
    }

    public static long getLastUpdateTime(String paramString) {
        long l1 = 0L;
        String[] arrayOfString = prefs.getString("last_update_time", "").split(",");
        try {
            if ((arrayOfString[0] != null) && (arrayOfString[0].equalsIgnoreCase(paramString))) {
                long l2 = Long.parseLong(arrayOfString[1]);
                l1 = l2;
            }
            return l1;
        } catch (Exception localException) {
        }
        return l1;
    }

    public static long getLastVersionDialog() {
        return prefs.getLong("last_version_dialog", 0L);
    }

    public static String getMajor() {
        return prefs.getString("user_major", "");
    }

    public static String getMajor_Id() {
        return prefs.getString("user_major_id", "");
    }

    public static long getMaskPageStatus() {
        return prefs.getLong("mask_show", 0L);
    }

    public static Long getMenuShowCloseTime() {
        return Long.valueOf(prefs.getLong("menu_show_click", 0L));
    }

    public static String getPassword() {
        return prefs.getString("user_password", "");
    }

    public static String getPhone1() {
        return prefs.getString("user_phone1", "");
    }

    public static String getPhone2() {
        return prefs.getString("user_phone2", "");
    }

    public static String getQQ() {
        return prefs.getString("user_qq", "");
    }

    public static String getRecommendCode() {
        return prefs.getString("recommend_code", "0");
    }

    public static String getRegionName() {
        return prefs.getString("user_region_name", "");
    }

    public static String getRegion_Guo() {
        return prefs.getString("user_region_guo", "");
    }

    public static String getRegion_Guo_Name() {
        return prefs.getString("user_region_guo_name", "");
    }

    public static String getRegion_Sheng() {
        return prefs.getString("user_region_sheng", "");
    }

    public static String getRegion_Sheng_Name() {
        return prefs.getString("user_region_sheng_name", "");
    }

    public static String getRegion_Shi() {
        return prefs.getString("user_region_shi", "");
    }

    public static String getRegion_Shi_Name() {
        return prefs.getString("user_region_shi_name", "");
    }

    public static String getRegion_Xian() {
        return prefs.getString("user_region_xian", "");
    }

    public static String getRegion_Xian_Name() {
        return prefs.getString("user_region_xian_name", "");
    }

    public static String getSchApiKey() {
        return prefs.getString("school_apikey", "");
    }

    public static boolean getSetIsFrist(String paramString) {
        String str = paramString + "SetIsFrist";
        return prefs.getBoolean(str, true);
    }

    public static String getSignature() {
        return prefs.getString("user_signature", "");
    }

    public static String getStu_DormDetail() {
        return prefs.getString("stu_user_dormdetail", "");
    }

    public static String getStu_FamilyName() {
        return prefs.getString("stu_user_familyname", "");
    }

    public static String getStu_FamilyTell() {
        return prefs.getString("stu_user_familytell", "");
    }

    public static String getUdid() {
        return prefs.getString("device_udid", "");
    }

    public static String getUserBirthDay() {
        return prefs.getString("user_dayofbirth", "");
    }

    public static String getUserDispix() {
        return prefs.getString("user_despix", "");
    }

    public static String getUserId() {
        return prefs.getString("user_id", "");
    }

    public static String getUserMajorId() {
        return prefs.getString("user_majorid", "");
    }

    public static String getUserName() {
        return prefs.getString("user_name", "");
    }

    public static String getUserNc() {
        return prefs.getString("user_nc", "");
    }

    public static String getUserSex() {
        return prefs.getString("user_sex", "");
    }

    public static String getUserType() {
        return prefs.getString("user_type", "");
    }

    public static String getUserZhangHao() {
        return prefs.getString("user_zhanghao", "");
    }

    public static String getUser_Address() {
        return prefs.getString("user_address", "");
    }

    public static String getUser_Remember() {
        return prefs.getString("user_remember", "");
    }

    public static String getWeixin() {
        return prefs.getString("user_weixin", "");
    }

    public static String getZZMM() {
        return prefs.getString("user_zzmm", "");
    }

    public static void init(Application paramApplication) {
        prefs = paramApplication.getSharedPreferences("unicomcm_pref", 0);
    }

    private static void put(String paramString, Object paramObject) {
        SharedPreferences.Editor localEditor = prefs.edit();
        if (paramObject.getClass() == Boolean.class)
            localEditor.putBoolean(paramString, ((Boolean) paramObject).booleanValue());
        if (paramObject.getClass() == String.class)
            localEditor.putString(paramString, (String) paramObject);
        if (paramObject.getClass() == Integer.class)
            localEditor.putInt(paramString, ((Integer) paramObject).intValue());
        if (paramObject.getClass() == Float.class)
            localEditor.putFloat(paramString, ((Float) paramObject).intValue());
        if (paramObject.getClass() == Long.class)
            localEditor.putLong(paramString, ((Long) paramObject).longValue());
        localEditor.commit();
    }

    public static void setAccessToken(String paramString) {
        put("access_token", paramString);
    }

    public static void setAreaID(String paramString) {
        put("user_areaid", paramString);
    }

    public static void setBDuserid(String paramString) {
        put("BDUserID", paramString);
    }

    public static void setCardCode(String paramString) {
        put("user_cardcode", paramString);
    }

    public static void setClasses(String paramString) {
        put("user_classes", paramString);
    }

    public static void setClasses_Id(String paramString) {
        put("user_classes_id", paramString);
    }

    public static void setCollege(String paramString) {
        put("user_college", paramString);
    }

    public static void setCollege_Id(String paramString) {
        put("user_colloge_id", paramString);
    }

    public static void setCompany_Id(String paramString) {
        put("user_company_id", paramString);
    }

    public static void setCompany_name(String paramString) {
        put("user_company_name", paramString);
    }

    public static void setDbDFVersion(int paramInt) {
        put("dbdf_version", Integer.valueOf(paramInt));
    }

    public static void setDbVersion(int paramInt) {
        put("db_version", Integer.valueOf(paramInt));
    }

    public static void setDepartment_Id(String paramString) {
        put("user_department_id", paramString);
    }

    public static void setDepartment_Name(String paramString) {
        put("user_department_name", paramString);
    }

    public static void setDoorID(String paramString) {
        put("user_doorid", paramString);
    }

    public static void setDormID(String paramString) {
        put("user_dormid", paramString);
    }

    public static void setEnv(String paramString) {
        put("env", paramString);
    }

    public static void setFirstRun(boolean paramBoolean) {
        put("run", Boolean.valueOf(paramBoolean));
    }

    public static void setFromSchool(String paramString) {
        put("user_fromshcool", paramString);
    }

    public static void setGrade(String paramString) {
        put("user_grade", paramString);
    }

    public static void setHeadImg(String paramString) {
        put("user_headimg", paramString);
    }

    public static void setISLD(String paramString) {
        put("user_isld", paramString);
    }

    public static void setInitTime(String paramString, long paramLong) {
        put("init_time", paramString + "," + paramLong);
    }

    public static void setIsLogin(boolean paramBoolean) {
        put("islogin_flag", Boolean.valueOf(paramBoolean));
    }

    public static void setIsLookPhone(String paramString) {
        put("user_lookphone", paramString);
    }

    public static void setLastUpdateTime(String paramString, long paramLong) {
        put("last_update_time", paramString + "," + paramLong);
    }

    public static void setLastVersionDialog(long paramLong) {
        put("last_version_dialog", Long.valueOf(paramLong));
    }

    public static void setMajor(String paramString) {
        put("user_major", paramString);
    }

    public static void setMajor_Id(String paramString) {
        put("user_major_id", paramString);
    }

    public static void setMaskPageStatus(long paramLong) {
        put("mask_show", Long.valueOf(paramLong));
    }

    public static void setMenuShowCloseTime(Long paramLong) {
        put("menu_show_click", paramLong);
    }

    public static void setPassword(String paramString) {
        put("user_password", paramString);
    }

    public static void setPhone1(String paramString) {
        put("user_phone1", paramString);
    }

    public static void setPhone2(String paramString) {
        put("user_phone2", paramString);
    }

    public static void setQQ(String paramString) {
        put("user_qq", paramString);
    }

    public static void setRecommendCode(String paramString) {
        put("recommend_code", paramString);
    }

    public static void setRegionName(String paramString) {
        put("user_region_name", paramString);
    }

    public static void setRegion_Guo(String paramString) {
        put("user_region_guo", paramString);
    }

    public static void setRegion_Guo_Name(String paramString) {
        put("user_region_guo_name", paramString);
    }

    public static void setRegion_Sheng(String paramString) {
        put("user_region_sheng", paramString);
    }

    public static void setRegion_Sheng_Name(String paramString) {
        put("user_region_sheng_name", paramString);
    }

    public static void setRegion_Shi(String paramString) {
        put("user_region_shi", paramString);
    }

    public static void setRegion_Shi_Name(String paramString) {
        put("user_region_shi_name", paramString);
    }

    public static void setRegion_Xian(String paramString) {
        put("user_region_xian", paramString);
    }

    public static void setRegion_Xian_Name(String paramString) {
        put("user_region_xian_name", paramString);
    }

    public static void setSchApiKey(String paramString) {
        put("school_apikey", paramString);
    }

    public static void setSetIsFrist(String paramString, boolean paramBoolean) {
        put(paramString + "SetIsFrist", Boolean.valueOf(paramBoolean));
    }

    public static void setSignature(String paramString) {
        put("user_signature", paramString);
    }

    public static void setStu_DormDetail(String paramString) {
        put("stu_user_dormdetail", paramString);
    }

    public static void setStu_FamilyName(String paramString) {
        put("stu_user_familyname", paramString);
    }

    public static void setStu_FamilyTell(String paramString) {
        put("stu_user_familytell", paramString);
    }

    public static void setUdid(String paramString) {
        put("device_udid", paramString);
    }

    public static void setUserBirthDay(String paramString) {
        put("user_dayofbirth", paramString);
    }

    public static void setUserDispix(String paramString) {
        put("user_despix", paramString);
    }

    public static void setUserId(String paramString) {
        put("user_id", paramString);
    }

    public static void setUserMajorId(String paramString) {
        put("user_majorid", paramString);
    }

    public static void setUserName(String paramString) {
        put("user_name", paramString);
    }

    public static void setUserNc(String paramString) {
        put("user_nc", paramString);
    }

    public static void setUserSex(String paramString) {
        put("user_sex", paramString);
    }

    public static void setUserType(String paramString) {
        put("user_type", paramString);
    }

    public static void setUserZhangHao(String paramString) {
        put("user_zhanghao", paramString);
    }

    public static void setUser_Address(String paramString) {
        put("user_address", paramString);
    }

    public static void setUser_Remember(String paramString) {
        put("user_remember", paramString);
    }

    public static void setWeixin(String paramString) {
        put("user_weixin", paramString);
    }

    public static void setZZMM(String paramString) {
        put("user_zzmm", paramString);
    }
}

/* Location:           D:\androidfby\jd-gui-0.3.5.windows\classes_dex2jar.jar
 * Qualified Name:     com.hunaupalm.com.nongda.jonney.util.Preferences
 * JD-Core Version:    0.6.2
 */
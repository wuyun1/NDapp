package com.nongda.jonney.global;

import java.io.File;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Application;

import com.nongda.jonney.data.DataBaseHelper;
import com.nongda.jonney.util.Preferences;
import com.nongda.jonney.vo.User;

public class GlobalApp extends Application {
    // private static DynamicInvoker invoker = null;

    final static String WSDL_URL = "src/wsdl/NDAppWebService.asmx";
    private DataBaseHelper dbHelp;

    private static GlobalApp instance = null;
    private static Map<String,Object> data  = new HashMap<String,Object>() ;

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
        Preferences.init(this);
//        this.dbHelp = new DataBaseHelper(getApplicationContext(),false);


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

    Object attr(String str){
        return  data.get(str);
    }

    synchronized void attr(String str,Object obj){
        data.put(str,obj);
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

    private  User user = null;
    public User getUser()
    {

        if (this.user == null)
        {
            this.user = new User();
            this.user.setId(Preferences.getUserId());
            this.user.setAccess_Token(Preferences.getAccessToken());
            this.user.setUserName(Preferences.getUserName());
            this.user.setDayOfBirth(Preferences.getUserBirthDay());
            this.user.setDispix(Preferences.getUserDispix());
            this.user.setMajorId(Preferences.getUserMajorId());
            this.user.setSex(Preferences.getUserSex());
            this.user.setusertype(Preferences.getUserType());
            this.user.setUserNc(Preferences.getUserNc());
            this.user.setisLD(Preferences.getISLD());
            this.user.setzzmm(Preferences.getZZMM());
            this.user.setPhone1(Preferences.getPhone1());
            this.user.setPhone2(Preferences.getPhone2());
            this.user.setQQ(Preferences.getQQ());
            this.user.setWeixin(Preferences.getWeixin());
            this.user.setCompany_name(Preferences.getCompany_name());
            this.user.setCollege(Preferences.getCollege());
            this.user.setMajor(Preferences.getMajor());
            this.user.setClasses(Preferences.getClasses());
            this.user.setCollege_Id(Preferences.getCollege_Id());
            this.user.setMajor_Id(Preferences.getMajor_Id());
            this.user.setClasses_Id(Preferences.getClasses_Id());
            this.user.setZhangHao(Preferences.getUserZhangHao());
            this.user.setPassword(Preferences.getPassword());
            this.user.setGrade(Preferences.getGrade());
            this.user.setAreaID(Preferences.getAreaID());
            this.user.setDormID(Preferences.getDormID());
            this.user.setDoorID(Preferences.getDoorID());
            this.user.setAddress(Preferences.getUser_Address());
            this.user.setRegion_Guo(Preferences.getRegion_Guo());
            this.user.setRegion_Sheng(Preferences.getRegion_Sheng());
            this.user.setRegion_Shi(Preferences.getRegion_Shi());
            this.user.setRegion_Xian(Preferences.getRegion_Xian());
            this.user.setRegion_Guo_Name(Preferences.getRegion_Guo_Name());
            this.user.setRegion_Sheng_Name(Preferences.getRegion_Sheng_Name());
            this.user.setRegion_Shi_Name(Preferences.getRegion_Shi_Name());
            this.user.setRegion_Xian_Name(Preferences.getRegion_Xian_Name());
            this.user.setRegionName(Preferences.getRegionName());
            this.user.setFromSchool(Preferences.getFromSchool());
            this.user.setDepartMent_id(Preferences.getDepartment_Id());
            this.user.setDepartMent_name(Preferences.getDepartment_Name());
            this.user.setCompany_Id(Preferences.getCompany_Id());
            this.user.setCardCode(Preferences.getCardCode());
            this.user.setStu_Dormdetail(Preferences.getStu_DormDetail());
            this.user.setStu_FamilyName(Preferences.getStu_FamilyName());
            this.user.setStu_FamilyTell(Preferences.getStu_FamilyTell());
            this.user.setHeadImg(Preferences.getHeadImg());
            this.user.setSignature(Preferences.getSignature());
            this.user.setIsLookPhone(Preferences.getIsLookPhone());
        }
        return this.user;
    }

    public void setUser(User paramUser)
    {
        this.user = paramUser;
        if (paramUser != null)
        {
            Preferences.setUserId(paramUser.getId());
            Preferences.setAccessToken(paramUser.getAccess_Token());
            Preferences.setUserName(paramUser.getUserName());
            Preferences.setUserBirthDay(paramUser.getDayOfBirth());
            Preferences.setUserDispix(paramUser.getDispix());
            Preferences.setUserMajorId(paramUser.getMajorId());
            Preferences.setUserSex(paramUser.getSex());
            Preferences.setUserType(paramUser.getusertype());
            Preferences.setUserNc(paramUser.getUserNc());
            Preferences.setISLD(paramUser.getisLD());
            Preferences.setZZMM(paramUser.getzzmm());
            Preferences.setPhone1(paramUser.getPhone1());
            Preferences.setPhone2(paramUser.getPhone2());
            Preferences.setQQ(paramUser.getQQ());
            Preferences.setWeixin(paramUser.getWeixin());
            Preferences.setCompany_name(paramUser.getCompany_name());
            Preferences.setCollege(paramUser.getCollege());
            Preferences.setMajor(paramUser.getMajor());
            Preferences.setClasses(paramUser.getClasses());
            Preferences.setCollege_Id(paramUser.getCollege_Id());
            Preferences.setMajor_Id(paramUser.getMajor_Id());
            Preferences.setClasses_Id(paramUser.getClasses_Id());
            if (!Preferences.getUser_Remember().equalsIgnoreCase("true"))
                Preferences.setUserZhangHao(paramUser.getZhangHao());
            Preferences.setPassword(paramUser.getPassword());
            Preferences.setGrade(paramUser.getGrade());
            Preferences.setAreaID(paramUser.getAreaID());
            Preferences.setDormID(paramUser.getDormID());
            Preferences.setDoorID(paramUser.getDoorID());
            Preferences.setUser_Address(paramUser.getAddress());
            Preferences.setRegion_Guo(paramUser.getRegion_Guo());
            Preferences.setRegion_Sheng(paramUser.getRegion_Sheng());
            Preferences.setRegion_Shi(paramUser.getRegion_Shi());
            Preferences.setRegion_Xian(paramUser.getRegion_Xian());
            Preferences.setRegion_Guo_Name(paramUser.getRegion_Guo_Name());
            Preferences.setRegion_Sheng_Name(paramUser.getRegion_Sheng_Name());
            Preferences.setRegion_Shi_Name(paramUser.getRegion_Shi_Name());
            Preferences.setRegion_Xian_Name(paramUser.getRegion_Xian_Name());
            Preferences.setRegionName(paramUser.getRegionName());
            Preferences.setFromSchool(paramUser.getFromSchool());
            Preferences.setDepartment_Id(paramUser.getDepartMent_id());
            Preferences.setDepartment_Name(paramUser.getDepartMent_name());
            Preferences.setCompany_Id(paramUser.getCompany_Id());
            Preferences.setCardCode(paramUser.getCardCode());
            Preferences.setStu_DormDetail(paramUser.getStu_Dormdetail());
            Preferences.setStu_FamilyName(paramUser.getStu_FamilyName());
            Preferences.setStu_FamilyTell(paramUser.getStu_FamilyTell());
            Preferences.setHeadImg(paramUser.getHeadImg());
            Preferences.setSignature(paramUser.getSignature());
            Preferences.setIsLookPhone(paramUser.getIsLookPhone());
        }
    }



    public void loginOut()
    {
        Preferences.setUserId("");
        Preferences.setAccessToken("");
        Preferences.setUserName("");
        Preferences.setUserBirthDay("");
        Preferences.setUserDispix("");
        Preferences.setUserMajorId("");
        Preferences.setUserSex("");
        Preferences.setUserType("");
        Preferences.setUserNc("");
        Preferences.setISLD("");
        Preferences.setZZMM("");
        Preferences.setPhone1("");
        Preferences.setPhone2("");
        Preferences.setQQ("");
        Preferences.setWeixin("");
        Preferences.setCompany_name("");
        Preferences.setCollege("");
        Preferences.setMajor("");
        Preferences.setClasses("");
        Preferences.setCollege_Id("");
        Preferences.setMajor_Id("");
        Preferences.setClasses_Id("");
        Preferences.setPassword("");
        Preferences.setAreaID("");
        Preferences.setDoorID("");
        Preferences.setDormID("");
        Preferences.setUser_Address("");
        Preferences.setRegion_Guo("");
        Preferences.setRegion_Sheng("");
        Preferences.setRegion_Shi("");
        Preferences.setRegion_Xian("");
        Preferences.setRegion_Guo_Name("");
        Preferences.setRegion_Sheng_Name("");
        Preferences.setRegion_Shi_Name("");
        Preferences.setRegion_Xian_Name("");
        if (!Preferences.getUser_Remember().equalsIgnoreCase("true"))
            Preferences.setUserZhangHao("");
        Preferences.setDepartment_Id("");
        Preferences.setDepartment_Name("");
        Preferences.setCompany_Id("");
        Preferences.setCardCode("");
        Preferences.setStu_DormDetail("");
        Preferences.setStu_FamilyName("");
        Preferences.setStu_FamilyTell("");
        Preferences.setHeadImg("");
        Preferences.setSignature("");
        Preferences.setIsLookPhone("");
    }


}

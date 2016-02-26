package com.nongda.jonney.server;

import com.nongda.jonney.util.NDWBS;
import com.nongda.jonney.util.Preferences;
import com.nongda.jonney.vo.User;

import org.json.JSONException;
import org.json.JSONObject;

public class UserService {
    public static String login_status = "";
    public static String login_sRequest ="";

    public static User login(String xuehao, String passowrd) {

        String ret = NDWBS.getUserMsg(xuehao, passowrd);
        User user= UserService.parseJsonLoading(ret);
        user.setPassword(passowrd);
        return user;
    }

    public  static boolean isLogined(){
        String userId = Preferences.getUserId();
        return userId!=null&&!userId.equals("");
    }

    public static User parseJsonLoading(String paramString)
    {
        User localUser = new User();
        try
        {
            JSONObject localJSONObject1 = new JSONObject(paramString);
            login_status = localJSONObject1.getString("status");
            login_sRequest = localJSONObject1.getString("Msg");
            String str = localJSONObject1.getString("Userinfo");
            if ((login_status.equals("1")) && (!str.equals("")))
            {
                JSONObject localJSONObject2 = new JSONObject(str);
                localUser.setZhangHao(localJSONObject2.getString("SchNo").replace("null", ""));
                localUser.setPassword("******");
                localUser.setId(localJSONObject2.getString("CardCode").replace("null", ""));
                localUser.setAccess_Token(localJSONObject2.getString("CardCode").replace("null", ""));
                localUser.setUserName(localJSONObject2.getString("Name").replace("null", ""));
                localUser.setSex(localJSONObject2.getString("Sex").replace("null", ""));
                localUser.setDayOfBirth(localJSONObject2.getString("BirthDay").replace("null", ""));
                localUser.setzzmm(localJSONObject2.getString("Polite").replace("null", ""));
                localUser.setusertype(localJSONObject2.getString("Type").replace("null", ""));
                localUser.setPhone1(localJSONObject2.getString("Phone1").replace("null", ""));
                localUser.setPhone2(localJSONObject2.getString("Phone2").replace("null", ""));
                localUser.setQQ(localJSONObject2.getString("QQ").replace("null", ""));
                localUser.setWeixin(localJSONObject2.getString("WechatNo").replace("null", ""));
                localUser.setUserNc(localJSONObject2.getString("UserNC").replace("null", ""));
                localUser.setisLD(localJSONObject2.getString("isld").replace("null", ""));
                localUser.setCompany_Id(localJSONObject2.getString("company_2_id").replace("null", ""));
                localUser.setCompany_name(localJSONObject2.getString("company_2_name").replace("null", ""));
                localUser.setDispix(localJSONObject2.getString("company_2_name").replace("null", ""));
                localUser.setMajorId(localJSONObject2.getString("company_2_name").replace("null", ""));
                localUser.setCollege(localJSONObject2.getString("CollegeName").replace("null", ""));
                localUser.setMajor(localJSONObject2.getString("MajorName").replace("null", ""));
                localUser.setClasses(localJSONObject2.getString("ClassesName").replace("null", ""));
                localUser.setCollege_Id(localJSONObject2.getString("College").replace("null", ""));
                localUser.setMajor_Id(localJSONObject2.getString("Major").replace("null", ""));
                localUser.setClasses_Id(localJSONObject2.getString("Classes").replace("null", ""));
                localUser.setGrade(localJSONObject2.getString("Grade").replace("null", ""));
                localUser.setAreaID(localJSONObject2.getString("AreaID").replace("null", ""));
                localUser.setDormID(localJSONObject2.getString("DormID").replace("null", ""));
                localUser.setDoorID(localJSONObject2.getString("DoorID").replace("null", ""));
                localUser.setAddress(localJSONObject2.getString("DormName").replace("null", ""));
                localUser.setRegion_Guo(localJSONObject2.getString("Region1").replace("null", ""));
                localUser.setRegion_Sheng(localJSONObject2.getString("Region2").replace("null", ""));
                localUser.setRegion_Shi(localJSONObject2.getString("Region3").replace("null", ""));
                localUser.setRegion_Xian(localJSONObject2.getString("Region4").replace("null", ""));
                localUser.setRegion_Guo_Name(localJSONObject2.getString("Region1Name").replace("null", ""));
                localUser.setRegion_Sheng_Name(localJSONObject2.getString("Region2Name").replace("null", ""));
                localUser.setRegion_Shi_Name(localJSONObject2.getString("Region3Name").replace("null", ""));
                localUser.setRegion_Xian_Name(localJSONObject2.getString("Region4Name").replace("null", ""));
                localUser.setRegionName(localJSONObject2.getString("RegionName").replace("null", ""));
                localUser.setFromSchool(localJSONObject2.getString("FromSchool").replace("null", ""));
                localUser.setDepartMent_id(localJSONObject2.getString("DepartMent_id").replace("null", ""));
                localUser.setDepartMent_name(localJSONObject2.getString("DepartMent").replace("null", ""));
                localUser.setCardCode(localJSONObject2.getString("SchNo").replace("null", ""));
                localUser.setStu_Dormdetail(localJSONObject2.getString("DormDetail").replaceAll("null", ""));
                localUser.setStu_FamilyName(localJSONObject2.getString("FamilyName").replaceAll("null", ""));
                localUser.setStu_FamilyTell(localJSONObject2.getString("FamilyTell").replaceAll("null", ""));
                localUser.setHeadImg(localJSONObject2.getString("HeadImg").replace("null", ""));
                localUser.setSignature(localJSONObject2.getString("perSign").replace("null", ""));
                localUser.setIsLookPhone(localJSONObject2.getString("TelSecrecy").replace("null", ""));
                return localUser;
            }
            login_status = "0";
            login_sRequest = "登录失败";

            return localUser;
        }
        catch (JSONException localJSONException)
        {
            localJSONException.printStackTrace();
        }
        return localUser;
    }
}

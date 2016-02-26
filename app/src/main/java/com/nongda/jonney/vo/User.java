package com.nongda.jonney.vo;

public class User
{
  private String Access_Token;
  private String Address;
  private String AreaID;
  private String CardCode;
  private String Classes;
  private String Classes_Id;
  private String College;
  private String College_Id;
  private String Company_Id;
  private String Company_name;
  private String DayOfBirth;
  private String DepartMent_id;
  private String DepartMent_name;
  private String DoorID;
  private String DormID;
  private String FromSchool;
  private String Grade;
  private String HeadImg;
  private String IsLookPhone;
  private String Major;
  private String Major_Id;
  private String Password;
  private String Phone1;
  private String Phone2;
  private String QQ;
  private String RegionName;
  private String Region_Guo;
  private String Region_Guo_Name;
  private String Region_Sheng;
  private String Region_Sheng_Name;
  private String Region_Shi;
  private String Region_Shi_Name;
  private String Region_Xian;
  private String Region_Xian_Name;
  private String Sex;
  private String Signature;
  private String Stu_Dormdetail;
  private String Stu_FamilyName;
  private String Stu_FamilyTell;
  private String Weixin;
  private String dispix;
  private int iUsertype;
  private String id;
  private String isLD;
  private String majorId;
  private String userName;
  private String usernc;
  private String usertype;
  private String zhanghao;
  private String zzmm;

  public String getAccess_Token()
  {
    return this.Access_Token;
  }

  public String getAddress()
  {
    return this.Address;
  }

  public String getAreaID()
  {
    return this.AreaID;
  }

  public String getCardCode()
  {
    return this.CardCode;
  }

  public String getClasses()
  {
    return this.Classes;
  }

  public String getClasses_Id()
  {
    return this.Classes_Id;
  }

  public String getCollege()
  {
    return this.College;
  }

  public String getCollege_Id()
  {
    return this.College_Id;
  }

  public String getCompany_Id()
  {
    return this.Company_Id;
  }

  public String getCompany_name()
  {
    return this.Company_name;
  }

  public String getDayOfBirth()
  {
    return this.DayOfBirth;
  }

  public String getDepartMent_id()
  {
    return this.DepartMent_id;
  }

  public String getDepartMent_name()
  {
    return this.DepartMent_name;
  }

  public String getDispix()
  {
    return this.dispix;
  }

  public String getDoorID()
  {
    return this.DoorID;
  }

  public String getDormID()
  {
    return this.DormID;
  }

  public String getFromSchool()
  {
    return this.FromSchool;
  }

  public String getGrade()
  {
    return this.Grade;
  }

  public String getHeadImg()
  {
    return this.HeadImg;
  }

  public String getId()
  {
    return this.id;
  }

  public String getIsLookPhone()
  {
    return this.IsLookPhone;
  }

  public String getMajor()
  {
    return this.Major;
  }

  public String getMajorId()
  {
    return this.majorId;
  }

  public String getMajor_Id()
  {
    return this.Major_Id;
  }

  public String getPassword()
  {
    return this.Password;
  }

  public String getPhone1()
  {
    return this.Phone1;
  }

  public String getPhone2()
  {
    return this.Phone2;
  }

  public String getQQ()
  {
    return this.QQ;
  }

  public String getRegionName()
  {
    return this.RegionName;
  }

  public String getRegion_Guo()
  {
    return this.Region_Guo;
  }

  public String getRegion_Guo_Name()
  {
    return this.Region_Guo_Name;
  }

  public String getRegion_Sheng()
  {
    return this.Region_Sheng;
  }

  public String getRegion_Sheng_Name()
  {
    return this.Region_Sheng_Name;
  }

  public String getRegion_Shi()
  {
    return this.Region_Shi;
  }

  public String getRegion_Shi_Name()
  {
    return this.Region_Shi_Name;
  }

  public String getRegion_Xian()
  {
    return this.Region_Xian;
  }

  public String getRegion_Xian_Name()
  {
    return this.Region_Xian_Name;
  }

  public String getSex()
  {
    return this.Sex;
  }

  public String getSignature()
  {
    return this.Signature;
  }

  public String getStu_Dormdetail()
  {
    return this.Stu_Dormdetail;
  }

  public String getStu_FamilyName()
  {
    return this.Stu_FamilyName;
  }

  public String getStu_FamilyTell()
  {
    return this.Stu_FamilyTell;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getUserNc()
  {
    return this.usernc;
  }

  public String getWeixin()
  {
    return this.Weixin;
  }

  public String getZhangHao()
  {
    return this.zhanghao;
  }

  public int getiUsertype()
  {
    return this.iUsertype;
  }

  public String getisLD()
  {
    return this.isLD;
  }

  public String getusertype()
  {
    return this.usertype;
  }

  public String getzzmm()
  {
    return this.zzmm;
  }

  public boolean isTeacherType()
  {
    int i = this.iUsertype;
    boolean bool = false;
    if (i == 1)
      bool = true;
    return bool;
  }

  public void setAccess_Token(String paramString)
  {
    this.Access_Token = paramString;
  }

  public void setAddress(String paramString)
  {
    this.Address = paramString;
  }

  public void setAreaID(String paramString)
  {
    this.AreaID = paramString;
  }

  public void setCardCode(String paramString)
  {
    this.CardCode = paramString;
  }

  public void setClasses(String paramString)
  {
    this.Classes = paramString;
  }

  public void setClasses_Id(String paramString)
  {
    this.Classes_Id = paramString;
  }

  public void setCollege(String paramString)
  {
    this.College = paramString;
  }

  public void setCollege_Id(String paramString)
  {
    this.College_Id = paramString;
  }

  public void setCompany_Id(String paramString)
  {
    this.Company_Id = paramString;
  }

  public void setCompany_name(String paramString)
  {
    this.Company_name = paramString;
  }

  public void setDayOfBirth(String paramString)
  {
    this.DayOfBirth = paramString;
  }

  public void setDepartMent_id(String paramString)
  {
    this.DepartMent_id = paramString;
  }

  public void setDepartMent_name(String paramString)
  {
    this.DepartMent_name = paramString;
  }

  public void setDispix(String paramString)
  {
    this.dispix = paramString;
  }

  public void setDoorID(String paramString)
  {
    this.DoorID = paramString;
  }

  public void setDormID(String paramString)
  {
    this.DormID = paramString;
  }

  public void setFromSchool(String paramString)
  {
    this.FromSchool = paramString;
  }

  public void setGrade(String paramString)
  {
    this.Grade = paramString;
  }

  public void setHeadImg(String paramString)
  {
    this.HeadImg = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setIsLookPhone(String paramString)
  {
    this.IsLookPhone = paramString;
  }

  public void setMajor(String paramString)
  {
    this.Major = paramString;
  }

  public void setMajorId(String paramString)
  {
    this.majorId = paramString;
  }

  public void setMajor_Id(String paramString)
  {
    this.Major_Id = paramString;
  }

  public void setPassword(String paramString)
  {
    this.Password = paramString;
  }

  public void setPhone1(String paramString)
  {
    this.Phone1 = paramString;
  }

  public void setPhone2(String paramString)
  {
    this.Phone2 = paramString;
  }

  public void setQQ(String paramString)
  {
    this.QQ = paramString;
  }

  public void setRegionName(String paramString)
  {
    this.RegionName = paramString;
  }

  public void setRegion_Guo(String paramString)
  {
    this.Region_Guo = paramString;
  }

  public void setRegion_Guo_Name(String paramString)
  {
    this.Region_Guo_Name = paramString;
  }

  public void setRegion_Sheng(String paramString)
  {
    this.Region_Sheng = paramString;
  }

  public void setRegion_Sheng_Name(String paramString)
  {
    this.Region_Sheng_Name = paramString;
  }

  public void setRegion_Shi(String paramString)
  {
    this.Region_Shi = paramString;
  }

  public void setRegion_Shi_Name(String paramString)
  {
    this.Region_Shi_Name = paramString;
  }

  public void setRegion_Xian(String paramString)
  {
    this.Region_Xian = paramString;
  }

  public void setRegion_Xian_Name(String paramString)
  {
    this.Region_Xian_Name = paramString;
  }

  public void setSex(String paramString)
  {
    this.Sex = paramString;
  }

  public void setSignature(String paramString)
  {
    this.Signature = paramString;
  }

  public void setStu_Dormdetail(String paramString)
  {
    this.Stu_Dormdetail = paramString;
  }

  public void setStu_FamilyName(String paramString)
  {
    this.Stu_FamilyName = paramString;
  }

  public void setStu_FamilyTell(String paramString)
  {
    this.Stu_FamilyTell = paramString;
  }

  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }

  public void setUserNc(String paramString)
  {
    this.usernc = paramString;
  }

  public void setWeixin(String paramString)
  {
    this.Weixin = paramString;
  }

  public void setZhangHao(String paramString)
  {
    this.zhanghao = paramString;
  }

  public void setiUsertype(int paramInt)
  {
    this.iUsertype = paramInt;
  }

  public void setisLD(String paramString)
  {
    this.isLD = paramString;
  }

  public void setusertype(String paramString)
  {
    int i = 5;
    this.usertype = paramString;
    if(paramString.equals("老师")){
      i = 2;
    }else if (paramString.equals("学生"))
      i = 2;
    else if (paramString.equals("校友"))
      i = 3;
    else if (paramString.equals("家长"))
      i = 4;
    setiUsertype(i);

  }

  @Override
  public String toString() {
    return "User{" +
            "Access_Token='" + Access_Token + '\'' +
            ", Address='" + Address + '\'' +
            ", AreaID='" + AreaID + '\'' +
            ", CardCode='" + CardCode + '\'' +
            ", Classes='" + Classes + '\'' +
            ", Classes_Id='" + Classes_Id + '\'' +
            ", College='" + College + '\'' +
            ", College_Id='" + College_Id + '\'' +
            ", Company_Id='" + Company_Id + '\'' +
            ", Company_name='" + Company_name + '\'' +
            ", DayOfBirth='" + DayOfBirth + '\'' +
            ", DepartMent_id='" + DepartMent_id + '\'' +
            ", DepartMent_name='" + DepartMent_name + '\'' +
            ", DoorID='" + DoorID + '\'' +
            ", DormID='" + DormID + '\'' +
            ", FromSchool='" + FromSchool + '\'' +
            ", Grade='" + Grade + '\'' +
            ", HeadImg='" + HeadImg + '\'' +
            ", IsLookPhone='" + IsLookPhone + '\'' +
            ", Major='" + Major + '\'' +
            ", Major_Id='" + Major_Id + '\'' +
            ", Password='" + Password + '\'' +
            ", Phone1='" + Phone1 + '\'' +
            ", Phone2='" + Phone2 + '\'' +
            ", QQ='" + QQ + '\'' +
            ", RegionName='" + RegionName + '\'' +
            ", Region_Guo='" + Region_Guo + '\'' +
            ", Region_Guo_Name='" + Region_Guo_Name + '\'' +
            ", Region_Sheng='" + Region_Sheng + '\'' +
            ", Region_Sheng_Name='" + Region_Sheng_Name + '\'' +
            ", Region_Shi='" + Region_Shi + '\'' +
            ", Region_Shi_Name='" + Region_Shi_Name + '\'' +
            ", Region_Xian='" + Region_Xian + '\'' +
            ", Region_Xian_Name='" + Region_Xian_Name + '\'' +
            ", Sex='" + Sex + '\'' +
            ", Signature='" + Signature + '\'' +
            ", Stu_Dormdetail='" + Stu_Dormdetail + '\'' +
            ", Stu_FamilyName='" + Stu_FamilyName + '\'' +
            ", Stu_FamilyTell='" + Stu_FamilyTell + '\'' +
            ", Weixin='" + Weixin + '\'' +
            ", dispix='" + dispix + '\'' +
            ", iUsertype=" + iUsertype +
            ", id='" + id + '\'' +
            ", isLD='" + isLD + '\'' +
            ", majorId='" + majorId + '\'' +
            ", userName='" + userName + '\'' +
            ", usernc='" + usernc + '\'' +
            ", usertype='" + usertype + '\'' +
            ", zhanghao='" + zhanghao + '\'' +
            ", zzmm='" + zzmm + '\'' +
            '}';
  }

  public void setzzmm(String paramString)
  {
    this.zzmm = paramString;
  }
}

/* Location:           D:\androidfby\classes_dex2jar.jar
 * Qualified Name:     com.hunaupalm.vo.User
 * JD-Core Version:    0.6.2
 */
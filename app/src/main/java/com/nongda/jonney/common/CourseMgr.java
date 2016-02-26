package com.nongda.jonney.common;

import com.nongda.jonney.util.StoreFileObject;
import com.nongda.jonney.vo.CourseItemBase;
import com.nongda.jonney.vo.CourseItemStudent;
import com.nongda.jonney.vo.CourseItemTeacher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonney on 2016/2/25.
 */
public class CourseMgr {

    public String result = "";
    private List<CourseItemBase> courseList_1;
    private List<CourseItemBase> courseList_2;
    private List<CourseItemBase> courseList_3;
    private List<CourseItemBase> courseList_4;
    private List<CourseItemBase> courseList_5;
    private List<CourseItemBase> courseList_6;
    private List<CourseItemBase> courseList_7;

    private CourseItemStudent parseJsonClass(JSONObject paramJSONObject)
            throws JSONException
    {
        CourseItemStudent localCourseItemStudent = new CourseItemStudent();
        localCourseItemStudent.setPlace(paramJSONObject.getString("JiaoS"));
        if (paramJSONObject.getString("JSName_2").length() > 0)
            localCourseItemStudent.setTeacher(paramJSONObject.getString("JSName") + "," + paramJSONObject.getString("JSName_2"));
        else
            localCourseItemStudent.setTeacher(paramJSONObject.getString("JSName"));

        localCourseItemStudent.setName(paramJSONObject.getString("CourseName"));
        localCourseItemStudent.setTimeOfDay(paramJSONObject.getString("JieC"));
        localCourseItemStudent.setTimeOfWeek(paramJSONObject.getString("section"));
        localCourseItemStudent.setTime(paramJSONObject.getString("weeks"));
        return localCourseItemStudent;

    }

    private CourseItemStudent parseJsonStudent(JSONObject paramJSONObject)
            throws JSONException
    {
        CourseItemStudent localCourseItemStudent = new CourseItemStudent();
        localCourseItemStudent.setPlace(paramJSONObject.getString("JiaoS"));
        if (paramJSONObject.getString("JSName_2").length() > 0)
            localCourseItemStudent.setTeacher(paramJSONObject.getString("JSName") + "," + paramJSONObject.getString("JSName_2"));
        else
            localCourseItemStudent.setTeacher(paramJSONObject.getString("JSName"));

        localCourseItemStudent.setName(paramJSONObject.getString("CourseName"));
        localCourseItemStudent.setTimeOfDay(paramJSONObject.getString("JieC"));
        localCourseItemStudent.setTimeOfWeek(paramJSONObject.getString("section"));
        localCourseItemStudent.setTime(paramJSONObject.getString("weeks"));
        return localCourseItemStudent;


    }

    private CourseItemTeacher parseJsonTeacher(JSONObject paramJSONObject)
            throws JSONException
    {
        CourseItemTeacher localCourseItemTeacher = new CourseItemTeacher();
        localCourseItemTeacher.setPlace(paramJSONObject.getString("JiaoS"));
        localCourseItemTeacher.setClasses(paramJSONObject.getString("Classes"));
        localCourseItemTeacher.setName(paramJSONObject.getString("CourseName"));
        localCourseItemTeacher.setTimeOfDay(paramJSONObject.getString("JieC"));
        localCourseItemTeacher.setTimeOfWeek(paramJSONObject.getString("section"));
        localCourseItemTeacher.setTime(paramJSONObject.getString("weeks"));
        return localCourseItemTeacher;
    }

    public List<CourseItemBase> getCourse(int paramInt)
    {
        switch (paramInt)
        {
            default:
                return null;
            case 1:
                return this.courseList_1;
            case 2:
                return this.courseList_2;
            case 3:
                return this.courseList_3;
            case 4:
                return this.courseList_4;
            case 5:
                return this.courseList_5;
            case 6:
                return this.courseList_6;
            case 7:
        }
        return this.courseList_7;
    }

    public void init()
    {
        this.courseList_1 = new ArrayList();
        this.courseList_2 = new ArrayList();
        this.courseList_3 = new ArrayList();
        this.courseList_4 = new ArrayList();
        this.courseList_5 = new ArrayList();
        this.courseList_6 = new ArrayList();
        this.courseList_7 = new ArrayList();
//        getListDateFrmSvr(paramActivity, paramOnRequestJsonResult, paramBoolean, paramString1, paramString2, paramString3, paramString4);
    }

    public String parseJsonMulti(String strJson,boolean teacherOrStudent) {
        String retstr = "获取课程失败,程序猿正在努力修复...";

        JSONArray localJSONArray = null;
        try {
            localJSONArray = new JSONObject(strJson).getJSONArray("Response");
            if (localJSONArray.length() > 0){
                retstr =  "您本周没有课！";
            }else{
                for(int i = 0,n =localJSONArray.length() ;i<n;i++){
                    JSONObject localJSONObject = (JSONObject)localJSONArray.opt(i);
                    CourseItemBase courseItem = teacherOrStudent?parseJsonTeacher(localJSONObject):parseJsonStudent(localJSONObject);
                    switch (courseItem.getTimeOfWeek()){
                        case "星期一":
                            courseList_1.add(courseItem);
                            break;
                        case "星期二":
                            courseList_2.add(courseItem);
                            break;
                        case "星期三":
                            courseList_3.add(courseItem);
                            break;
                        case "星期四":
                            courseList_4.add(courseItem);
                            break;
                        case "星期五":
                            courseList_5.add(courseItem);
                            break;
                        case "星期六":
                            courseList_6.add(courseItem);
                            break;
                        case "星期日":
                            courseList_7.add(courseItem);
                            break;
                    }
                }


                retstr ="课表加载完成，请查看";

            }
            retstr= "课表加载完成，请查看";
        } catch (JSONException e) {
            e.printStackTrace();
            return retstr;
        }

        result = retstr;
        return  retstr;

    }
    public static CourseMgr getInstance()
    {
        try
        {
            CourseMgr localCourseMgr = (CourseMgr) StoreFileObject.readObject(CacheMgr.cacheFolder+"course.data");
            return localCourseMgr;
        }
        catch (IOException localIOException)
        {
            localIOException.printStackTrace();
            return null;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
            localClassNotFoundException.printStackTrace();
        }
        return null;
    }

}

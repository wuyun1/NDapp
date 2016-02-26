package com.nongda.jonney.vo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jonney on 2016/2/26.
 */
public class TermInfo {
    //{"id":"1","class_year":"2013","class_term":"上","begindate":"20130225","enddate":"20130707"},

    private String id;
    private String classYear;
    private String classTerm;
    private String beginDate;
    private String endDate;

    @Override
    public String toString() {
        return "TermInfo{" +
                "endDate='" + endDate + '\'' +
                ", classYear='" + classYear + '\'' +
                ", classTerm='" + classTerm + '\'' +
                ", beginDate='" + beginDate + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassYear() {
        return classYear;
    }

    public void setClassYear(String classYear) {
        this.classYear = classYear;
    }

    public String getClassTerm() {
        return classTerm;
    }

    public void setClassTerm(String classTerm) {
        this.classTerm = classTerm;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TermInfo(JSONObject obj){
        try {
            this.id = obj.getString("id");
            this.classTerm = obj.getString("class_term");
            this.classYear = obj.getString("class_year");
            this.beginDate = obj.getString("begindate");
            this.endDate = obj.getString("enddate");
        } catch (JSONException e) {

            this.classTerm = "2016";
            this.classYear = "下";
            e.printStackTrace();
        }

    }
    public TermInfo(){
        this.classTerm = "2016";
        this.classYear = "下";
    }

}

package com.nongda.jonney.util;

import android.util.Xml;

import com.nongda.jonney.server.CourseMgr;
import com.nongda.jonney.vo.TermList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class NDWBS {

    private static WebService webService = null;
    static String M_NAME_GT = "GetTerm";
    static String M_NAME_GTC = "GetTeacherAddressListCount";
    static String M_NAME_GUI = "WSMemberLogin";
    //	static String M_NAME_W = "getWeatherbyCityName";
    final static String SERVICE_URI = "http://app.hnis.org/NDAppWebService.asmx";
    // final static String NS = "http://WebXml.com.cn/";

    private NDWBS() {
    }

    private static String getStrings(String m_NAME, Map<String, Object> prop) {
        InputStream is =  getWebService().invoke(m_NAME, prop);
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        String retstr = "";
        try {
            localXmlPullParser.setInput( is, "UTF-8");
//            int i = localXmlPullParser.getEventType();
//            System.out.println("result:"+i);
//            i = localXmlPullParser.next();
//            Log.v("Tag","i:"+i);
//            Log.v("Tag","Name:"+localXmlPullParser.getName());
//            Log.v("Tag","i:"+localXmlPullParser);
            localXmlPullParser.next();
            if ("string".equals(localXmlPullParser.getName()))
                retstr = localXmlPullParser.nextText();

        } catch (Exception e) {
            e.printStackTrace();
            return  retstr;

        }

        return  retstr;
    }

    public static String getTeachersCount() {
        return getStrings(M_NAME_GTC, null);
    }

    public static TermList getCTerm() {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("dt", "2015");
        String retstr = getStrings(M_NAME_GT, prop);
        JSONArray localJSONArray = null;
        TermList termList =   null;
        try {
            localJSONArray = new JSONObject(retstr).getJSONArray("Response");

        } catch (JSONException e) {

            e.printStackTrace();

        }
        termList  = new TermList(localJSONArray);

        return termList;
    }

    //http://app.hnis.org/NDAppWebService.asmx/WSMemberLogin?ak=agsvURNWGfPqrxLKF2ZW7b7f&id=201340922108&password=123456&BDUserID=201340922108
    public static String getUserMsg(String xuehao, String password) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("ak", "agsvURNWGfPqrxLKF2ZW7b7f");
        prop.put("id", xuehao);
        prop.put("password", password);
        prop.put("BDUserID", xuehao);
        return getStrings(M_NAME_GUI, prop);
    }
    //    http://app.hnis.org/NDAppWebService.asmx/GetStudentsKb?vid=20141114092017146&id=20141114092017146&Term=2016上&weeks=11
    public static CourseMgr getCoursefromStudent(String xuehao,String xueqi,String weeknum ){

        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("id", xuehao);
        prop.put("vid", xuehao);
        prop.put("Term", xueqi);
        prop.put("weeks", weeknum);
        String str =  getStrings("GetStudentsKb", prop);
        CourseMgr courseMgr= new CourseMgr();
        courseMgr.init();
        courseMgr.parseJsonMulti(str,false);
        return  courseMgr;
    }

    private static WebService getWebService() {
        if (webService == null) {
            webService = new WebService(SERVICE_URI);
        }
        return webService;
    }



    public static void parse(String protocolXML) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(protocolXML)));
            doc.getNodeValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

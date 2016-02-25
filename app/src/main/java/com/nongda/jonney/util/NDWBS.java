package com.nongda.jonney.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;
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
        return getWebService().getStrings(m_NAME, prop);
    }

    public static String getTeachersCount() {
        return getStrings(M_NAME_GTC, null);
    }

    public static String getCTerm() {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("dt", "20160220");
        return getStrings(M_NAME_GT, prop);
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
//	public NDWBS() {
//		super("http://app.hnis.org/NDAppWebService.asmx", "/NDAppWebService.asmx/");
//	}
//
//	public Object getCTerm() {
//		String M_NAME = "GetTerm";
//		Map<String, Object> prop = new HashMap<String, Object>();
//		prop.put("df", "2016-02-20");
//		return getStrings(M_NAME, prop);
//	}
//
//	// http://app.hnis.org/NDAppWebService.asmx/GetTeacherAddressListCount
//	public Object getTeachersCount() {
//		String M_NAME = "GetTeacherAddressListCount";
//
//		return getStrings(M_NAME, null);
//	}
//
////	public String getWeather(String citys) {
////		String M_NAME = "getWeatherbyCityName";
////		Map<String, Object> prop = new HashMap<String, Object>();
////		prop.put("theCityName", citys);
////		return getStrings(M_NAME, prop);
////	}

}

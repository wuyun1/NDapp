package com.nongda.jonney.util;

import java.util.HashMap;
import java.util.Map;

public class WeaterWBS {

    private static WebService webService = null;
    static String M_NAME_GSC = "getSupportCity";
    static String M_NAME_GSP = "getSupportProvince";
    static String M_NAME_W = "getWeatherbyCityName";
    final static String SERVICE_URI = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";
    // final static String NS = "http://WebXml.com.cn/";

    private WeaterWBS() {
    }

    private static Object getStrings(String m_NAME, Map<String, Object> prop) {
        return getWebService().invoke(m_NAME, prop);
    }

    public static Object getCitys() {

        return getStrings(M_NAME_GSP, null);
    }

    public static Object getCity(String citys) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("byProvinceName", citys);
        return getStrings(M_NAME_GSC, prop);
    }

    public static Object getWeather(String citys) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("theCityName", citys);
        return getStrings(M_NAME_W, prop);
    }

    private static WebService getWebService() {
        if (webService == null) {
            webService = new WebService(SERVICE_URI);

        }
        return webService;
    }

}

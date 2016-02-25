package com.nongda.jonney.util;

import java.util.HashMap;
import java.util.Map;

public class MyWebServiceTest {

    private static WebService webService = null;
    static String M_NAME_GU = "getuser";
    static String M_NAME_GUS = "getusers";
    // static String M_NAME_W = "getWeatherbyCityName";
    final static String SERVICE_URI = "http://192.168.1.103:8080/MyWebServices/SayHelloPort";
    // final static String NS = "http://WebXml.com.cn/";

    private static Object getStrings(String m_NAME, Map<String, Object> prop) {
        return getWebService().getStrings(m_NAME, prop);
    }

    public static Object getUser(String name, String age) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("arg0", name);
        prop.put("arg1", age);
        return getStrings(M_NAME_GU, null);
    }

    public static Object getUsers() {
        return getStrings(M_NAME_GUS, null);
    }

    private static WebService getWebService() {
        if (webService == null) {
            webService = new WebService(SERVICE_URI);
        }
        return webService;
    }

}

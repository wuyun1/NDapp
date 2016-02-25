package com.nongda.jonney.util;

import java.util.HashMap;
import java.util.Map;

public class MobileCodeWS {

    private static WebService webService = null;
    static String M_NAME_GMI = "getMobileCodeInfo";
    final static String SERVICE_URI = "http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx";

    private MobileCodeWS() {
    }

    public static Object getMobileCodeInfo(String cellphone) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put("mobileCode", cellphone);
        prop.put("userID", "");
        return getStrings(M_NAME_GMI, prop);
    }

    private static Object getStrings(String m_NAME, Map<String, Object> prop) {
        return getWebService().getStrings(m_NAME, prop);
    }

    private static WebService getWebService() {
        if (webService == null) {
            webService = new WebService(SERVICE_URI);
        }
        return webService;
    }
}

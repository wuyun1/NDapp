package com.nongda.jonney.test;

import com.nongda.jonney.util.NDWBS;
import com.nongda.jonney.util.WeaterWBS;

public class Test {
    public static void main(String[] args) throws Exception {
//		DynamicInvoker invoker = GlobalApp.getInvoker();
//		String result = invoker.invokeMethod("GetTerm", "20160219");
//		JsonParser jsonParser = new JsonParser();
//		JsonObject obj =(JsonObject) jsonParser.parse(result);
//		System.out.println(((JsonArray)obj.get("Response")).size());
        System.out.println(NDWBS.getCTerm());
        System.out.println(NDWBS.getTeachersCount());

        System.out.println(WeaterWBS.getCity("湖南"));
        System.out.println(WeaterWBS.getWeather("长沙"));
        System.out.println(WeaterWBS.getCitys());
    }
}

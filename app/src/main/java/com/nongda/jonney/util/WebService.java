package com.nongda.jonney.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.HttpClients;
import com.nongda.jonney.common.CacheMgr;

public class WebService {
    // Webservice服务器地址
    protected String SERVER_URI = null;
    // protected static HttpClient httpclient = null;
    // // 调用的webservice命令空间
    // protected final String PACE;
    // 获取所有省份的方法名
    // private HttpTransportSE httpSE = null;

    // public WebService(String serverUrl, String pace) {
    public WebService(String serverUrl) {
        if (!serverUrl.endsWith("/"))
            serverUrl += "/";
        SERVER_URI = serverUrl;
        // TODO Auto-generated catch block
        // httpclient = AndroidHttpClient.newInstance(null);
        // PACE = pace;
    }

    public InputStream invoke(final String M_NAME, Map<String, Object> prop) {
        // 创建HttpTransportSE传说对象 传入webservice服务器地址
        Object ret = null;
        String req = SERVER_URI + M_NAME;
        // 先将参数放入List，再对参数进行URL编码
        // 将URL与参数拼接
        String param = "";
        if (prop != null) {
            List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
            for (Map.Entry<String, Object> entry : prop.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
            }
            param = URLEncodedUtils.format(params, "UTF-8");
            // 对参数编码
            req += "?" + param;
        }

        return  CacheMgr.GetResource(req, 0, null, false);
//        byte[] content = MyIOUtil.getContent(CacheMgr.GetResource(req, 0, null, false));
//        if (content == null)
//            return null;
//        try {
//            return new String(content, "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//            return new String(content);
//        }

    }

}

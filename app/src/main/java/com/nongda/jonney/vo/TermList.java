package com.nongda.jonney.vo;

import org.json.JSONArray;
import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jonney on 2016/2/26.
 */
public class TermList {
    private int curTermindex = 0;
    private List<TermInfo> list = null;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date curDate = new Date();
    public TermList(JSONArray array){
        boolean isError = false;
        list = new ArrayList<>();
        for(int i =0,n=array.length();i<n;i++){
            try {
                TermInfo term = new TermInfo(array.getJSONObject(i));
                if(curDate.before(simpleDateFormat.parse(term.getEndDate())))
                list.add(term);
            } catch (Exception e) {
                e.printStackTrace();
                isError = true;
            }
        }
        if(isError&&list.isEmpty()){
            list.add(new TermInfo());
        }

    }

}

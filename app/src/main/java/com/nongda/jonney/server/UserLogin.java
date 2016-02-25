package com.nongda.jonney.server;

import com.nongda.jonney.common.CommandResult;
import com.nongda.jonney.util.NDWBS;

public class UserLogin {
    public static CommandResult login(String xuehao, String passowrd) {

        String ret = NDWBS.getUserMsg(xuehao, passowrd);

        return new CommandResult(ret != null, ret);
    }
}

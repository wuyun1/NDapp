package com.nongda.jonney.common;


/**
 * Created by Jonney on 2016/2/24.
 */
public class CommandResult {
    private Object data;
    private boolean flag;

    public CommandResult(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

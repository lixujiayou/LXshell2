package com.lx.shell2.core.http.erro;

/**
 * @auther lixu
 * Created by lixu on 2018/9/6.
 */
public class ErrorBodyDTO {
    private String errCode;
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}

package com.tyw.enums;

/**
 * Created by tboss on 2017/11/12.
 */
public enum ResultEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    CANNOTSAME(101,"用户名密码不能一致"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

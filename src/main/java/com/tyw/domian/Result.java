package com.tyw.domian;

/**
 * Created by tboss on 2017/11/12.
 */
public class Result<T> {
    /*标识码*/
    private Integer code;
    /*提示信息*/
    private String msg;
    /*返回内容*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

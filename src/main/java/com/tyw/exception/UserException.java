package com.tyw.exception;

import com.tyw.enums.ResultEnum;

/**
 * Created by tboss on 2017/11/12.
 */
public class UserException extends RuntimeException {
    private Integer code;
    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

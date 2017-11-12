package com.tyw.utils;

import com.tyw.domian.Result;

/**
 * Created by tboss on 2017/11/12.
 */
public class ResultUtil {
    public static Result success(Object obj) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }
    public static  Result success(){
        return  success(null);
    }
    public  static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}

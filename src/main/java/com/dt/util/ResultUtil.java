package com.dt.util;

import com.dt.domain.Result;

/**
 * Created by RID on 2017/4/12.
 */
public class ResultUtil {

    public static Result ok(Object obj){
        Result result =new Result();
        result.setCode(0);
        result.setMsg("operate successfully.");
        result.setData(obj);
        return result;
    }

    public static Result ok(){

        return ok(null);
    }


    public static Result err(Integer code, String msg){
        Result result =new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }





}

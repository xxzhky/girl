package com.dt.exception;

import com.dt.enums.ResultEnum;

/**
 * Created by RID on 2017/4/12.
 */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;

    }

    public GirlException(ResultEnum resultEnum) {
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

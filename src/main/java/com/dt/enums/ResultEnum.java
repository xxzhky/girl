package com.dt.enums;

/**
 * Created by RID on 2017/4/12.
 */
public enum ResultEnum {
    UNKNOW_ERR(-1,"UNKONW ERROR"),
    SUCCESS(0, "OK"),
    PRIMARY_SCHOOL(100, "The girl in the primary school."),
    MIDDLE_SCHOOL(200, "The girl in the middle school.")
    ;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

package com.tyw.domian;

/*
* @Description : 状态说明
* @Date : 2018/8/24  10:33  
* */

public enum UserState {
    INIT("初始化"),
    ACTIVE("使用中"),
    FAIL("禁用");

    private String desc;

    UserState(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}

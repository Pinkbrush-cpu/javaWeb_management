package com.czy.pojo;

public class Power {   //权限表
    private int id;
    private String permission;  // 1是正式成员，0是外部成员
    private int power;  //1为用户，10为管理

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}

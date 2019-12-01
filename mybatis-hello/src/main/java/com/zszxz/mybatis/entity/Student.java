package com.zszxz.mybatis.entity;

/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/12/1 20:07
 */
public class Student {

    // id
    private String id;
    // 学生姓名
    private String name;
    // 学生编号
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

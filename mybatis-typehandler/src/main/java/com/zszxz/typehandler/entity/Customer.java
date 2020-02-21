package com.zszxz.typehandler.entity;

/**
 * @Author lsc
 * <p> </p>
 */
public class Customer {

    // 主键
    private Long id;
    // 客户姓名
    private String customer_name;
    // 性别
    private String gender;
    // 电话
    private String telephone;
    // 注册时间
    private Long register_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getRegister_time() {
        return register_time;
    }

    public void setRegister_time(Long register_time) {
        this.register_time = register_time;
    }
}

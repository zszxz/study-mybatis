package com.zszxz.typehandler.mapper;

import com.zszxz.typehandler.entity.Customer;

import java.util.List;

public interface CustomerMapper {

    // 添加客户
    int addCustomer(Customer customer);
    // 查询客户
    List<Customer> getCustomer();
}

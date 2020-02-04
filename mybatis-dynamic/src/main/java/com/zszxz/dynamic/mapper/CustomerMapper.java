package com.zszxz.dynamic.mapper;

import com.zszxz.dynamic.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {

    // 添加客户
    int addCustomer(@Param("customers")List<Customer> customers);
    // 通过id查询用户
    List<Customer> getCustomerById(@Param("ids") List ids);
    // 查询客户
    List<Customer> getCustomer(Customer customer);
    // 添加客户
    int updateCustomer(Customer customer);
}

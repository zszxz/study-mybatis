package com.zszxz.dynamic;

import com.zszxz.dynamic.entity.Customer;
import com.zszxz.dynamic.mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@RunWith(JUnit4.class)
public class DynamicTest {

    SqlSession sqlSession = null;

    // @Before 会在执行测试类之前执行该方法
    @Before
    public void before() throws IOException {
        // 资源路径 resource目录下
        String resource = "mybatis-config.xml";
        // 配置mybatis获得输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从 SqlSessionFactory 中获取 SqlSession
        sqlSession= sqlSessionFactory.openSession();
    }

    @Test
    public void testInsert(){
        // 获得mapper的形式
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        ArrayList<Customer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer();
            customer.setCustomer_name("知识追寻者");
            customer.setGender("男");
            customer.setTelephone("999"+i);
            list.add(customer);
        }
        // 添加客户
        mapper.addCustomer(list);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        // 获得mapper的形式
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCustomer_name("知识追寻者");
        List<Customer> customerList = mapper.getCustomer(customer);
        for (Customer result :customerList){
            System.out.println(result.getCustomer_name());
            System.out.println(result.getRegister_time());
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testSelectById(){
        // 获得mapper的形式
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        ArrayList<Long> list = new ArrayList<>();
        list.add(19L);
        list.add(20L);
        List<Customer> customerList = mapper.getCustomerById(list);
        for (Customer result :customerList){
            System.out.println(result.getCustomer_name());
            System.out.println(result.getRegister_time());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        // 获得mapper的形式
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = new Customer();
        customer.setCustomer_name("知识追寻者");
        customer.setGender("男");
        customer.setTelephone("666");
        customer.setId(19L);
        customer.setRegister_time(LocalDateTime.now().toString());
        // 添加客户
        mapper.updateCustomer(customer);
        sqlSession.commit();
        sqlSession.close();
    }
}

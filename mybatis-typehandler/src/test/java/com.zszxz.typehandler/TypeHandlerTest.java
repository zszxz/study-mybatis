package com.zszxz.typehandler;

import com.zszxz.typehandler.entity.Customer;
import com.zszxz.typehandler.mapper.CustomerMapper;
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
import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@RunWith(JUnit4.class)
public class TypeHandlerTest {

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
        Customer customer = new Customer();
        customer.setCustomer_name("知识追寻者");
        customer.setRegister_time(1580739214L);
        customer.setGender("男");
        customer.setTelephone("999");
        // 添加客户
        mapper.addCustomer(customer);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        // 获得mapper的形式
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customerList = mapper.getCustomer();
        for (Customer customer :customerList){
            System.out.println(customer.getCustomer_name());
            System.out.println(customer.getRegister_time());
        }
        sqlSession.commit();
        sqlSession.close();
    }
}

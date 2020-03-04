package com.zszxz.plugin;

import com.zszxz.plugin.entity.Order;
import com.zszxz.plugin.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author lsc
 * <p> </p>
 */
public class PluginTest {

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
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setOrder_name("知识追寻者的订单");
        // 添加客户
        mapper.addOrder(order);
        sqlSession.commit();
        sqlSession.close();
    }
}

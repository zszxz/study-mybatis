package com.zszxz.mybatis;

import com.zszxz.mybatis.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author lsc
 * @Description <p> mybatis小白入门教程 </p>
 * @Date 2019/12/1 20:16
 */
public class MybatisApp {

    public static void main(String[] args) throws IOException {

        // 资源路径
        String resource = "mybatis-config.xml";
        // 配置mybatis获得输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从 SqlSessionFactory 中获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 使用 SqlSession 查询
        List<Student> getStudent = sqlSession.selectList("getStudent");
        for (Student student : getStudent){
            System.out.println("学生姓名："+student.getName()+"   学生编号："+student.getNumber());
        }
        // 关闭 SqlSession
        sqlSession.close();
    }
}

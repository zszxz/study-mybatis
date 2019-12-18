package com.zszxz.config;

import com.zszxz.config.entity.Student;
import com.zszxz.config.mapper.StudentMapper;
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
public class ConfigTest {

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
    public void testSelect(){
        // 获得mapper的形式
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudent();
        for (Student student : studentList){
            System.out.println(student.getName());
        }
        sqlSession.close();
    }

    @Test
    public void testTypeHandler(){
        // 获得mapper的形式
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("你是个坏孩子");
        student.setNumber("9999");
        studentMapper.addStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }
}

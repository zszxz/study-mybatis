package com.zszxz.mybatis.config;

import com.zszxz.mybatis.config.entity.Course;
import com.zszxz.mybatis.config.mapper.CourseMapper;
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
public class SelectTest {

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
    /* *
     * @Author lsc
     * <p> 查询课程列表</p>
     * @Param []
     * @Return void
     */
    @Test
    public void testSelect(){
        // 使用传入方法名查询形式
        List<Course> getCourseList = sqlSession.selectList("getCourseList");
        for (Course course : getCourseList){
            System.out.println(course.getCourseName());
        }
        sqlSession.close();
    }

    @Test
    public void testSelect2(){
        // 获得mapper的形式
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        for (Course course : courseMapper.getCourseList()){
            System.out.println(course.getCourseName());
        }
        sqlSession.close();
    }

    @Test
    public void testInsert(){

        Course course = new Course();
        course.setCourseName("知识追寻者的心理课");
        course.setCoursePrice(10000);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        courseMapper.addCourse(course);
        // 事物提交
        sqlSession.commit();
        // 关闭会话
        sqlSession.close();
    }

    @Test
    public void testInsertGetId1(){

        Course course = new Course();
        course.setCourseName("知识追寻者的课程1");
        course.setCoursePrice(100000);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        courseMapper.addCourseAndGetIdbyGen(course);
        //
        System.out.println("返回的课程id: "+course.getCourseId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertGetId2(){

        Course course = new Course();
        course.setCourseName("知识追寻者的课程2");
        course.setCoursePrice(100000);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        courseMapper.addCourseAndGetIdbyGen(course);
        //
        System.out.println("返回的课程id: "+course.getCourseId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate2(){

        Course course = new Course();
        course.setCourseName("知识追寻者的课程3");
        course.setCoursePrice(1000);
        course.setCourseId(5L);
        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        courseMapper.updateCourse(course);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDelte(){

        CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
        courseMapper.deleteCourse(1L);
        sqlSession.commit();
        sqlSession.close();
    }
}

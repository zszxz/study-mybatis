package com.zszxz.mybatis.config.mapper;

import com.zszxz.mybatis.config.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
public interface CourseMapper {

    /* *
     * @Author lsc
     * <p> 查询课程列表</p>
     * @Param []
     * @Return java.util.List<com.zszxz.mybatis.config.entity.Course>
     */
    List<Course> getCourseList();
    /* *
     * @Author lsc
     * <p> 普通新增</p>
     * @Param [course]
     * @Return int
     */
    int addCourse(Course course);
    /* *
     * @Author lsc
     * <p> 新增数据并获得主键方式1</p>
     * @Param [course]
     * @Return int
     */
    int addCourseAndGetIdbyGen(Course course);
    /* *
     * @Author lsc
     * <p> 新增数据并获得主键方式2</p>
     * @Param [course]
     * @Return int
     */
    int addCourseAndGetIdbyKey(Course course);
    /* *
     * @Author lsc
     * <p> </p>
     * @Param [course]
     * @Return int
     */
    int updateCourse(Course course);
    /* *
     * @Author lsc
     * <p> </p>
     * @Param []
     * @Return int
     */
    int deleteCourse(Long courseId);
}

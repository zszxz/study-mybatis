package com.zszxz.mybatis.config.entity;

/**
 * @Author lsc
 * <p> </p>
 */
public class Course {

    // 课程名称
    private String courseName;
    // 课程价格
    private double coursePrice;
    // 主键
    private Long courseId;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}

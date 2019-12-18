package com.zszxz.config.mapper;


import com.zszxz.config.entity.Student;

import java.util.List;

public interface StudentMapper {

    // 查询学生
    List<Student> getStudent();
    // 添加学生
    Integer addStudent(Student student);
}

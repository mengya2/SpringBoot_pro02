package com.zww.dao;

import com.zww.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 注解的作用，找到接口和她所对应的xml文件
 */
@Mapper
public interface StudentMapper {
    Student selectStudentById(@Param("id") Integer id);
}

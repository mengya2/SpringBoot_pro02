package com.zww.dao;

import com.zww.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
    Student selectStudentById(@Param("id") Integer id);
}

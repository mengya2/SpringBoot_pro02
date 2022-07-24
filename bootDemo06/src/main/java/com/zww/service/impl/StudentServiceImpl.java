package com.zww.service.impl;

import com.zww.dao.StudentMapper;
import com.zww.pojo.Student;
import com.zww.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {

    // 这里要调用dao中的
    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student selectStudent(Integer id) {
        Student student = studentMapper.selectStudentById(id);
        return student;
    }
}

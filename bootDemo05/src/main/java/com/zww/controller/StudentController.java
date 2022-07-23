package com.zww.controller;

import com.zww.pojo.Student;
import com.zww.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/selectAll")
    @ResponseBody
    public String selectAll(Integer id){
        Student student = studentService.selectStudent(id);
        return student.toString();
    }
}

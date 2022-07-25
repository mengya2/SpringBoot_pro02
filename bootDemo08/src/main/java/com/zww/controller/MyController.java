package com.zww.controller;

import org.springframework.web.bind.annotation.*;

@RestController   // 这个注解表示两个注解，一个是Controller一个是RestBody
public class MyController {
    /**
     * 我们在这里学习注解的使用
     * 使用@PathVariable (路径变量) ：获取url中的数据
     * 属性：value  路径变量名
     * 位置： 放在控制器方法的形参前面
     *{stuId}  :定义路径变量，就相当于在网址中把这个值给填上
     */
    // 查询id= 100的学生
    @GetMapping("/student/{stuId}")
    public String getStudent(@PathVariable(value = "stuId") Integer studentId){
        return "访问到的学生的id是 ："+studentId;
    }

    /**
     * 创建资源使用POST请求的方式,get请求和post请求需要在去看看
     */
    @PostMapping("/student/{name}/{age}")
    public String createStudent(@PathVariable(value = "name") String name,
                                @PathVariable(value = "age") Integer age){
        return "从表单创建了一个资源 ：name = "+name+" #age = "+age;
    }

    /**
     * 当路径变量名称和形参名一样，@PathVariable中的value可以省略
     * 更新资源
     */
    @PutMapping("/student/{id}/{age}")
    public String modifyStudent(@PathVariable Integer id,
                                @PathVariable Integer age){
        return "更新资源的功能，执行的是put资源 : id :"+id+"  age = "+age;
    }


    /**
     * 网页测试post请求
     */
    @PostMapping("/student/text")
    public String test(){
//        System.out.println();
        return "执行的是student/test，同时使用的是post请求";
    }

    /**
     * 使用put的方式，put的方式跟post是类似的，因为前面只能设置post或者get
     * put要从post转
     */
    @PutMapping("/student/text1")
    public String test1(){
        return "执行student/test ,使用的请求方式是put方式";
    }

    @DeleteMapping("/student/del")
    public String test2(){
        return "处理的是deleteMappering的方式，就是post转成delete的方式";
    }


}

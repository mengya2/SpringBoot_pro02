package com.zww.regg.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 异常处理类，是一个全局性的
 */
@Slf4j
@ResponseBody
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {

    /**
     * 异常处理的方法
     * @param exception
     * @return ：在页面显示出错的信息
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException exception){
        log.error(exception.getMessage());
        // 这个是用来处理添加的时候，用户名重复时显示的错误
        if (exception.getMessage().contains("Duplicate entry")){
            String[] split =exception.getMessage().split(" ");
            // Duplicate entry 'wangjiesb01' for key 'employee.idx_username'
            String msg = split[2] + "已经存在";
            return R.error(msg);
        }
        return R.error("失败了，产生异常");
    }
}

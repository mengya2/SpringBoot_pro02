package com.zww.regg.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zww.regg.entiey.Employee;
import com.zww.regg.mapper.EmployeeMapper;
import com.zww.regg.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee>  implements EmployeeService {
}

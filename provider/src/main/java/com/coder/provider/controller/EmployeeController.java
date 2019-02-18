package com.coder.provider.controller;

import com.coder.provider.elasticsearch.model.Employee;
import com.coder.provider.elasticsearch.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/es")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //增加
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id")String id){

        Employee employee=new Employee();
        employee.setId(id);
        employee.setFirstName("Y.S.K");
        employee.setLastName("~");
        employee.setAge(26);
        employee.setAbout("");
        employeeRepository.save(employee);

        System.err.println("add a obj");

        return "success";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(){
        Employee employee=new Employee();
        employee.setId("1");
        employeeRepository.delete(employee);

        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update(){

        Employee employee=employeeRepository.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeRepository.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query/{id}")
    public Employee query(@PathVariable("id")String id){

        Employee accountInfo=employeeRepository.queryEmployeeById(id);

        return accountInfo;
    }

}
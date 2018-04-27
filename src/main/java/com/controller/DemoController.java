package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee;
import com.service.DemoService;

@RestController
public class DemoController 
{
	@Autowired
	DemoService service;
	
	@RequestMapping(value="/say")
	public String sayHello() {
		return service.sayHello();
	}
	@RequestMapping(value="/emp")
	public Employee getEmployee() {
		return service.getEmployee();
		
	}
	@RequestMapping(value="/empList/{id}")
	public List<Employee> getEmployeeList() {
		return service.getEmployeeList();
	}
	@RequestMapping(value="/empById/{id}")
	public List<Employee> getEmployeeById(@PathVariable("id") int id) {
		return service.getEmployeeById(id);
	}
	@RequestMapping(value="/updateSal/{id}/{desig}")
	public String updateSalary(@PathVariable("id")int id, @PathVariable("desig")String designation) {
	
		return service.updateSalary(id, designation);
	}
}

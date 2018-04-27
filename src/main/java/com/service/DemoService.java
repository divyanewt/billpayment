package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee;
import com.da.DemoDAO;

@Service
public class DemoService 
{
	@Autowired
	DemoDAO dao;
	public String sayHello() {
		return dao.sayHello();
	}
	
	public Employee getEmployee() {
		return dao.getEmployee();
	}
	
	public List<Employee> getEmployeeList() {
		return dao.getEmployeeList();
		
	}
	public  List<Employee> getEmployeeById(int id) {
		return dao.getEmployeeById(id);
	}
	public String updateSalary(int id, String designation) {
		return dao.updateSalary(id, designation);
	}
}

package com.da;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee;

@Repository
public class DemoDAO 
{
	/*@Autowired
	DataSource ds;*/ // THis is for jdbc connection with spring boot
	
	@Autowired
	SessionFactory sf;
	public String sayHello() {
		System.out.println("I came here!!");
		return "Welcome to spring boot with MVC";
	}
	
	public Employee getEmployee() {
		Employee emp= new Employee();
		emp.setId(40009);
		emp.setName("divya");
		return emp;
		
	}
	
	public List<Employee> getEmployeeList() {
		List<Employee>empList=new ArrayList<Employee>();
		Employee emp= new Employee();
		Employee emp1= new Employee();
		Employee emp2= new Employee();
		Employee emp3= new Employee();
		
		
		emp.setId(40009);
		emp.setName("divya");
		
		emp1.setId(40013);
		emp1.setName("sundar");
		
		emp2.setId(40026);
		emp2.setName("kavitha");
		
		emp3.setId(40007);
		emp3.setName("vimal");
		
		empList.add(emp);
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		Session session= sf.openSession();
		Query qry= session.createQuery("select e from Employee e");
		List<Employee>listEmp=qry.list();
		return listEmp;
		
	}
	public  List<Employee> getEmployeeById( int id) {
		Session session= sf.openSession();
		Query qry= session.createQuery("select e from Employee e where e.id=?");
		qry.setParameter(0, id);
		
		 List<Employee> e=  qry.list();
		 Employee emp=e.get(0);
		 
		  //Employee emp=(Employee)session.get(Employee.class,new Integer(id));
		return e;
	}
	public String updateSalary(int id, String designation) {
	
		Session session= sf.openSession();
		Employee emp=(Employee)session.get(Employee.class,new Integer(id));
		if(emp!=null) {
		System.out.println("Employee"+emp.getDesignation()+emp.getName());
		
		Transaction tran=session.getTransaction();
		emp.setDesignation(designation);
		tran.begin();
		session.update(emp);
		tran.commit();
		System.out.println("Employee"+emp.getDesignation()+emp.getName());
		return "Record updated Successfully";
		}
		else {
			return "Record not Found!!!";
		}
		
		
		
	}
}

package com;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManager;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoTest 
{
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hem) {
		return hem.getSessionFactory();
	}
  public static void main(String[] args) {
	SpringApplication.run(DemoTest.class, args);
	/*AnnotationConfigApplicationContext obj=new AnnotationConfigApplicationContext();
	obj.scan("com");
	obj.refresh();
	Employee emp=(Employee) obj.getBean("employee");
	emp.setId(100);
	emp.setName("divya");
	System.out.println(emp.getId()+","+emp.getName());*/
}
    
}

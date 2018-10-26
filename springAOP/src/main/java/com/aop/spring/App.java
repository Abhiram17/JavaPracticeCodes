package com.aop.spring;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      
	      Student student = (Student) context.getBean("student");
	      student.getName();
	      student.getAge();
	      student.printThrowException();
	   }
}

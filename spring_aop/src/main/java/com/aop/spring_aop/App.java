package com.aop.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
         
         Student student = (Student) context.getBean("student");
         student.getName();
         student.getAge();
         student.printThrowException();
    }
}

package com.spring.spring_jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/spring_jdbc/config.xml");
        JdbcTemplate jd= context.getBean("jdbcTemplate",JdbcTemplate.class);
        System.out.println(jd.getDataSource().getConnection());
        
        String sql="insert into Student(id,name,number) value(?,?,?)";
        
        jd.update(sql,1,"ritesh","8956377557");
        
        
        System.out.println("successfully inserted");
    }
}

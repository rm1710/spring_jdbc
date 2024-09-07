package com.spring.javaconfig;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	public static void main(String[] args)throws SQLException {
		ApplicationContext context=new AnnotationConfigApplicationContext(config.class);
		
		
		JdbcTemplate jd=context.getBean("jdbc",JdbcTemplate.class);
		
		System.out.println(jd.getDataSource().getConnection());
		
		String sql="insert into student(id,name,number) values(?,?,?)";
		int i=jd.update(sql,2,"ritesh","896637744");
		System.out.println("successfully inserted: " + i);
	}
}

package com.spring.javaconfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.dao.studentDao;
import com.spring.model.student;

public class App {
	public static void main(String[] args)throws SQLException {
		ApplicationContext context=new AnnotationConfigApplicationContext(config.class);
		
		
//		JdbcTemplate jd=context.getBean("jdbc",JdbcTemplate.class);
//		
//		System.out.println(jd.getDataSource().getConnection());
		
		/*
		 * String sql="insert into student(id,name,number) values(?,?,?)"; int
		 * i=jd.update(sql,2,"ritesh","896637744");
		 * System.out.println("successfully inserted: " + i);
		 */
		
		/*
		 * String sql="insert into Student(id,name,number) values(?,?,?)"; int
		 * i=jd.update(sql,3,"ritesh","774995939");
		 * 
		 * System.out.println("success"+i);
		 */
		
//		update data
		/*
		 * String sql="update student set name=?, number=? where id=?"; int
		 * i=jd.update(sql,"rm","884665839",3);
		 * System.out.println(" update success="+i);
		 */
		
		/* delete date */
		/*
		 * String sql="delete from student where id=?"; int i=jd.update(sql,3);
		 * System.out.println("delete Successfully"+i);
		 */
		
		
		 /* String sql="select * from student where id=?"; 
		  RowMapper rowMapper=new RowMapper() {
		  
		  @Override public Object mapRow(ResultSet rs, int rowNum) throws SQLException
		  { String name= rs.getString(2); return name; } };
		  
		  String name = (String) jd.queryForObject(sql,rowMapper,2);
		  System.out.println(name);*/
		 
//		String sql="select * from student where id=?"; 
//		RowMapper rowMapper=new RowMapper() {
//
//			@Override public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
//					String name= rs.getString(2); return name; 
//			} 
//		};
//		List<String> list=jd.query(sql, rowMapper);
//		
//		for(String name:list) {
//			System.out.println(name);
//		}
		
		studentDao dao=context.getBean("stDao",studentDao.class);
		
		student st=new student();
		st.setId(3);
		st.setName("rrm");
		st.setNumber("993887484");
		
		
		int i= dao.insert(st);
		System.out.println("inserted success " +i);
	}
}

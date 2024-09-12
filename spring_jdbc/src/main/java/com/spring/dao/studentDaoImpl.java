package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.model.student;

public class studentDaoImpl implements studentDao {
	
	private JdbcTemplate jdbcTemplate;

	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(student student) {
		String sql="insert into student(id,name,number) values(?,?,?)";
		int i = jdbcTemplate.update(sql,student.getId(),student.getName(),student.getNumber());
		return i;
	}

	@Override
	public int updateDetails(student student) {
		String sql="update student set name=?, number=? where id=?";
		int i= jdbcTemplate.update(sql,student.getName(),student.getNumber(),student.getId());
		return i;
	}

	@Override
	public int delete(int id) {
		String sql="delete from student where id=?"; 
		int i= jdbcTemplate.update(sql,3);
		return i;
	}

	@Override
	public student getStudentById(int id) {
		String sql="select * from student where id=?";
		RowMapper rowMapper= new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				student st=new student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setNumber(rs.getString(3));
				return st;
			}
		};
		
		student st=(student) jdbcTemplate.queryForObject(sql, rowMapper,id);
		
		
		
		return st;
	}

	@Override
	public List<student> getAllStudent() {
		String sql="select * from student where id=?";
		RowMapper rowMapper= new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				student st=new student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setNumber(rs.getString(3));
				return st;
			}
		};
		List<student> list=jdbcTemplate.query(sql, rowMapper);
		return list;
	}
	
}

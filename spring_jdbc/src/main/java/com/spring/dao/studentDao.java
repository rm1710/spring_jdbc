package com.spring.dao;

import java.util.List;

import com.spring.model.*;

public interface studentDao {
	public int insert(student student);
	public int updateDetails(student student);
	public int delete(int id);
	
	public student getStudentById(int id);
	public List<student> getAllStudent();
}

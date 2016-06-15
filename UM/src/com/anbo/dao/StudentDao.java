package com.anbo.dao;

import java.util.List;

import com.anbo.po.Student;

public interface StudentDao {
	/**
	 * 获得所有的学生信息
	 * @return
	 */
	public List<Student> getAllStudent();
   
}

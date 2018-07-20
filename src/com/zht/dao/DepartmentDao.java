package com.zht.dao;

import java.util.List;

import com.zht.entity.Department;
import com.zht.entity.PageBean;

public interface DepartmentDao {



	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	List<Department> findAll();

	void delete(Department department);



}

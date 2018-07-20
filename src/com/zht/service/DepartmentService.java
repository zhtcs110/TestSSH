package com.zht.service;

import java.util.List;

import com.zht.entity.Department;
import com.zht.entity.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	List<Department> findAll();

	void delete(Department department);

}

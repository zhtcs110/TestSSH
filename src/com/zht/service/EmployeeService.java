package com.zht.service;

import com.zht.entity.Employee;
import com.zht.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findAll(int currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Integer eid);

}

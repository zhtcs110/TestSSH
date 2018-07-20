package com.zht.dao;

import java.util.List;

import com.zht.entity.Employee;

public interface EmployeeDao {

	

	Employee findbyNameAndPassword(Employee employee);

	int findCount();

	List<Employee> findAll(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Integer eid);

}

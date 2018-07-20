package com.zht.service.impl;

import java.util.List;

import com.zht.dao.EmployeeDao;
import com.zht.entity.Employee;
import com.zht.entity.PageBean;
import com.zht.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;



	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao; 
	}


	/**
	 * ҵ����¼����
	 */

	@Override
	public Employee login(Employee employee) {
	Employee existEmployee =	employeeDao.findbyNameAndPassword(employee);
		
		return existEmployee;
	}


	@Override
	public PageBean<Employee> findAll(int currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();
		pageBean.setCurrPage(currPage);
		int pageSize = 10;
		pageBean.setPageSize(pageSize);
		int totalCount = employeeDao.findCount();//������
		pageBean.setTotalCount(totalCount);
		int totalPage = 0;
		if(totalCount%pageSize==0){
			totalPage = totalCount/pageSize;
		}else{
			totalPage = totalCount/pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		
		//��ȡȫ��Ա����Ϣ
		int begin = (currPage-1)*pageSize;
		List<Employee> list= employeeDao.findAll(begin,pageSize); 
		pageBean.setList(list);
		
		System.out.println("currPage:"+currPage);
		return pageBean;
	}


	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
		employeeDao.save(employee);
	}


	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee employee =employeeDao.findById(eid);
		return employee;
	}


	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}


	@Override
	public void delete(Integer eid) {
		// TODO Auto-generated method stub
		employeeDao.delete(eid);
	}
	
	
}

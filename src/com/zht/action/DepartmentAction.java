package com.zht.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zht.entity.Department;
import com.zht.entity.PageBean;
import com.zht.service.DepartmentService;



public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private Department department = new Department();

	private DepartmentService departmentService;
	
	

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	private int currPage = 1;
	public String findAll(){
		
		PageBean<Department> pageBean =departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

//��ת�������ҳ��
	public String saveUI(){
		return "saveUI";
	}
	
	//���沿����Ϣ

	public String save(){
	
		departmentService.save(department);
		return "saveSuccess";
	}

	public String edit(){
		
		department = departmentService.findById(department.getDid());
		
		return "editSuccess";
	}

	public String update(){
		departmentService.update(department);
		
		return "updateSuccess";
	}
	public String delete(){
		department=departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}

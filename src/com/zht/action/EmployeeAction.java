package com.zht.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zht.entity.Department;
import com.zht.entity.Employee;
import com.zht.entity.PageBean;
import com.zht.service.DepartmentService;
import com.zht.service.EmployeeService;



public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {

	
	private List<Department> list=null;
	public EmployeeAction() {
		super();
		list =new ArrayList<Department>();
	}

	private Employee employee = new Employee();
	private EmployeeService employeeService;

	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public String login(){
		Employee existEmployee =employeeService.login(employee);
		if(existEmployee==null){
			//����ʧ��
			if(employee.getUsername()==null||employee.getUsername().equals("")){
				this.addActionError("�������û������룡");
			}else{
				this.addActionError("�û���or��������");
			}
			return INPUT;
		}else if(existEmployee.getDepartment().getDid()!=3){
			//�������²�(did=3)Ա����û�е���Ȩ��
			this.addActionError("�����²�Ա��");
			return INPUT;
		}else{
			//���²�(did=3)Ա������ɹ�
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
	}
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logoutSuccess";
	}
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	private int currPage =1;
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		System.out.println("currPage1:"+currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	
	//�������Ա������
	public String add(){
		
		 list =	departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "add";
	}
	public List<Department> getList() {
		return list;
	}
	public void setList(List<Department> list) {
		this.list = list;
	}
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	public String edit(){
		//��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		//��ѯ���в���
		list =	departmentService.findAll();
		return "editSuccess";
	}
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	//ɾ��Ա��
	public String delete(){
		employeeService.delete(employee.getEid());
		return "deleteSuccess";
	}
}

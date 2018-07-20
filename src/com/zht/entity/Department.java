package com.zht.entity;

import java.util.HashSet;
import java.util.Set;


public class Department implements java.io.Serializable {


	private Integer did;
	private String dname;
	private String ddesc;
	private Set employees = new HashSet(0);


	public Department() {
	}

	public Department(String dname, String ddesc, Set employees) {
		this.dname = dname;
		this.ddesc = ddesc;
		this.employees = employees;
	}


	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return this.ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

	

}
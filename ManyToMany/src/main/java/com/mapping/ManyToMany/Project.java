package com.mapping.ManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Project 
{
	@Id
	@Column(name = "Project_id")
	private int pid;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int pid, String pname, List<Employee> emp) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.emp = emp;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	private String pname;
	@ManyToMany(mappedBy="project")
	private List<Employee>emp;

}

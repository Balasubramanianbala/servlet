package in.vamsoft.el;

import java.time.LocalDate;

public class Employee {

	int empid;
	String empname;
	LocalDate doj;
	double salary;
	int deptid;
	Address address;
	public Employee(int empid, String empname, LocalDate doj, double salary, int deptid, Address address) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.doj = doj;
		this.salary = salary;
		this.deptid = deptid;
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empid2, String empname2, int i, LocalDate now, int deptid2, in.vamsoft.el.Address add) {
		// TODO Auto-generated constructor stub
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}

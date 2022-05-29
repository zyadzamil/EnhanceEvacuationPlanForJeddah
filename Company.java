package jeddah2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Company {
	/*
	 * @author HASSAN
	 */

//	private District district;
	private ArrayList<Employee> employee;
	private int salary;
	private int comuteCost;


	Random rand = new Random();

	/**
	 * @param district
	 * @param employee
	 * @param salary
	 * @param comuteCost
	 */
	public Company(ArrayList<Employee> employee, int salary, int comuteCost) {

//		setDistrict(district);
		setEmployee(employee);
		setSalary(salary);
		setComuteCost(comuteCost);

	}

	public Company() {

		int num = rand.nextInt((int)(Math.random()*200)+15);

		Employee[] employee = new Employee[num];
		for (int e = 0; e < num; e++){
			employee[e] = new Employee();
		}

		ArrayList<Employee>employeeList = new ArrayList<>(Arrays.asList(employee));

		setEmployee(employeeList);
		setSalary(salary);
		setComuteCost(comuteCost);

	}

//
//	public District getDistrict() {
//		return district;
//	}
//	public void setDistrict(District district) {
//		this.district = district;
//	}

	public ArrayList<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(ArrayList<Employee> employee) {
		this.employee = employee;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getComuteCost() {
		return comuteCost;
	}
	public void setComuteCost(int comuteCost) {
		this.comuteCost = comuteCost;
	}
}

package jeddah2;

import java.util.Random;

public class Employee {

	/*
	 * @author HASSAN
	 */

//	private Company company;
//	private Resident resident;
	private int salary;
	private int commuteCost;
	Random rnd = new Random();

	/**
	 * @param company
	 * @param resident
	 * @param salary
	 * @param commuteCost
	 */
	public Employee( int salary, int commuteCost) {

//		setResident(resident);
		setSalary(salary);
		setCommuteCost(commuteCost);
//		setCompany(company);
	}


	public Employee() {

		setSalary((int)(rnd.nextDouble()*50001));
		setCommuteCost((int)(0.05*getSalary()));

	}


//	public Company getCompany() {
//		return company;
//	}

	public int getCommuteCost() {
		return commuteCost;
	}

//	public Resident getResident() {
//		return resident;
//	}

	public int getSalary() {
		return salary;
	}




//	public void setResident(Resident resident) {
//		this.resident = resident;
//	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setCommuteCost(int commuteCost) {
		this.commuteCost = commuteCost;
	}
//	public void setCompany(Company company) {
//		this.company = company;
//	}


//	public static void main(String[] args){
//		Employee emp1 = new Employee();
//		System.out.println(emp1.getCommuteCost());
//		System.out.println(emp1.getSalary());
//	}
}

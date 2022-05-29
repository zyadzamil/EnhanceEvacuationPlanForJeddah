package jeddah2;

import java.util.Random;

public class Student {
	/*
	 * author HASSAN
	 */
	Random rand = new Random();
//	private School school;
//	private Family family;
	private int commuteCost;


	/**
	 * @param school
	 * @param family
	 * @param commuteCost
	 */
	public Student() {

//		setSchool(school);
//		setFamily(family);
		setCommuteCost((rand.nextInt(12) + 9)*100);
	}

	public Student(int commuteCost) {

//		setSchool(school);
//		setFamily(family);
		setCommuteCost(commuteCost);
	}


//	public School getSchool() {
//		return school;
//	}
//	public Family getFamily() {
//		return family;
//	}
	public int getCommuteCost() {
		return commuteCost;
	}



//	public void setSchool(School school) {
//		this.school = school;
//	}
//	public void setFamily(Family family) {
//		this.family = family;
//	}

	public void setCommuteCost(int commuteCost) {
		this.commuteCost = commuteCost;
	}




}

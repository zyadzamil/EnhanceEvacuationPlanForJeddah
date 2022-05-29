package jeddah2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class School {
	/*
	 * @author AJADI
	 */

	Random rand = new Random();

	private int maxCapacity;
	private ArrayList<Student> students;
//	private District district;
	private boolean demolished;



	public School() {


		int num = rand.nextInt(51) + 10;

		Student[] student = new Student[num];
		for (int i = 0; i < num; i++){
			student[i] = new Student();
		}

		ArrayList<Student>studentList = new ArrayList<>(Arrays.asList(student));

		setMaxCapacity((int)(rand.nextDouble()*1001));
		setStudents(studentList);
//		setDistrict(district);
		setDemolished(false);
	}

	/**
	 * @param maxCapacity
	 * @param students
	 * @param district
	 * @param demolished
	 */
	public School(int maxCapacity, ArrayList<Student> students, boolean demolished) {
		setMaxCapacity(maxCapacity);
		setStudents(students);
//		setDistrict(district);
		setDemolished(demolished);
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
//	public District getDistrict() {
//		return district;
//	}
	public boolean isDemolished() {
		return demolished;
	}



	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

//	public void setDistrict(District district) {
//		this.district = district;
//	}

	public void setDemolished(boolean demolished) {
		this.demolished = demolished;
	}



}

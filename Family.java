package jeddah2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author AJADI
 *
 */
public class Family extends Resident {

	private ArrayList<Student> sFamilyMember;
	private ArrayList<Employee> eFamilyMember;
	private int familyIncomePerMonth;
	private int numOfMale;

	public Family(int numOfResident, int comuteCost, int appartmentNum, ArrayList<Student> sFamilyMember, ArrayList<Employee> eFamilyMember, int familyIncomePerMonth,
			int numOfMale) {

		super(numOfResident, comuteCost, appartmentNum);
		setsFamilyMember(sFamilyMember);
		seteFamilyMember(eFamilyMember);
		setFamilyIncomePerMonth(familyIncomePerMonth);
		setNumOfMale(numOfMale);

	}

	public Family(){
		int sNum = r.nextInt(6)+1;
		int eNum = r.nextInt(5)+1;


		Employee[] eMember = new Employee[eNum];
		Student[] sMember = new Student[sNum];

		for(int k = 0; k < sNum; k++){
			sMember[k] = new Student();

		}

		ArrayList<Student> sFam = new ArrayList<>(Arrays.asList(sMember));

		for(int j = 0; j < eNum; j++){
			eMember[j] = new Employee();

		}

		ArrayList<Employee> eFam = new ArrayList<>(Arrays.asList(eMember));


		//super(numOfResident, comuteCost, appartmentNum);
		setNumOfResident(eNum + sNum + 1);
		setCommuteCost(totalCommuteCost(eFam,sFam));
		setAppartmentNum(r.nextInt(50)+200);
		setsFamilyMember(sFam);
		seteFamilyMember(eFam);
		setFamilyIncomePerMonth(totalIncomePerFamily(eFam));
		setNumOfMale(eFam.size());
	}




	public ArrayList<Student> getsFamilyMember() {
		return sFamilyMember;
	}
	public void setsFamilyMember(ArrayList<Student> sFamilyMember) {
		this.sFamilyMember = sFamilyMember;
	}
	public ArrayList<Employee> geteFamilyMember() {
		return eFamilyMember;
	}
	public void seteFamilyMember(ArrayList<Employee> eFamilyMember) {
		this.eFamilyMember = eFamilyMember;
	}
	public int getFamilyIncomePerMonth() {
		return familyIncomePerMonth;
	}
	public void setFamilyIncomePerMonth(int familyIncomePerMonth) {
		this.familyIncomePerMonth = familyIncomePerMonth;
	}
	public int getNumOfMale() {
		return numOfMale;
	}
	public void setNumOfMale(int numOfMale) {
		this.numOfMale = numOfMale;
	}



	public int totalIncomePerFamily(ArrayList<Employee> efam){

		int sum = 0;
		for (int i = 0; i < efam.size(); i++ ){
			sum += efam.get(i).getSalary();
		}

		return sum;
	}

	public int totalCommuteCost(ArrayList<Employee> efam, ArrayList<Student> sfam){

		int sum = 0, num1 = 0, num2 = 0, per=0;

		if (efam.size() > sfam.size()){
		for (int i = 0; i < efam.size(); i++ ){
			num1 += efam.get(i).getCommuteCost();
		}

		for (int j = 0; j < sfam.size(); j++ ){
			num2 += sfam.get(j).getCommuteCost();
		}

			sum = num1 + num2;
		}
		else{
			for (int i = 0; i < efam.size(); i++ ){
				per += efam.get(i).getSalary();

				sum = (int) Math.ceil(0.2 * per);
			}
		}

		return sum;
	}


//	public static void main(String[] args){
//		Family family1 = new Family();
//
//
//
//		System.out.println(family1.getNumOfResident());
//		System.out.println(family1.getNumOfMale());
//		System.out.println(family1.geteFamilyMember());
//		System.out.println(family1.getsFamilyMember());
//		System.out.println(family1.getFamilyIncomePerMonth());
//		System.out.println(family1.getCommuteCost());
//		System.out.println(family1.getAppartmentNum());
//
//
//	}
}

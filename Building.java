 package jeddah2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Building {

	/*
	 * @author ZYAD, AbdulRahman
	 */

	private ArrayList<Resident> residents;
	private int area;
//	private District district;
	private boolean demolished;
	private int appartments;
	private int rent;

	Random r = new Random();


	/**
	 * @param residents
	 * @param area
	 * @param district
	 * @param demolished
	 * @param appartments
	 * @param rent
	 */
	public Building(ArrayList<Resident> residents, int area, boolean demolished, int appartments,
			int rent) {

			setResidents(residents);
			setArea(area);
//			setDistrict(district);
			setDemoslished(demolished);
			setAppartments(appartments);
			setRent(rent);
	}

	public Building(){

		int var = r.nextInt(10) + 7;
		int var1 = r.nextInt(4) + 3;

		Family [] fam = new Family[var];
		Single [] sgl = new Single[var1];

			for (int f = 0; f < var; f++){
				fam[f] = new Family();
			}


			for (int s = 0; s < var1; s++){
				sgl[s] = new Single();
			}



		ArrayList<Resident> dweller = new ArrayList<>(Arrays.asList(fam));


		for (int i = 0; i < sgl.length; i++){
			dweller.add(sgl[i]);
		}

		setResidents(dweller);
		setArea((r.nextInt(21)+100)*(r.nextInt(11)+50));
//		setDistrict(district);
		setDemoslished(false);
		setAppartments(dweller.size());
		setRent((int)(r.nextDouble()*5001));



	}

	public ArrayList<Resident> getResidents() {
		return residents;
	}
	public int getArea() {
		return area;
	}

	public boolean isDemoslished() {
		return demolished;
	}
	public int getAppartments() {
		return appartments;
	}
	public int getRent() {
		return rent;
	}




	public void setResidents(ArrayList<Resident> residents) {
		this.residents = residents;
	}
	public void setArea(int area) {
		this.area = area;
	}



	public void setDemoslished(boolean demolished) {
		this.demolished = demolished;
	}
	public void setAppartments(int appartments) {
		this.appartments = appartments;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}

//	public void setDistrict(District district) {
//	this.district = district;
//}


//	public District getDistrict() {
//		return district;
//	}


}

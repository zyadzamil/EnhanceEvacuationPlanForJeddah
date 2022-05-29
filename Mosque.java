package jeddah2;

import java.util.Random;

public class Mosque {
	/*
	 * @author AbdulRahman
	 */

	private int maxCapacity;
//	private District district;
	private boolean demolished;



	public Mosque(){
		Random random = new Random();
		setMaxCapacity((int)(random.nextDouble()*1001));
		isdemolished(false);
	}

	public Mosque(int maxCapacity, boolean demolished) {

		setMaxCapacity(maxCapacity);
//		setDistrict(district);
		isdemolished(demolished);

	}



	public int getMaxCapacity() {
		return maxCapacity;
	}

//
//	public District getDistrict() {
//		return district;
//	}

	public boolean getdemolished() {
		return demolished;
	}




	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

//	public void setDistrict(District district) {
//		this.district = district;
//	}

		public void isdemolished(boolean demolished) {
		this.demolished = demolished;
	}
}

package jeddah2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class District {

	/*
	 *
	 * @author AJADI
	 */
		Random r = new Random();

	private ArrayList <Building> buildings;
	private double demolishingPercent;
	private ArrayList<School> schools;
	private ArrayList<Company> companies;
	private ArrayList<Mosque> masjids;
	private int livingCostPerMonth;
	private double trafficPercent;
	private int movingCost;
	private int randomnessPercent;
	private double populationPercent;


	/**
	 * @param buildings
	 * @param demolishingPercent
	 * @param schools
	 * @param companies
	 * @param masjids
	 * @param livingCostPerMonth
	 * @param trafficPercent
	 * @param movingCost
	 * @param randomnessPercent
	 * @param populationPercent
	 */
	public District(ArrayList<Building> buildings, double demolishingPercent, ArrayList<School> schools,
			ArrayList<Company> companies, ArrayList<Mosque> masjids, int livingCostPerMonth, double trafficPercent,
			int movingCost, int randomnessPercent, double populationPercent) {

		setBuildings(buildings);
		setDemolishingPercent(demolishingPercent);
		//Continue the rest...
		setSchools(schools);
		setCompanies(companies);
		setMasjids(masjids);
		setLivingCostPerMonth(livingCostPerMonth);
		setTrafficPercent(trafficPercent);
		setMovingCost(movingCost);
		setRandomnessPercent(randomnessPercent);
		setPopulationPercent(populationPercent);
	}

//	public District(ArrayList<Building> buildings,  ArrayList<School> schools,
//			ArrayList<Company> companies, ArrayList<Mosque> masjids) {
//
//		setBuildings(buildings);
//		setDemolishingPercent();
//		//Continue the rest...
//		setSchools(school);
//		setCompanies(company);
//		setMasjids(mosque);
//		setLivingCostPerMonth(findAverageLivingCost(house.get(r.nextInt(var)).getResidents()));
//		setTrafficPercent(censor(house)/500);
//		setMovingCost(var3);
//		setRandomnessPercent(var4/100);
//		setPopulationPercent(censor(house)/100);
//	}

	public District(){
		int var = r.nextInt(20) + 20;
		int var1 = r.nextInt(4) + 7;
		double var2 = r.nextDouble();
		int var3 = (int)(r.nextDouble()*7001);
		int var4 = var + var1 + (int)var2 + var3;
		Building [] building = new Building[var];
		School [] sch = new School[var1];
		Company [] comp = new Company[var1];
		Mosque [] masjd = new Mosque[var1];


		for (int b = 0; b < building.length; b++){
			building[b] = new Building();
		}

		for (int s = 0; s < sch.length; s++){
			sch[s] = new School();
		}

		for (int c = 0; c < comp.length; c++){
			comp[c] = new Company();
		}

		for (int m = 0; m < masjd.length; m++){
			masjd[m] = new Mosque();
		}

		ArrayList<Building> house =  new ArrayList<>(Arrays.asList(building));
		ArrayList<School> school =  new ArrayList<>(Arrays.asList(sch));
		ArrayList<Company> company =  new ArrayList<>(Arrays.asList(comp));
		ArrayList<Mosque> mosque =  new ArrayList<>(Arrays.asList(masjd));




		setBuildings(house);
		setDemolishingPercent(var2);
		//Continue the rest...
		setSchools(school);
		setCompanies(company);
		setMasjids(mosque);
		setLivingCostPerMonth(findAverageLivingCost(house.get(r.nextInt(var)).getResidents()));
		setTrafficPercent(censor(house)/500);
		setMovingCost(var3);
		setRandomnessPercent(var4/100);
		setPopulationPercent(censor(house)/100);
	}



/*
 * The getters method section
 */
	public ArrayList<Building> getBuildings() {
		return buildings;
	}
	public double getDemolishingPercent() {
		return demolishingPercent;
	}
	public ArrayList<School> getSchools() {
		return schools;
	}
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public ArrayList<Mosque> getMasjids() {
		return masjids;
	}
	public int getLivingCostPerMonth() {
		return livingCostPerMonth;
	}
	public double getTrafficPercent() {
		return trafficPercent;
	}
	public int getMovingCost() {
		return movingCost;
	}
	public int getRandomnessPercent() {
		return randomnessPercent;
	}
	public double getPopulationPercent() {
		return populationPercent;
	}



/*
 * The setters methods section
 */
	public void setBuildings(ArrayList<Building> buildings) {
		this.buildings = buildings;
	}
	public void setDemolishingPercent(double demolishingPercent) {
		this.demolishingPercent = demolishingPercent;
	}
	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	public void setMasjids(ArrayList<Mosque> masjids) {
		this.masjids = masjids;
	}
	public void setLivingCostPerMonth(int livingCostPerMonth) {
		this.livingCostPerMonth = livingCostPerMonth;
	}
	public void setTrafficPercent(double trafficPercent) {
		this.trafficPercent = trafficPercent;
	}
	public void setMovingCost(int movingCost) {
		this.movingCost = movingCost;
	}
	public void setRandomnessPercent(int randomnessPercent) {
		this.randomnessPercent = randomnessPercent;
	}
	public void setPopulationPercent(double populationPercent) {
		this.populationPercent = populationPercent;
	}

//	public static void main(String[] args){
//		District d = new District();
//
//
//		System.out.println(d.getBuildings().size());
//		System.out.println(d.getBuildings().get(10).getResidents().get(0).getNumOfResident());
//	}
//



	/*
	 * @param Resident
	 *
	 * In this method Resident is taken as a parameter and used to find the
	 * average living cost in a certain district
	 */
	 public  int findAverageLivingCost (ArrayList<Resident> r){
		 int sum = 0, sum1 = 0;
		 ArrayList<Family> fam = new ArrayList<>();
		 ArrayList<Single> sing = new ArrayList<>();

		 /*
		  * Because the Resident can either be a single or family
		  * there was need to check and separate them.
		  */

		 for (int f = 0; f < r.size(); f++){

		 if (r.get(f) instanceof Family){
			 		fam.add((Family) r.get(f));
		 }

		 else{
			 sing.add((Single) r.get(f));
		 }

		 }

			 for (int j = 0; j< fam.size(); j++){
				 sum += fam.get(j).getFamilyIncomePerMonth();
			 }

			 for (int k = 0; k < sing.size(); k++){
				 for(int p = 0; p < sing.get(k).getEmployeeList().size(); p++){
					 sum1 += sing.get(k).getEmployeeList().get(p).getSalary();
				 }
			 }



		return (int)((sum + sum1)/(r.size()*10));

	 }
/*
 * @param building
 * This method takes building check the number of Residents in each
 * and sum up the number and divide by a 100 to get a percentage of
 * the population in a district.
 */
	 public double censor(ArrayList<Building> b){

		 double headCount = 0;

		 for (int c = 0; c < b.size(); c++){
			 for(int d = 0; d < b.get(c).getResidents().size(); d++){
				 headCount +=  b.get(c).getResidents().get(d).numOfResident;
			 }
		 }


		 return headCount;
	 }



// 	public static void main(String[] args){
// 		District d = new District();
//
//
// 		System.out.println("Demolishing % = " + d.getDemolishingPercent());
// 		System.out.println("Living Cost = " + d.getLivingCostPerMonth());
// 		System.out.println("Moving Cost = " + d.getMovingCost());
// 		System.out.println("Population = " + d.getPopulationPercent());
// 		System.out.println("Randomness = " + d.getRandomnessPercent());
// 		System.out.println("Traffic = " + d.getTrafficPercent());
// 		System.out.println("Buildings = " + d.getBuildings());
// 	}
}

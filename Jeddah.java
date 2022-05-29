 package jeddah2;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collection;
import java.util.Random;

public class Jeddah {

	/*
	 * @author AJADI, HASSAN
	 *
	 */
	Random r = new Random();

	private ArrayList<District> district;
	private ArrayList<Resident> residentOfJeddah;
//
	public Jeddah(){

		int dst = r.nextInt(21) + 6;
		District [] dsrt = new District[dst];

		 for(int d = 0; d < dsrt.length; d++){
			 dsrt[d] = new District();
		 }

		 ArrayList<District> districts = new ArrayList<>(Arrays.asList(dsrt));
		 setDistrict(districts);
	}


	public static void main(String[] args){
		/*
		 * Set Up
		 * 1. Create Array of Districts
		 *
		 * Main Loop
		 * 1. Jeddah decides everyday which building to demolish.
//		 *
		 * 2. Tells residents to move to new building
		 *
		 * 3. Families settle in new district.
		 *
		 * 4. Jeddah recalculate every district living cost
		 *
		 */

				//Random random = new Random();
//				int month = random.nextInt(3) + 29;

			Jeddah underDev = new Jeddah();
			Jeddah upNorth = new Jeddah();

		System.out.println("---------------------------------------------------- DISTRICTS DATA (BEFORE CHANGES)-----------------------------------------------------------------------------------");
		printInfo(underDev.getDistrict());
		System.out.println("_______________________________________________________________________________________________________________________________________________________________________");
		System.out.println();
		System.out.println("------------------------------------------- POSSIBLE DISTRICTS TO MOVE TO(BEFORE CHANGES) ------------------------------------------------------------------------------");
		printInfo(upNorth.getDistrict());


		//System.out.println(upNorth.getDistrict().get(0).getMasjids().get(0).getdemolished());
		demolish(upNorth);

		//System.out.println(upNorth.getDistrict().get(0).getMasjids().get(2).getdemolished());


		for(int i = 1; i <= 7; i++){

		System.out.printf("============================== DAY %d =================================", i);
		System.out.println();


		printInfo(recalculate(move(demolish(underDev),upNorth)));
		}

















	}

	public ArrayList<District> getDistrict(){
		return district;
	}

	public void setDistrict(ArrayList<District> districts){
		district = districts;
	}





	/**
	 * @return the residentOfJeddah
	 */
	public ArrayList<Resident> getResidentOfJeddah() {
		return residentOfJeddah;
	}


	/**
	 * @param residentOfJeddah the residentOfJeddah to set
	 */
	public void setResidentOfJeddah(ArrayList<Resident> residentOfJeddah) {
		this.residentOfJeddah = residentOfJeddah;
	}


	public static Jeddah demolish(Jeddah d){
		Random rand = new Random();

		for (int i = 0; i < d.getDistrict().size(); i++){

			for(int j = 0; j < d.getDistrict().get(i).getBuildings().size(); j++){
				 d.getDistrict().get(i).getBuildings().get(j).setDemoslished(rand.nextBoolean());
			}

			for(int k = 0; k < d.getDistrict().get(i).getMasjids().size(); k++){
				 d.getDistrict().get(i).getMasjids().get(k).isdemolished(rand.nextBoolean());
			}

			for(int l = 0; l <  d.getDistrict().get(i).getSchools().size(); l++){
				 d.getDistrict().get(i).getSchools().get(l).setDemolished(rand.nextBoolean());
			}

		}

		return d;
	}



	/*
	 * @param ArrayList District
	 *
	 * This method return the table format where the result are displayed
	 */

	public static void printInfo(ArrayList<District> d){
		System.out.println("_______________________________________________________________________________________________________________________________________________________________________");
		System.out.println("DISTRICT\tNUM. OF BUILDING\t RESIDENT \tAVERAGE LIVING-COST\tPOPULATION-INDEX\tTRAFFIC-INDEX \t\tSTATUS");
		System.out.println("\t\t\t\t\tFAM | SINGLE\t\tSAR\t\t\t%\t\t\t%");
		System.out.println("________________________________________________________________________________________________________________________________________________________________________");

			int people =0;
			//String status = "";

		for(int i = 0; i < d.size(); i++){

			System.out.print("District " + (i+1));

			for(int j = 0; j < d.get(i).getBuildings().size(); j++){



				for(int k = 0; k < d.get(i).getBuildings().get(j).getResidents().size(); k++){

						people += d.get(i).getBuildings().get(j).getResidents().size();


				}

//				for(int l = 0; l < d.get(i).getBuildings().size(); l++){
//					if (d.get(i).getBuildings().get(l).isDemoslished() == true){
//						status = "active";
//						break;
//					}
//					else
//						status = "inactive";
//				}

			}
			System.out.print("\t\t" + d.get(i).getBuildings().size());
			System.out.print("\t\t" + people);
			System.out.print("\t\t\t" + d.get(i).getLivingCostPerMonth());
			System.out.print("\t\t\t" + d.get(i).getPopulationPercent());
			System.out.print("\t\t\t" + d.get(i).getTrafficPercent());
//			System.out.print("\t\t" + status);
			System.out.println();
		}
	}



	/*
	 * @param Jeddah Object
	 * used in calculating the moving of people
	 */
	public static ArrayList<District> move(Jeddah dst, Jeddah d) {

		Random r = new Random();

		ArrayList<Resident> people = new ArrayList<>();

		for (int m = 0; m < d.getDistrict().size(); m++){
			for(int n = 0; n < d.getDistrict().get(m).getBuildings().size(); n++){
				d.setResidentOfJeddah(d.getDistrict().get(m).getBuildings().get(n).getResidents());
			}

			people.addAll(d.getResidentOfJeddah());

			for(int i = 0; i < dst.getDistrict().size(); i++){

				for(int j = 0; j < dst.getDistrict().get(i).getBuildings().size(); j++){

					if(dst.getDistrict().get(i).getBuildings().get(j).isDemoslished() == true){

						for (int k = 0; k < dst.getDistrict().get(i).getBuildings().get(j).getResidents().size(); k++){

							dst.setResidentOfJeddah((dst.getDistrict().get(i).getBuildings().get(j).getResidents()));

						}
					}
				}

			}

			people.addAll(dst.getResidentOfJeddah());

			d.getDistrict().get(m).getBuildings().get(r.nextInt(d.getDistrict().get(m).getBuildings().size())).setResidents(people);
//			people.clear();
		}



////		for(int i = 0; i < dst.getDistrict().size(); i++){
////
////			for(int j = 0; j < dst.getDistrict().get(i).getBuildings().size(); j++){
////
////				if(dst.getDistrict().get(i).getBuildings().get(j).isDemoslished() == true){
////
////					for (int k = 0; k < dst.getDistrict().get(i).getBuildings().get(j).getResidents().size(); k++){
////
////						dst.setResidentOfJeddah((dst.getDistrict().get(i).getBuildings().get(j).getResidents()));
////
////					}
////				}
////			}
//
//
//
//
//
//		}

//		people.addAll(dst.getResidentOfJeddah());
//
//
//		for (int m = 0; m < d.getDistrict().size(); m++){
//			for(int n = 0; n < d.getDistrict().get(m).getBuildings().size(); n++){
//				d.setResidentOfJeddah(d.getDistrict().get(m).getBuildings().get(n).getResidents());
//			}
//
//			people.addAll(d.getResidentOfJeddah());
//
//			d.getDistrict().get(m).getBuildings().get(r.nextInt(d.getDistrict().get(m).getBuildings().size())).setResidents(people);
//
//		}
//
//		people.clear();


		//System.out.println(people);



		return d.getDistrict();

	}

	/*
	 * @param ArrayList<District>
	 *
	 * returns an ArrayList which recalculate the living cost as well as the traffic after movement
	 */

	public static ArrayList<District> recalculate(ArrayList<District> dct){

		 int sum = 0, sum1 = 0;
		 ArrayList<Family> fam = new ArrayList<>();
		 ArrayList<Single> sing = new ArrayList<>();

		 /*
		  * Because the Resident can either be a single or family
		  * there was need to check and separate them.
		  */

		 for (int f = 0; f < dct.size(); f++){
			 for(int g = 0; g < dct.get(f).getBuildings().size(); g++){
				 for(int i = 0; i < dct.get(f).getBuildings().get(g).getResidents().size(); i++){

		 if (dct.get(f).getBuildings().get(g).getResidents().get(i) instanceof Family){
			 		fam.add((Family) dct.get(f).getBuildings().get(g).getResidents().get(i));
		 }

		 else{
			 sing.add((Single)dct.get(f).getBuildings().get(g).getResidents().get(i));
		 }

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



			 dct.get(f).setLivingCostPerMonth((int)((sum + sum1)/dct.size()*100));
			 dct.get(f).setPopulationPercent(censor(dct.get(f).getBuildings())/100);
			 dct.get(f).setTrafficPercent(censor(dct.get(f).getBuildings())/500);
		 }




		return dct;

	}


	/*
	 * @param ArrayList of Building
	 *
	 * return a double which will represent an head count of the resident
	 * and it is used to calculate the population index and traffic index
	 */
	public static double censor(ArrayList<Building> b){

		 double headCount = 0;

		 for (int c = 0; c < b.size(); c++){
			 for(int d = 0; d < b.get(c).getResidents().size(); d++){
				 headCount +=  b.get(c).getResidents().get(d).numOfResident;
			 }
		 }


		 return headCount;
	 }


//	public static int livingCostPerMonth(){
//	return 0;
//}
//
//public static int totalIncomePerFamily(Family fam){
//
//	int sum = 0;
//	for (int i = 0; i < fam.geteFamilyMember().size(); i++ ){
//		sum += fam.geteFamilyMember().get(i).getSalary();
//	}
//
//	return sum;
//}

//	public static ArrayList<District> move_settle(ArrayList<District> d1, ArrayList<District> d2){
//
//		Random rand = new Random();
//
//		int b_flag = 0, m_flag = 0, s_flag = 0;
//		for (int i = 0; i < d1.size(); i++){
//			for(int j = 0; j < d1.get(i).getBuildings().size(); j++){
//				if(d1.get(i).getBuildings().get(j).isDemoslished() == true){
//
//					b_flag += d1.get(i).getBuildings().get(j).getResidents().size();
//					//jdh.setDistrict(jdh.getDistrict().get(i).setBuildings(jdh.getDistrict().get(i).getBuildings().add(jed.getDistrict().get(i).getBuildings().get(j).getResidents())));
//				}
//				int var = d2.get(i).getBuildings().size() - 2;
//				int var1 = d2.get(i).getBuildings().get(rand.nextInt(var)).getResidents().get(rand.nextInt(5)).getNumOfResident();
//				d2.get(i).getBuildings().get(rand.nextInt(var)).getResidents().get(rand.nextInt(5)).setNumOfResident(b_flag + var1);
//			}
//
//
//
//			for(int k = 0; k < d1.get(i).getMasjids().size(); k++){
//				if(d1.get(i).getMasjids().get(k).getdemolished() == true){
//					m_flag += 1;
//				}
//
//			}
//
//			for(int l = 0; l < d1.get(i).getSchools().size(); l++){
//				if(d1.get(i).getMasjids().get(l).getdemolished() == true){
//					s_flag += 1;
//				}
//			}
//
//
//		}
//
//		return d2;
//	}

//	public static int recalculate(){
//		return 0;
//
//		//Recalculate the living cost in the distict
//	}


}

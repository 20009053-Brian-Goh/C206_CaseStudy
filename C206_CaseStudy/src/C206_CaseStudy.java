import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;
	private static final int OPTION_TUITION_QUIT = 4;

	public static void main(String[] args) {

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();

		int option = 0;
		int optionTuition = 0;

		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				while (option != OPTION_TUITION_QUIT) {
					C206_CaseStudy.menuTuition();
					optionTuition = Helper.readInt("Enter an option > ");

					if (optionTuition == 1) {
						Tuition tt = inputTuition();
						C206_CaseStudy.addTuition(tuitionList, tt);

					} else if (optionTuition == 2) {
						C206_CaseStudy.viewAllTuition(tuitionList);

					} else if (optionTuition == 3) {

					} else if (optionTuition == OPTION_TUITION_QUIT) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 2) {

			} else if (option == 3) {

			} else if (option == 4) {

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Maintain Tuition");
		System.out.println("2. Registration of tuition timetable");
		System.out.println("3. Maintain Tuition Timetable");
		System.out.println("4. Maintain Student");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	public static void menuTuition() { //Brian
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Add tuition");
		System.out.println("2. View tuition");
		System.out.println("3. Delete tuition");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static Tuition inputTuition() { //Brian
		String ttCode = Helper.readString("Enter tuition code (must be unique) > ");
		String ttTitle = Helper.readString("Enter tuition title > ");
		String ttSGN = Helper.readString("Enter subject group name > ");
		String ttDesc = Helper.readString("Enter tuition description > ");
		int ttDur = Helper.readInt("Enter tuition duration > ");
		String ttPQ = Helper.readString("Enter pre-requisite > ");

		Tuition tt = new Tuition(ttCode, ttTitle, ttSGN, ttDesc, ttDur, ttPQ);
		return tt;

	}

	public static void addTuition(ArrayList<Tuition> tuitionList, Tuition tt) { //Brian

		tuitionList.add(tt);
		System.out.println("Tuition added");
	}

	public static String retrieveAllTuition(ArrayList<Tuition> tuitionList) { //Brian
		String output = "";

		for (int i = 0; i < tuitionList.size(); i++) {

			output += String.format("%-114s \n", tuitionList.get(i).toString());
		}
		return output;
	}

	public static void viewAllTuition(ArrayList<Tuition> tuitionList) { //Brian
		C206_CaseStudy.setHeader("Tuition List");
		String output = String.format("%-15s %-15s %-20s %-22s %-18s %-20s\n", "TUITION CODE", "TUITION TITLE",
				"SUBJECT GROUP NAME", "TUITION DESCRIPTION", "TUITION DURATION", "PRE-REQUISITE");
		output += retrieveAllTuition(tuitionList);
		System.out.println(output);
	}

	public static boolean doDeleteTuition(ArrayList<Tuition> tuitionList, String deleteCode) { //Brian
		boolean isFound = false;
		for (int i = 0; i < tuitionList.size(); i++) {
			String tuitionCode = tuitionList.get(i).getTuitionCode();
			if (deleteCode == tuitionCode) {
				tuitionList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void deleteTuition(ArrayList<Tuition> tuitionList) { //Brian
		C206_CaseStudy.viewAllTuition(tuitionList);
		String deleteCode = Helper.readString("Enter Tuition Code: ");
		boolean isFound = doDeleteTuition(tuitionList, deleteCode);

		if (isFound == false) {
			System.out.println("Invalid tuition code!");
		} else {
			System.out.println("The tuition code " + deleteCode + " has been deleted!");
		}
	}

}


import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<TuitionTimetable> tuitionTimetableList = new ArrayList<TuitionTimetable>();

		tuitionTimetableList.add(new TuitionTimetable(1, 100, "12", "13", "Mode 1"));
		tuitionTimetableList.add(new TuitionTimetable(2, 200, "13", "12", "Mode 2"));
		tuitionTimetableList.add(new TuitionTimetable(3, 300, "15", "14", "Mode 3"));

		int option = 0;
		int optionTimetable = 0;

		while (option != 5) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

			} else if (option == 2) {

			} else if (option == 3) { // Indra
				menuTimetable();
				optionTimetable = Helper.readInt("Enter an option > ");

				if (optionTimetable == 1) {
					TuitionTimetable tt = inputTimetable(tuitionTimetableList);
					checkAddTimetable(tuitionTimetableList, tt);
				} else if (optionTimetable == 2) {
					retrieveAllTimetable(tuitionTimetableList);
					viewAllTimetable(tuitionTimetableList);
				} else if (optionTimetable == 3) {
					checkDeleteTimetable(tuitionTimetableList);
				} else if (optionTimetable == 4) {
					searchTimetable(tuitionTimetableList);
				} else if (optionTimetable == 5) {
					updateTimetable(tuitionTimetableList);
				}

			} else if (option == 4) {

			} else if (option == 5) {
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

	public static void menuTimetable() { // Indra
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Add Tuition Timetable");
		System.out.println("2. View Tuition Timetable");
		System.out.println("3. Delete Tuition Timetable");
		System.out.println("4. Search Tuition Timetable");
		System.out.println("5. Update Tuition Timetable");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void menuUpdateTimetable() { // Indra
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Timetable ID");
		System.out.println("2. Price");
		System.out.println("3. Start Date/Time");
		System.out.println("4. End Date/Time");
		System.out.println("5. Mode");
		Helper.line(80, "-");
	}

	public static boolean checkAddTimetable(ArrayList<TuitionTimetable> tuitionTimetableList, int addID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < tuitionTimetableList.size(); i++) {
			int timetableID = tuitionTimetableList.get(i).getTimetableID();
			if (addID == timetableID) {
				isFound = true;
			}
		}
		return isFound;
	}

	public static TuitionTimetable inputTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		int timetableID = Helper.readInt("Enter timetable ID > ");
		double price = Helper.readDouble("Enter price > ");
		String startDateTime = Helper.readString("Enter start date/time > ");
		String endDateTime = Helper.readString("Enter end date/time > ");
		String mode = Helper.readString("Enter mode > ");

		TuitionTimetable tt = new TuitionTimetable(timetableID, price, startDateTime, endDateTime, mode);
		checkAddTimetable(timetableList, timetableID);
		return tt;

	}

	public static void checkAddTimetable(ArrayList<TuitionTimetable> timetableList, TuitionTimetable tt) {
		if (tt.getTimetableID() == 0 || tt.getPrice() == 0 || tt.getStartDateTime().isBlank()
				|| tt.getEndDateTime().isBlank() || tt.getMode().isBlank()) {
			timetableList.remove(tt);
			System.out.println("Timetable fields should not be left blank!");
		} else {
			addTimetable(timetableList, tt);
		}
	}

	public static void addTimetable(ArrayList<TuitionTimetable> timetableList, TuitionTimetable tt) { // Indra
		timetableList.add(tt);
		System.out.println("Timetable added!");
	}

	public static String retrieveAllTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		String output = "";

		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-30s %-20s %-30s %-30s %-30s\n", timetableList.get(i).getTimetableID(),
					timetableList.get(i).getPrice(), timetableList.get(i).getStartDateTime(),
					timetableList.get(i).getEndDateTime(), timetableList.get(i).getMode());
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-30s %-20s %-30s %-30s %-30s\n", "Timetable ID", "Price", "Start Date/Time",
				"End Date/Timee", "Mode");
		output += retrieveAllTimetable(timetableList);
		System.out.println(output);
	}

	public static boolean deleteTimetable(ArrayList<TuitionTimetable> timetableList, int deleteID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			int timetableID = timetableList.get(i).getTimetableID();
			if (deleteID == timetableID) {
				timetableList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void checkDeleteTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		C206_CaseStudy.retrieveAllTimetable(timetableList);
		int deleteID = Helper.readInt("Enter Timetable ID to delete > ");
		boolean isFound = deleteTimetable(timetableList, deleteID);

		if (isFound == false) {
			System.out.println("Invalid timetable ID!");
		} else {
			System.out.println("The timetable with the ID, " + deleteID + " has been deleted!");
		}
	}

	public static void searchTimetable(ArrayList<TuitionTimetable> timetableList) {
		String output = "";
		int timetableID = Helper.readInt("Enter Timetable ID to search for > ");

		for (int i = 0; i < timetableList.size(); i++) {
			if (timetableList.get(i).getTimetableID() == timetableID) {
				output += String.format("%-30s %-20s %-30s %-30s %-30s\n", timetableList.get(i).getTimetableID(),
						timetableList.get(i).getPrice(), timetableList.get(i).getStartDateTime(),
						timetableList.get(i).getEndDateTime(), timetableList.get(i).getMode());

				System.out.println(output);
			}
		}
	}

	public static void updateTimetable(ArrayList<TuitionTimetable> timetableList) {
		int updateID = Helper.readInt("Enter Timetable ID to update > ");
		menuUpdateTimetable();
		int updateOption = Helper.readInt("Enter detail to update > ");

		for (int i = 0; i < timetableList.size(); i++) {
			if (timetableList.get(i).getTimetableID() == updateID) {
				if (updateOption == 1) {
					int newTimetableID = Helper.readInt("Enter new Timetable ID > ");
					timetableList.get(i).setTimetableID(newTimetableID);
				} else if (updateOption == 2) {
					int newPrice = Helper.readInt("Enter new Price > ");
					timetableList.get(i).setTimetableID(newPrice);
				} else if (updateOption == 3) {
					int newStartDateTime = Helper.readInt("Enter new Start Date/Time > ");
					timetableList.get(i).setTimetableID(newStartDateTime);
				} else if (updateOption == 4) {
					int newEndDateTime = Helper.readInt("Enter new End Date/Time > ");
					timetableList.get(i).setTimetableID(newEndDateTime);
				} else if (updateOption == 5) {
					int newMode = Helper.readInt("Enter new Mode > ");
					timetableList.get(i).setTimetableID(newMode);
				}
			}

		}

	}

}

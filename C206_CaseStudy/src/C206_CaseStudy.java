import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<TuitionTimetable> tuitionTimetableList = new ArrayList<TuitionTimetable>();

		tuitionTimetableList.add(new TuitionTimetable(1, 100, "12", "13", "Mode 1", "Open"));
		tuitionTimetableList.add(new TuitionTimetable(2, 200, "13", "12", "Mode 2", "Open"));
		tuitionTimetableList.add(new TuitionTimetable(3, 300, "15", "14", "Mode 3", "Open"));

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
					addTimetable(tuitionTimetableList, tt);
				} else if (optionTimetable == 2) {
					retrieveAllTimetable(tuitionTimetableList);
					viewAllTimetable(tuitionTimetableList);
				} else if (optionTimetable == 3) {
					deleteTimetable(tuitionTimetableList);
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

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
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

	public static void menuUpdateTimetable() { // Indra
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Timetable ID");
		System.out.println("2. Price");
		System.out.println("3. Start Date/Time");
		System.out.println("4. End Date/Time");
		System.out.println("5. Mode");
		System.out.println("6. Status");
		Helper.line(80, "-");
	}

	public static TuitionTimetable inputTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		int timetableID = Helper.readInt("Enter timetable ID > ");
		double price = Helper.readDouble("Enter price > ");
		String startDateTime = Helper.readString("Enter start date/time > ");
		String endDateTime = Helper.readString("Enter end date/time > ");
		String mode = Helper.readString("Enter mode > ");
		String status = Helper.readString("Enter status > ");

		TuitionTimetable tt = new TuitionTimetable(timetableID, price, startDateTime, endDateTime, mode, status);
		return tt;

	}

	public static boolean checkBlankSpaces(ArrayList<TuitionTimetable> tuitionTimetableList, TuitionTimetable tt) { // Indra
		boolean isFound = false;

		if (tt.getTimetableID() == 0 || tt.getPrice() == 0 || tt.getStartDateTime().isBlank()
				|| tt.getEndDateTime().isBlank() || tt.getMode().isBlank() || tt.getStatus().isBlank()) {
			isFound = true;
		}

		return isFound;
	}

	public static boolean checkAddID(ArrayList<TuitionTimetable> tuitionTimetableList, int addID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < tuitionTimetableList.size(); i++) {
			int timetableID = tuitionTimetableList.get(i).getTimetableID();
			if (addID == timetableID) {
				isFound = true;
			}
		}
		return isFound;
	}

	public static void addTimetable(ArrayList<TuitionTimetable> timetableList, TuitionTimetable tt) { // Indra
		boolean x = checkAddID(timetableList, tt.getTimetableID());
		boolean y = checkBlankSpaces(timetableList, tt);

		if (x == true) {
			timetableList.remove(tt);
			System.out.println(tt.getTimetableID() + " already exists!");
		} else if (y == true) {
			timetableList.remove(tt);
			System.out.println("Timetable fields should not be left blank!");
		} else {
			timetableList.add(tt);
			System.out.println("Timetable added!");
		}
	}

	public static String retrieveAllTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		String output = "";

		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-30s %-20s %-30s %-30s %-20s %-15s\n", timetableList.get(i).getTimetableID(),
					timetableList.get(i).getPrice(), timetableList.get(i).getStartDateTime(),
					timetableList.get(i).getEndDateTime(), timetableList.get(i).getMode(),
					timetableList.get(i).getStatus());
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-30s %-20s %-30s %-30s %-20s %-15s\n", "Timetable ID", "Price",
				"Start Date/Time", "End Date/Timee", "Mode", "Status");
		output += retrieveAllTimetable(timetableList);
		System.out.println(output);
	}

	public static boolean checkDeleteID(ArrayList<TuitionTimetable> timetableList, int deleteID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			int timetableID = timetableList.get(i).getTimetableID();
			if (deleteID == timetableID) {
				isFound = true;
				timetableList.remove(i);
			}
		}
		return isFound;
	}

	public static void deleteTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		C206_CaseStudy.retrieveAllTimetable(timetableList);
		viewAllTimetable(timetableList);
		int deleteID = Helper.readInt("Enter Timetable ID to delete > ");
		boolean isFound = checkDeleteID(timetableList, deleteID);

		if (isFound == true) {
			System.out.println("The timetable with the ID, " + deleteID + " has been deleted!");
		} else {
			System.out.println("Invalid timetable ID!");
		}
	}

	public static boolean checkSearchID(ArrayList<TuitionTimetable> timetableList, int searchID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			int timetableID = timetableList.get(i).getTimetableID();
			if (searchID == timetableID) {
				isFound = true;
			}
		}
		return isFound;
	}

	public static void searchTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		String output = "";
		int timetableID = Helper.readInt("Enter Timetable ID to search for > ");
		boolean x = checkSearchID(timetableList, timetableID);

		if (x == true) {
			for (int i = 0; i < timetableList.size(); i++) {
				if (timetableList.get(i).getTimetableID() == timetableID) {
					output += String.format("%-30s %-20s %-30s %-30s %-20s %-15s\n", "Timetable ID", "Price",
							"Start Date/Time", "End Date/Timee", "Mode", "Status");
					output += String.format("%-30s %-20s %-30s %-30s %-20s %-15s\n",
							timetableList.get(i).getTimetableID(), timetableList.get(i).getPrice(),
							timetableList.get(i).getStartDateTime(), timetableList.get(i).getEndDateTime(),
							timetableList.get(i).getMode(), timetableList.get(i).getStatus());

					System.out.println(output);
				}
			}
		} else {
			System.out.println("Invalid timetable ID!");
		}
	}

	public static boolean checkUpdateID(ArrayList<TuitionTimetable> timetableList, int updateID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			int timetableID = timetableList.get(i).getTimetableID();
			if (updateID == timetableID) {
				isFound = true;
			}
		}
		return isFound;
	}

	public static void updateTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		viewAllTimetable(timetableList);
		int updateID = Helper.readInt("Enter Timetable ID to update > ");
		menuUpdateTimetable();
		int updateOption = Helper.readInt("Enter detail to update > ");
		boolean x = checkUpdateID(timetableList, updateID);

		if (x == true) {
			switch (updateOption) {
			case 1:
				int newTimetableID = Helper.readInt("Enter new Timetable ID > ");
				timetableList.get(updateOption).setTimetableID(newTimetableID);
				System.out.println("Timetable ID Successfully Updated!");
				break;
			case 2:
				double newPrice = Helper.readInt("Enter new Price > ");
				timetableList.get(updateOption).setPrice(newPrice);
				System.out.println("Price Successfully Updated!");
				break;
			case 3:
				String newStartDateTime = Helper.readString("Enter new Start Date/Time > ");
				timetableList.get(updateOption).setStartDateTime(newStartDateTime);
				System.out.println("Start Date/Time Successfully Updated!");
				break;
			case 4:
				String newEndDateTime = Helper.readString("Enter new End Date/Time > ");
				timetableList.get(updateOption).setEndDateTime(newEndDateTime);
				System.out.println("End Date/Time Successfully Updated!");
				break;
			case 5:
				String newMode = Helper.readString("Enter new Mode > ");
				timetableList.get(updateOption).setMode(newMode);
				System.out.println("Mode Successfully Updated!");
				break;
			case 6:
				String newStatus = Helper.readString("Enter new Status > ");
				timetableList.get(updateOption).setStatus(newStatus);
				System.out.println("Status Successfully Updated!");
				break;
			case 7:
				System.out.println("Invalid option!");
			}

		} else {
			System.out.println("Invalid Timetable ID!");
		}
	}
}

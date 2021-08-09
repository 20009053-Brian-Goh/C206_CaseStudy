
/**
 * 
 */

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * indra(20012784), 4 Aug 2021 4:34:10 pm
 */
import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int UPDATE_TIMETABLE = 5;
	private static final int SEARCH_TIMETABLE = 4;
	private static final int DELETE_TIMETABLE = 3;
	private static final int VIEW_TIMETABLE = 2;
	private static final int ADD_TIMETABLE = 1;
	private static final int TUITION_TIMETABLE = 3;
	private static final int QUIT_PROGRAM = 5;

	public static void main(String[] args) {

		ArrayList<TuitionTimetable> tuitionTimetableList = new ArrayList<TuitionTimetable>();

		tuitionTimetableList.add(new TuitionTimetable("First", 1, 100, "12", "13", "Mode 1", "Open"));
		tuitionTimetableList.add(new TuitionTimetable("Second", 2, 200.0, "13", "12", "Mode 2", "Open"));
		tuitionTimetableList.add(new TuitionTimetable("Third", 3, 300.0, "15", "14", "Mode 3", "Open"));

		int option = 0;
		int optionTimetable = 0;

		while (option != QUIT_PROGRAM) {
			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {

			} else if (option == 2) {

			} else if (option == TUITION_TIMETABLE) { // Indra
				menuTimetable();
				optionTimetable = Helper.readInt("Enter an option > ");

				if (optionTimetable == ADD_TIMETABLE) {
					TuitionTimetable tt = inputTimetable(tuitionTimetableList);
					addTimetable(tuitionTimetableList, tt);
				} else if (optionTimetable == VIEW_TIMETABLE) {
					retrieveAllTimetable(tuitionTimetableList);
					viewAllTimetable(tuitionTimetableList);
				} else if (optionTimetable == DELETE_TIMETABLE) {
					deleteTimetable(tuitionTimetableList);
				} else if (optionTimetable == SEARCH_TIMETABLE) {
					searchTimetable(tuitionTimetableList);
				} else if (optionTimetable == UPDATE_TIMETABLE) {
					updateTimetable(tuitionTimetableList);
				} else {
					System.out.println("Invalid option!");
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

	public static void menuSearchTimetable() { // Indra
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Search by title");
		System.out.println("2. Search by price");
	}

	public static TuitionTimetable inputTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		String title = Helper.readString("Enter title > ");
		int timetableID = Helper.readInt("Enter timetable ID > ");
		double price = Helper.readDouble("Enter price > ");
		String startDateTime = Helper.readString("Enter start date/time > ");
		String endDateTime = Helper.readString("Enter end date/time > ");
		String mode = Helper.readString("Enter mode > ");
		String status = Helper.readString("Enter status > ");

		TuitionTimetable tt = new TuitionTimetable(title, timetableID, price, startDateTime, endDateTime, mode, status);
		return tt;

	}

	public static boolean checkBlankSpaces(ArrayList<TuitionTimetable> tuitionTimetableList, TuitionTimetable tt) { // Indra
		boolean isFound = false;

		if (tt.getTitle().isBlank() || tt.getTimetableID() == 0 || tt.getPrice() == 0 || tt.getStartDateTime().isBlank()
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

			output += String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", timetableList.get(i).getTitle(),
					timetableList.get(i).getTimetableID(), timetableList.get(i).getPrice(),
					timetableList.get(i).getStartDateTime(), timetableList.get(i).getEndDateTime(),
					timetableList.get(i).getMode(), timetableList.get(i).getStatus());
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "Title", "Timetable ID", "Price",
				"Start Date/Time", "End Date/Timee", "Mode", "Status");
		output += retrieveAllTimetable(timetableList);
		System.out.println(output);
	}

	public static boolean checkDeleteID(ArrayList<TuitionTimetable> timetableList, int deleteID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			int timetableID = timetableList.get(i).getTimetableID();
			String status = timetableList.get(i).getStatus();
			if (deleteID == timetableID && status.equalsIgnoreCase("open")) {
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
			System.out.println("The timetable with the ID, " + deleteID + " cannot be deleted!");
		}
	}

	public static boolean checkSearchTitle(ArrayList<TuitionTimetable> timetableList, String searchTitle) {
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			String title = timetableList.get(i).getTitle();
			if (searchTitle.equalsIgnoreCase(title)) {
				isFound = true;
			}
		}
		return isFound;
	}

	public static boolean checkSearchPrice(ArrayList<TuitionTimetable> timetableList, double searchPrice) {
		boolean isFound = false;

		for (int i = 0; i < timetableList.size(); i++) {
			double price = timetableList.get(i).getPrice();
			if (searchPrice == price) {
				isFound = true;
			}
		}
		return isFound;
	}

	public static void searchTimetable(ArrayList<TuitionTimetable> timetableList) { // Indra
		String output = "";
		menuSearchTimetable();
		int option = Helper.readInt("Enter option > ");

		if (option == 1) {
			String title = Helper.readString("Enter title > ");
			boolean x = checkSearchTitle(timetableList, title);
			if (x == true) {
				for (int i = 0; i < timetableList.size(); i++) {
					if (title.equalsIgnoreCase(timetableList.get(i).getTitle())) {
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
				System.out.println("Invalid Title!");
			}
		}

		else if (option == 2) {
			Double price = Helper.readDouble("Enter price > ");
			boolean x = checkSearchPrice(timetableList, price);
			if (x == true) {
				for (int i = 0; i < timetableList.size(); i++) {
					if (price == timetableList.get(i).getPrice()) {
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
				System.out.println("Invalid Price!");
			}
		}

		else {
			System.out.println("Invalid option!");
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
		boolean x = checkUpdateID(timetableList, updateID);

		if (x == true) {
			for (int i = 0; i < timetableList.size(); i++) {
				if (timetableList.get(i).getTimetableID() == updateID) {
					String newStatus = Helper.readString("Enter new status > ");
					timetableList.get(i).setStatus(newStatus);
					System.out.println("Status successfully updated!");
				}
			}
		} else {
			System.out.println("Invalid Timetable ID!");
		}
	}
}

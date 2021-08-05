
import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {

		ArrayList<TuitionTimetable> tuitionTimetableList = new ArrayList<TuitionTimetable>();

		tuitionTimetableList.add(new TuitionTimetable(1, 100, "12", "13", "idktfisthis"));

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
					checkDeleteTimetable(tuitionTimetableList);
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
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
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
		checkAddTimetable(timetableList, timetableID);

		double price = Helper.readDouble("Enter price > ");
		String startDateTime = Helper.readString("Enter start date/time > ");
		String endDateTime = Helper.readString("Enter end date/time > ");
		String mode = Helper.readString("Enter mode > ");

		TuitionTimetable tt = new TuitionTimetable(timetableID, price, startDateTime, endDateTime, mode);
		return tt;

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

	public static boolean deleteTimetable(ArrayList<TuitionTimetable> tuitionTimetableList, int deleteID) { // Indra
		boolean isFound = false;

		for (int i = 0; i < tuitionTimetableList.size(); i++) {
			int timetableID = tuitionTimetableList.get(i).getTimetableID();
			if (deleteID == timetableID) {
				tuitionTimetableList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void checkDeleteTimetable(ArrayList<TuitionTimetable> tuitionList) { // Indra
		C206_CaseStudy.retrieveAllTimetable(tuitionList);
		int deleteID = Helper.readInt("Enter Timetable ID to delete > ");
		boolean isFound = deleteTimetable(tuitionList, deleteID);

		if (isFound == false) {
			System.out.println("Invalid timetable ID!");
		} else {
			System.out.println("The timetable with the ID, " + deleteID + " has been deleted!");
		}
	}

}

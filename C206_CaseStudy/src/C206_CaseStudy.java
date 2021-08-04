import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int ADD_ITEMS = 1;
	private static final int VIEW_ITEMS = 2;
	private static final int DELETE_ITEMS = 3;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<TuitionTimetable> tuitionTimetableList = new ArrayList<TuitionTimetable>();

		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == ADD_ITEMS) {

			}

			else if (option == VIEW_ITEMS) {

			}

			else if (option == DELETE_ITEMS) {

			}

			else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			}

			else {
				System.out.println("Invalid option");
			}

		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Add Tuition Timetable");
		System.out.println("2. View Tuition Timetable");
		System.out.println("3. Delete Tuition Timetable");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1 View (CRUD - Read)
	// =================================
	public static String retrieveAllTimetable(ArrayList<TuitionTimetable> timetableList) {
		String output = "";

		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-84s \n", timetableList.get(i).toString());
		}
		return output;
	}

	public static void viewAllTimetable(ArrayList<TuitionTimetable> timetableList) {
		C206_CaseStudy.setHeader("Tuition Timetable LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION", "AVAILABLE",
				"DUE DATE", "OPTICAL ZOOM");
		output += retrieveAllTimetable(timetableList);
		System.out.println(output);
	}

}

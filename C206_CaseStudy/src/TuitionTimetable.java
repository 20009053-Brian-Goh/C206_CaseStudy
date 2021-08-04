/**
 * 
 */

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * indra, 4 Aug 2021 4:34:10 pm
 */
public class TuitionTimetable {
	private int timetableID;
	private double price;
	private String startDateTime;
	private String endDateTime;
	private String mode;

	public TuitionTimetable(int timetableID, double price, String startDateTime, String endDateTime, String mode) {
		this.setTimetableID(timetableID);
		this.setPrice(price);
		this.setStartDateTime(startDateTime);
		this.setEndDateTime(endDateTime);
		this.setMode(mode);
	}

	public int getTimetableID() {
		return timetableID;
	}

	public void setTimetableID(int newTimetableID) {
		this.timetableID = newTimetableID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String newStartDateTime) {
		this.startDateTime = newStartDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String newEndDateTime) {
		this.endDateTime = newEndDateTime;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String newMode) {
		this.mode = newMode;
	}

}

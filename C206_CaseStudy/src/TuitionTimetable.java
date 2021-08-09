/**
 * 
 */

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * indra(20012784), 4 Aug 2021 4:34:10 pm
 */
public class TuitionTimetable { // Indra
	private String title;
	private int timetableID;
	private double price;
	private String startDateTime;
	private String endDateTime;
	private String mode;
	private String status;

	public TuitionTimetable(String title, int timetableID, double price, String startDateTime, String endDateTime,
			String mode, String status) { // Indra
		this.title = title;
		this.timetableID = timetableID;
		this.price = price;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.mode = mode;
		this.status = "Open";
	}

	public int getTimetableID() { // Indra
		return timetableID;
	}

	public void setTimetableID(int newTimetableID) { // Indra
		this.timetableID = newTimetableID;
	}

	public double getPrice() { // Indra
		return price;
	}

	public void setPrice(double newPrice) { // Indra
		this.price = newPrice;
	}

	public String getStartDateTime() { // Indra
		return startDateTime;
	}

	public void setStartDateTime(String newStartDateTime) { // Indra
		this.startDateTime = newStartDateTime;
	}

	public String getEndDateTime() { // Indra
		return endDateTime;
	}

	public void setEndDateTime(String newEndDateTime) { // Indra
		this.endDateTime = newEndDateTime;
	}

	public String getMode() { // Indra
		return mode;
	}

	public void setMode(String newMode) { // Indra
		this.mode = newMode;
	}

	public String getStatus() { // Indra
		return status;
	}

	public void setStatus(String newStatus) { // Indra
		this.status = newStatus;
	}

	public String getTitle() { // Indra
		return title;
	}

	public void setTitle(String newTitle) { // Indra
		this.title = newTitle;
	}

}

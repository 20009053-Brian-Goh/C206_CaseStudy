
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20013238, 9 Aug 2021 10:04:46 pm
 */

public class Registration {
	private int regNo;
	private int ttid;
	private String email;
	private String status;
	private String acknowledgement;
	private String datetime;
	private int regID;

	public Registration(int regNo, int ttid, String email, String status, String acknowledgement, String datetime,
			int regID) {
		this.regNo = regNo;
		this.ttid = ttid;
		this.email = email;
		this.status = "Pending";
		this.datetime = datetime;
		this.acknowledgement = acknowledgement;
		this.regID = regID;
	}

	public String toString() {

		String regdetails = String.format("%-18s %-18s %-30s %-10s %-25s %-25s %-10s", String.valueOf(regNo),
				String.valueOf(ttid), email, status, datetime, acknowledgement, String.valueOf(regID));
		return regdetails;
	}

	public String getAcknowledgement() {
		return acknowledgement;
	}

	public String getStatus() {
		return status;
	}

	public int getRegNo() {
		return regNo;
	}

	public int getTtid() {
		return ttid;
	}

	public String getEmail() {
		return email;
	}

	public String getDatetime() {
		return datetime;
	}

	public int getRegID() {
		return regID;
	}

}

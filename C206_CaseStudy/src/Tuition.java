
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * brain, 4 Aug 2021 4:52:58 pm
 */
public class Tuition {
	
	private String tuitionCode;
	private String tuitionTitle;
	private String subjectGroupName;
	private String tuitionDescription;
	private int tuitionDuration;
	private String prerequisite;
	
	public Tuition(String tuitionCode, String tuitionTitle, String subjectGroupName, String tuitionDescription, int tuitionDuration,
			String prerequisite) {
		this.tuitionCode = tuitionCode;
		this.tuitionTitle = tuitionTitle;
		this.subjectGroupName = subjectGroupName;
		this.tuitionDescription = tuitionDescription;
		this.tuitionDuration = tuitionDuration;
		this.prerequisite = prerequisite;
	}
	
	public String toString() {

		String tuitionInfo = String.format("%-15s %-15s %-20s %-22s %-18s %-20s", tuitionCode, tuitionTitle, subjectGroupName, tuitionDescription, String.valueOf(tuitionDuration), prerequisite);
		return tuitionInfo;
	}

	public String getTuitionCode() {
		return tuitionCode;
	}

	public String getTuitionTitle() {
		return tuitionTitle;
	}

	public String getSubjectGroupName() {
		return subjectGroupName;
	}

	public String getTuitionDescription() {
		return tuitionDescription;
	}

	public int getTuitionDuration() {
		return tuitionDuration;
	}

	public String getPrerequisite() {
		return prerequisite;
	}
	
}

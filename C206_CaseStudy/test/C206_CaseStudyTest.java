import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private TuitionTimetable tt1;
	private TuitionTimetable tt2;
	private TuitionTimetable tt3;

	private ArrayList<TuitionTimetable> timetableList;

	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception { // Indra
		// prepare test data

		tt1 = new TuitionTimetable("First", 1, 100, "12", "13", "Mode 1", "Open");
		tt2 = new TuitionTimetable("Second", 2, 200.0, "13", "12", "Mode 2", "Open");
		tt3 = new TuitionTimetable("Third", 3, 300.0, "15", "14", "Mode 3", "Open");

		timetableList = new ArrayList<TuitionTimetable>();
	}

	@Test
	public void addTuitionTimetableTest() { // Indra
		// Test that timetable list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Timetable arraylist to add to", timetableList);

		// Given an empty timetable list, test that after adding 1 timetable, the size
		// of the list is 1 - normal
		// Test that the timetable just added is as same as the first timetable of the
		// list
		C206_CaseStudy.addTimetable(timetableList, tt1);
		assertEquals("Check that Timetable arraylist size is 1", 1, timetableList.size());
		assertSame("Check that Timetable is added", tt1, timetableList.get(0));

		// Add another timetable. Test that the size of the list is 2 -normal
		// Test that the timetable just added is as same as the second timetable of the
		// list
		C206_CaseStudy.addTimetable(timetableList, tt2);
		assertEquals("Check that Timetable arraylist size is 2", 2, timetableList.size());
		assertSame("Check that Timetable is added", tt2, timetableList.get(1));
	}

	@Test
	public void retrieveAllTimetableTest() { // Indra
		// Test that timetable list is not null, so that can retrieve a new item -
		// boundary
		assertNotNull("Test if there is a valid Timetable arraylist to retrieve timetable", timetableList);

		// Test that if the list of timetables retrieved from the SourceCentre is empty
		// - boundary
		String allTimetable = C206_CaseStudy.retrieveAllTimetable(timetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetablelist", testOutput, allTimetable);

		// Given an empty timetable list, after adding 2 timetable, test if the size of
		// the list is 2 - normal
		C206_CaseStudy.addTimetable(timetableList, tt1);
		C206_CaseStudy.addTimetable(timetableList, tt2);
		assertEquals("Test that Timetable arraylist size is 2", 2, timetableList.size());

		// Test if the expected output string same as the list of timetables retrieved
		// from the C206_CaseStudy.
		C206_CaseStudy.addTimetable(timetableList, tt3);

		allTimetable = C206_CaseStudy.retrieveAllTimetable(timetableList);
		testOutput = String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "First", 1, 100.0, "12", "13",
				"Mode 1", "Open");
		testOutput += String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "Second", 2, 200.0, "13", "12",
				"Mode 2", "Open");
		testOutput += String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "Third", 3, 300.0, "15", "14",
				"Mode 3", "Open");
		assertEquals("Test that ViewAllTimetablelist", testOutput, allTimetable);

	}

	@Test
	public void deleteTuitionTimetableTest() { // Indra
		C206_CaseStudy.addTimetable(timetableList, tt1);
		C206_CaseStudy.addTimetable(timetableList, tt2);
		C206_CaseStudy.addTimetable(timetableList, tt3);

		// Make sure list is not null -Boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve item", timetableList);

		// Test if Timetable ID can be removed -Normal
		C206_CaseStudy.addTimetable(timetableList, tt1);
		Boolean results = C206_CaseStudy.checkDeleteID(timetableList, 1);
		assertTrue("Test if Tuition is ok to be deleted?", results);

		// Test if the same Timetable ID can be removed again -Error
		results = C206_CaseStudy.checkDeleteID(timetableList, 1);
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", results);

		// Test if Timetable ID can be removed -Normal
		C206_CaseStudy.addTimetable(timetableList, tt2);
		results = C206_CaseStudy.checkDeleteID(timetableList, 2);
		assertTrue("Test if a Tuition is ok to be deleted?", results);

		// Test if the same Timetable ID can be removed again -Error
		results = C206_CaseStudy.checkDeleteID(timetableList, 2);
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", results);

		// Test if Timetable ID can be removed -Normal
		C206_CaseStudy.addTimetable(timetableList, tt3);
		results = C206_CaseStudy.checkDeleteID(timetableList, 3);
		assertTrue("Test if a Tuition is ok to be deleted?", results);

		// Test if the same Timetable ID can be removed again -Error
		results = C206_CaseStudy.checkDeleteID(timetableList, 3);
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", results);

		// Test if Timetable list size has dropped to 0 after removing the 3 timetables
		// -Normal
		assertEquals("Check that tuition list is not bigger than 0", 0, timetableList.size());
	}

	@Test
	public void searchTuitionTimetableTest() { // Indra
		C206_CaseStudy.addTimetable(timetableList, tt1);
		C206_CaseStudy.addTimetable(timetableList, tt2);
		C206_CaseStudy.addTimetable(timetableList, tt3);

		// Make sure list is not null -Boundary
		assertNotNull("Test if there is valid Tuition arraylist to search item", timetableList);

		// Test that a false value is returned when a non-existing price is keyed in -
		// normal
		double testPrice = 500.0;

		boolean results = C206_CaseStudy.checkSearchPrice(timetableList, testPrice);
		assertFalse("Test if input price exists in timetable list", results);

		// Test that a true value is returned when an existing price is keyed in -
		// normal
		double testPrice2 = 100.0;

		boolean results2 = C206_CaseStudy.checkSearchPrice(timetableList, testPrice2);
		assertTrue("Test if input price exists in timetable list", results2);

		// Test that a false value is returned when a non-existing title is keyed in -
		// normal
		String testTitle2 = "RANDOM";

		boolean results3 = C206_CaseStudy.checkSearchTitle(timetableList, testTitle2);
		assertFalse("Test if input exists in timetable list", results3);

		// Test that a true value is returned when an existing title is keyed in -
		// normal
		String testTitle = "First";

		boolean results4 = C206_CaseStudy.checkSearchTitle(timetableList, testTitle);
		assertTrue("Test if input exists in timetable list", results4);

	}

	@Test
	public void updateTuitionTimetableTest() { // Indra
		C206_CaseStudy.addTimetable(timetableList, tt1);
		C206_CaseStudy.addTimetable(timetableList, tt2);
		C206_CaseStudy.addTimetable(timetableList, tt3);

		// Make sure list is not null -Boundary
		assertNotNull("Test if there is valid Tuition arraylist to update item", timetableList);

		// Test that a false value is returned when a non-existent timetable ID is keyed
		// in - normal
		int testTimetableID = 10;
		boolean results = C206_CaseStudy.checkUpdateID(timetableList, testTimetableID);
		assertFalse("Test if timetable ID exists in timetable list", results);

		// Test that a true value is returned when an existent timetable ID is keyed in
		// - normal
		int testTimetableID2 = 1;
		boolean results2 = C206_CaseStudy.checkUpdateID(timetableList, testTimetableID2);
		assertTrue("Test if timetable ID exists in timetable list", results2);

		// Test that updated status is reflected in timetable list - normal
		String testOutput = String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "First", 1, 100.0, "12", "13",
				"Mode 1", "Close");
		testOutput += String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "Second", 2, 200.0, "13", "12",
				"Mode 2", "Open");
		testOutput += String.format("%-30s %-30s %-20s %-30s %-30s %-20s %-15s\n", "Third", 3, 300.0, "15", "14",
				"Mode 3", "Open");

		C206_CaseStudy.updateTimetable(timetableList);
		String allTimetable = C206_CaseStudy.retrieveAllTimetable(timetableList);
		assertEquals("Test if updated title is reflecteed in the timetableList", testOutput, allTimetable);

	}

	@After
	public void tearDown() throws Exception { // Indra
		tt1 = null;
		tt2 = null;
		tt3 = null;

		timetableList = null;
	}
}

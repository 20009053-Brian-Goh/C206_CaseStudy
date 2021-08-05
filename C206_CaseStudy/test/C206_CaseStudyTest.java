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

	@Before
	public void setUp() throws Exception { 
		// prepare test data

		tt1 = new TuitionTimetable(1, 100, "12", "13", "idkWTFisthis");
		tt2 = new TuitionTimetable(2, 200, "13", "12", "stilldkWTFdis");
		tt3 = new TuitionTimetable(3, 300, "15", "14", "SIMILANJIO");

		timetableList = new ArrayList<TuitionTimetable>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void addTuitionTimetable() { // Indra
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Timetable arraylist to add to", timetableList);
		
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTimetable(timetableList, tt1);
		assertEquals("Check that Timetable arraylist size is 1", 1, timetableList.size());
		assertSame("Check that Timetableis added", tt1, timetableList.get(0));

		// Add another item. test The size of the list is 2? -normal
		// The item just added is as same as the second item of the list
		C206_CaseStudy.addTimetable(timetableList, tt2);
		assertEquals("Check that Timetable arraylist size is 2", 2, timetableList.size());
		assertSame("Check that Timetable is added", tt2, timetableList.get(1));
	}

	@Test
	public void retrieveAllTimetableTest() { // Indra
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Timetable arraylist to retrieve item", timetableList);

		// test if the list of timetables retrieved from the SourceCentre is empty -
		// boundary
		String allTimetable = C206_CaseStudy.retrieveAllTimetable(timetableList);
		String testOutput = "";
		assertEquals("Check that ViewAllTimetablelist", testOutput, allTimetable);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addTimetable(timetableList, tt1);
		C206_CaseStudy.addTimetable(timetableList, tt2);
		assertEquals("Test that Timetable arraylist size is 2", 2, timetableList.size());

		// test if the expected output string same as the list of timetables retrieved
		// from the SourceCentre
		allTimetable = C206_CaseStudy.retrieveAllTimetable(timetableList);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n", 1, 100, "12", "13", "idkWTFisthis");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n", 2, 200, "13", "12", "stilldkWTFdis");

		assertEquals("Test that ViewAllTimetablelist", testOutput, allTimetable);

	}

	@Test
	public void doDeleteTuitionTest() // Indra
	{
		// Make sure list is not null -Boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve item", timetableList);

		// Test if Tuition Code can be removed -Normal
		C206_CaseStudy.addTimetable(timetableList, tt1);
		Boolean ok = C206_CaseStudy.deleteTimetable(timetableList, 1);
		assertTrue("Test if Tuition is ok to be deleted?", ok);

		// Test if same Tuition Code can be removed again -Error
		ok = C206_CaseStudy.deleteTimetable(timetableList, 1);
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", ok);

		// Test if Tuition Code can be removed -Normal
		C206_CaseStudy.addTimetable(timetableList, tt2);
		ok = C206_CaseStudy.deleteTimetable(timetableList, 2);
		assertTrue("Test if a Tuition is ok to be deleted?", ok);

		// Test if same Tuition can be removed again -Error
		ok = C206_CaseStudy.deleteTimetable(timetableList, 2);
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", ok);

		// Test if Tuition Code can be removed -Normal
		C206_CaseStudy.addTimetable(timetableList, tt3);
		ok = C206_CaseStudy.deleteTimetable(timetableList, 3);
		assertTrue("Test if a Tuition is ok to be deleted?", ok);

		// Test if same Tuition Code can be removed again -Error
		ok = C206_CaseStudy.deleteTimetable(timetableList, 3);
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", ok);

		// Test if Tuition list size has dropped to 0 after removing the 3 test items
		// -Normal
		assertEquals("Check that tuition list is not bigger than 0", 0, timetableList.size());
	}
}

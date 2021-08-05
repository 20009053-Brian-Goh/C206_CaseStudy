import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private Tuition tt1;
	private Tuition tt2;
	private Tuition tt3;
	
	ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		tt1 = new Tuition("C001", "TuitionTest1", "English", "Not Fun", 1, "Test");
		tt2 = new Tuition("C002", "TuitionTest2", "English", "Not Fun", 2, "Test");
		tt3 = new Tuition("C003", "TuitionTest3", "English", "Not Fun", 3, "Test");
		
		tuitionList = new ArrayList<Tuition>();
	}
	
	@Test
	public void addTuitionTest() {
		// Item list is not null, so that can add a new tuition - boundary
		assertNotNull("Check if there is valid Tuition arraylist to add to", tuitionList);
		//Given an empty list, after adding 1 tuition, the size of the list is 1 - normal
		//The tuition just added is as same as the first tuition of the list
		C206_CaseStudy.addTuition(tuitionList, tt1);
		assertEquals("Check that Tuition arraylist size is 1", 1, tuitionList.size());
		assertSame("Check that Tuition is added", tt1, tuitionList.get(0));
		
		//Add another tuition. test The size of the list is 2? -normal
		//The tuition just added is as same as the second tuition of the list
		C206_CaseStudy.addTuition(tuitionList, tt2);
		assertEquals("Check that Tuition arraylist size is 2", 2, tuitionList.size());
		assertSame("Check that Tuition is added", tt2, tuitionList.get(1));
	}
	
	@Test
	public void retrieveAllTuitionTest() {
		// Test if Tuition list is not null but empty -boundary
		assertNotNull("Test if there is valid Tuition arraylist to retrieve tuition", tuitionList);
		
		//test if the list of tuitions retrieved from the C206_CaseStudy is empty - boundary
		String allTuition= C206_CaseStudy.retrieveAllTuition(tuitionList);
		String testOutput = "";
		assertEquals("Test that the retrieved tuitionlist is empty?", testOutput, allTuition);
		
		//Given an empty list, after adding 2 tuitions, test if the size of the list is 2 - normal
		C206_CaseStudy.addTuition(tuitionList, tt1);
		C206_CaseStudy.addTuition(tuitionList, tt2);
		assertEquals("Test that Tuition arraylist size is 2", 2,tuitionList.size());
		
		//test if the expected output string same as the list of tuitions retrieved from the C206_CaseStudy	
		allTuition= C206_CaseStudy.retrieveAllTuition(tuitionList);
		testOutput = String.format("%-15s %-15s %-20s %-22s %-18d %-20s\n", "C001", "TuitionTest1", "English", "Not Fun", 1, "Test");
		testOutput += String.format("%-15s %-15s %-20s %-22s %-18d %-20s\n","C002", "TuitionTest2", "English", "Not Fun", 2, "Test");
	
		assertEquals("Test the ViewAllTuitionlist", testOutput, allTuition);
		
	}
	
	public void doDeleteTuitionTest() {
		// Make sure list is not null -boundary
		assertNotNull("Test that there is a valid tuition arraylist to retrieve item", tuitionList);

		// Test if Tuition Code can be removed -Normal
		C206_CaseStudy.addTuition(tuitionList, tt1);
		boolean test = C206_CaseStudy.doDeleteTuition(tuitionList, "C206");
		assertTrue("Test if Tuition is ok to be deleted?", test);

		// Test if same Tuition Code can be removed again -Error
		test = C206_CaseStudy.doDeleteTuition(tuitionList, "C206");
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", test);

		// Test if Tuition Code can be removed -Normal
		C206_CaseStudy.addTuition(tuitionList, tt2);
		test = C206_CaseStudy.doDeleteTuition(tuitionList, "C328");
		assertTrue("Test if a Tuition is ok to be deleted?", test);

		// Test if same Tuition can be removed again -Error
		test = C206_CaseStudy.doDeleteTuition(tuitionList, "C328");
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", test);

		// Test if Tuition Code can be removed -Normal
		C206_CaseStudy.addTuition(tuitionList, tt3);
		test = C206_CaseStudy.doDeleteTuition(tuitionList, "C209");
		assertTrue("Test if a Tuition is ok to be deleted?", test);

		// Test if same Tuition Code can be removed again -Error
		test = C206_CaseStudy.doDeleteTuition(tuitionList, "C209");
		assertFalse("Test that the same Tuition is NOT ok to be deleted again?", test);

		// Test if Tuition list size has dropped to 0 after removing the 3 test items
		// -Normal
		assertEquals("Check that tuition list is not bigger than 0", 0, tuitionList.size());
	}

	@After
	public void tearDown() throws Exception {
		tt1 = null;
		tt2 = null;
		tt3 = null;
		tuitionList = null;
	}
}

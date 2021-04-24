import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * To begin the process I created test method stubs for each of the available 
 * methods in the Permit_list class and looked at each method and identified if 
 * there were any other classes which would need to be included to carry out proper 
 * functionality testing. I discovered I would need instances of System_status and 
 * Vehicle_list classes in order to accurately test several of the methods. In the 
 * constructor we have declared these specific class variables and other useful variables 
 * such as several permit holder names, host names and registrations which would also 
 * be useful as fixed values in testing.
 */
class Permit_listTest {
	
	public System_status Ss;
	public Permit_list PLInstance; 
	public Vehicle_list VLInstance;

	public String permitHolderName1;
	public String permitHolderName2;
	public String permitHolderName3;
	public String permitHolderName4;

	public String permitHostName1;
	public String permitHostName2;

	public int reg_vis_per_startDate;
	public int reg_vis_per_endDate;
	public int day_vis_per_visitDate;

	public String permitHolder1Reg1;
	public String permitHolder1Reg2;
	public String permitHolder2Reg1;
	public String permitHolder3Reg1;
	public String permitHolder4Reg1;

	public Date currentDate;

	/*
	 * After forming the constructor a test method setUp was created using the @BeforeEach 
	 * annotation. This is used to build the default test environment before each test is 
	 * carried out.
	 */
	@BeforeEach
	void setUp() throws Exception {
		
		Ss = new System_status();
		PLInstance = new Permit_list(Ss); 
		VLInstance = new Vehicle_list();
		
	
		permitHolderName1 = "Savi";
		permitHolderName2 = "Mick";
		permitHolderName3 = "Arran";
		permitHolderName4 = "Andrew";
		
		reg_vis_per_startDate = 3;
		reg_vis_per_endDate = 5;
		day_vis_per_visitDate = 2;		
		
		permitHostName1 = "Prof Z";
		permitHostName2 = "Prof Y";
		
		permitHolder1Reg1 = "AA01 AAA";
		permitHolder1Reg2 = "AA02 AAA";
		permitHolder2Reg1 = "BB01 BBB";
		permitHolder3Reg1 = "CC01 CCC";
		permitHolder4Reg1 = "DD01 DDD";		
		
		currentDate = Ss.getDateRef();

	}

	/*
	 * This test will validate that createPermanentVisitorPermit method 
	 * which adds a permit to the list and returns a reference to the newly 
	 * added permit. The rationale for this test is we expect when we get the 
	 * permit using the name used in the permit creation it will return the 
	 * same Permit object.
	 * 
	 * @param String 						permitHolderName1	
	 * The name of the permit holder and the key used to store the permit object
	 * 
	 * @param currentDate					currentDate			
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @return Permanent_visitor_permit		instance			
	 * This is a reference to the newly created permit object
	 */
	@Test
	void testcreatePermanentVisitorPermit() {
				
		Permanent_visitor_permit instance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
				
		assertTrue("Permit did not return the entry as expected", (PLInstance.getPermit(permitHolderName1) == instance));
		
	}
	
	/*
	 * This test will validate the createUniversityMemberPermit method 
	 * which adds a permit to the list and returns a reference to the newly 
	 * added permit. The rationale for this test is we expect when we get the 
	 * permit using the name used in the permit creation it will return the 
	 * same Permit object.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param int							uni_mem_per_startDate	
	 * The	day number the permit is valid from
	 * 
	 * @return University_member_permit		instance			
	 * This is a reference to the newly created permit object
	 */
	@Test
	void testcreateUniversityMemberPermit() {
				
		University_member_permit instance = PLInstance.createUniversityMemberPermit(permitHolderName1, currentDate);
				
		assertTrue("Permit did not return the entry as expected", (PLInstance.getPermit(permitHolderName1) == instance));
		
	}
	
	/*
	 * This test will validate the createRegularVisitorPermit method 
	 * which adds a permit to the list and returns a reference to the newly 
	 * added permit. The rationale for this test is we expect when we get the 
	 * permit using the name used in the permit creation it will return the 
	 * same Permit object.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param String						permitHostName1
	 * The name of the Host sponsoring the permit
	 * 
	 * @param int							reg_vis_per_startDate	
	 * The	day number the permit is valid from
	 * 
	 * @param int							reg_vis_per_endDate	
	 * The	day number the permit is valid until
	 * 
	 * @return Regular_visitor permit		instance			
	 * This is a reference to the newly created permit object
	 */
	@Test
	void testcreateRegularVisitorPermit() {
				
		Regular_visitor_permit instance = PLInstance.createRegularVisitorPermit(permitHolderName1, currentDate, permitHostName1, reg_vis_per_startDate, reg_vis_per_endDate);
				
		assertTrue("Permit did not return the entry as expected", (PLInstance.getPermit(permitHolderName1) == instance));
		
	}
	
	/*
	 * This test will validate the createDayVisitorPermit method 
	 * which adds a permit to the list and returns a reference to the newly 
	 * added permit. The rationale for this test is we expect when we get the 
	 * permit using the name used in the permit creation it will return the 
	 * same Permit object.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param int							day_vis_per_visitDate	
	 * The day number the permit is valid on
	 * 
	 * @return Day_visitor_permit			instance			
	 * This is a reference to the newly created permit object
	 */
	@Test
	void testcreateDayVisitorPermit() {
				
		Day_visitor_permit instance = PLInstance.createDayVisitorPermit(permitHolderName1, currentDate, permitHostName2, day_vis_per_visitDate);
				
		assertTrue("Permit did not return the entry as expected", (PLInstance.getPermit(permitHolderName1) == instance));
		
	}
	
	/*
	 * This test will validate the checkForPermit method 
	 * which checks if a permit exists which has that name 
	 * as permit holder. The rationale for this test is to 
	 * ensure that when a permit is created it can be found 
	 * using the same key. 
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param Day_visitor_permit			instance			
	 * This is a reference to the newly created permit object
	 * 
	 * @return boolean						rtn	
	 * The boolean return value, returns true if a permit is found with the associated name
	 */
	@Test
	void testCheckForPermit() {
		
		Permanent_visitor_permit instance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
		
		boolean rtn = PLInstance.checkForPermit(permitHolderName1);
		
		assertTrue("Permit added and was NOT found in the list when checked", (rtn == true));
		
	}
	
	/*
	 * This test will validate the removePermit method 
	 * which when a permit has been added with 1 or more 
	 * vehicles, when removed, will return all the associated 
	 * vehicle registrations in a Set of Strings. And the 
	 * permit itself will no longer be in the list of permits. 
	 * The criteria for this test is an assertion that all the 
	 * variable conditions are as expected, and two specific 
	 * fail conditions which check specifically why failure
	 * has occurred. One is if the permit is still present in the 
	 * list, and the second if the size of the return set is 
	 * larger or smaller than expected.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param Permanent_visitor_permit		pInstance	
	 * The test permit which will be used to create the associated vehicles
	 * 
	 * @return Set<String>					rtn			
	 * This is the set of Strings which are all the registrations associated with a permit returned upon removing a permit from the list
	 */
	@Test
	void testRemovePermit() {
		
		Permanent_visitor_permit pInstance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
		VLInstance.addVehicle(permitHolder1Reg1, pInstance);
		VLInstance.addVehicle(permitHolder1Reg2, pInstance);
		
		Set<String> rtn = PLInstance.removePermit(permitHolderName1);
		
		assertTrue("Method did not perform as expected", ((PLInstance.checkForPermit(permitHolderName1) == false)) && (rtn.size() == 2) && (rtn.contains(permitHolder1Reg1)) && (rtn.contains(permitHolder1Reg2)));
		assertFalse("Permit was not removed", (PLInstance.checkForPermit(permitHolderName1) == true));
		assertFalse("removePermit did not return the expected number of vehicle registrations", (rtn.size() != 2));

	}
	
	/*
	 * This test will validate the removeAllPermit method 
	 * which when several permits have been added with 1 or more 
	 * vehicles, when removed, will return all the associated 
	 * vehicle registrations in a Set of Strings. And all the 
	 * permits will no longer be in the list of permits. 
	 * The criteria for this test is an assertion that all the 
	 * variable conditions are as expected, and three specific 
	 * fail conditions which check specifically why failure
	 * has occurred. The first is if the permit for permit holder 1 
	 * is still present in the list, the second, if the permit 
	 * holder 2 is still in the list and finally if the size of 
	 * the return set is larger or smaller than expected.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permanent permit holder and the key used to store the permit object
	 * 
	 * @param String 						permitHolderName2		
	 * The name of the Regular permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param Permanent_visitor_permit		perInstance	
	 * The test permanent permit which will be used to create the associated vehicles
	 * 
	 * @param Regular_visitor_permit		regInstance	
	 * The test regular permit which will be used to create the associated vehicles
	 * 
	 * @param Set<String>					param
	 * The Set<String> which holds all of the references to permit holder names/keys which will be removed 
	 * from the list and any associated vehicles with any name in the param set will be returned
	 * 
	 * @return Set<String>					rtn			
	 * This is the set of Strings which are all the registrations associated with any permit removed from the list
	 */
	@Test
	void testRemoveAllPermit() {
		
		Permanent_visitor_permit perInstance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
		Regular_visitor_permit regInstance = PLInstance.createRegularVisitorPermit(permitHolderName2, currentDate, permitHostName1, reg_vis_per_startDate, reg_vis_per_endDate);
		VLInstance.addVehicle(permitHolder1Reg1, perInstance);
		VLInstance.addVehicle(permitHolder1Reg2, perInstance);
		VLInstance.addVehicle(permitHolder2Reg1, regInstance);
		
		Set<String> param = new HashSet<String>();
		param.add(permitHolderName1);
		param.add(permitHolderName2);
		
		Set<String> rtn = PLInstance.removeAllPermits(param);
		
		assertTrue("Method did not perform as expected", ((PLInstance.checkForPermit(permitHolderName1) == false) && 
														  (PLInstance.checkForPermit(permitHolderName2) == false) && 
														  (rtn.size() == 3) && 
														  (rtn.contains(permitHolder1Reg1)) && 
														  (rtn.contains(permitHolder1Reg2)) && 
														  (rtn.contains(permitHolder2Reg1))));
		assertFalse("Permit 1 was not removed", (PLInstance.checkForPermit(permitHolderName1) == true));
		assertFalse("Permit 2 was not removed", (PLInstance.checkForPermit(permitHolderName2) == true));
		assertFalse("removePermit did not return the expected number of vehicle registrations", (rtn.size() != 3));

	}
	
	/*
	 * This test will validate the getVehicleKeySet method 
	 * which will return all the keys associated with a permit. 
	 * The criteria for this test is an assertion that all the 
	 * variable conditions are as expected, and a specific 
	 * fail conditions which checks if the returning set of keys
	 * is bigger or smaller than expected. This test could be 
	 * expanded to check exactly which keys are missing.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permanent permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param Permanent_visitor_permit		perInstance	
	 * The test permanent permit which will be used to create the associated vehicles
	 * 
	 * @return Set<String>					rtn			
	 * This is the set of Strings which are all the registrations associated with any permit removed from the list
	 */
	@Test
	void testGetVehicleKeySet() {
		
		Permanent_visitor_permit perInstance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
		VLInstance.addVehicle(permitHolder1Reg1, perInstance);
		VLInstance.addVehicle(permitHolder1Reg2, perInstance);
		
		Set<String> rtn = PLInstance.getVehiclesKeySet(permitHolderName1);
		
		assertTrue("Methdod did not perform as expected", ((rtn.size() == 2) && (rtn.contains(permitHolder1Reg1)) && (rtn.contains(permitHolder1Reg2))));
		assertFalse("All Vehicle keys were NOT returned as expected", (rtn.size() != 2));

	}
	
	/*
	 * The following 3 tests will validate the aNewDay method 
	 * 
	 * Phase 1 -
	 * The system is initialised on day one, and the day permit is added
	 * to be valid on day 2. The aNewDay method is designed to update the 
	 * permit list and change whether a vehicle is permitted entry on the 
	 * new day. This phase ensures the permit is not valid on creation as 
	 * the days do not match.
	 * 
	 * Phase 2 -
	 * The system is initialised on day one, and the day permit is added
	 * to be valid on day 2. The system is then incremented and aNewDay is run.
	 * Now we expect the update to have set the day permit to permitted access.
	 * 
	 * Phase 3 -
	 * The system is initialised on day one, and the day permit is added
	 * to be valid on day 2. The system is then incremented and aNewDay is run, 
	 * twice! Now we expect the permit to be no longer accepted.
	 * 
	 * The rationale for all three tests are that the permitted attribute of the 
	 * permit has been updated as expected.
	 * 
	 * @param String 						permitHolderName1		
	 * The name of the permanent permit holder and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param Day_visitor_permit			dayInstance	
	 * The test day permit which will be used to test the aNewDay method
	 */
	@Test
	void testANewDayPhase1() {
			
		Day_visitor_permit dayInstance = PLInstance.createDayVisitorPermit(permitHolderName1, currentDate, permitHostName1, day_vis_per_visitDate);
		
		assertTrue("Method did not return expected value", (dayInstance.isPermitted() == false));
		
	}	
	@Test
	void testANewDayPhase2() {
			
		Day_visitor_permit dayInstance = PLInstance.createDayVisitorPermit(permitHolderName1, currentDate, permitHostName1, day_vis_per_visitDate);	
		Ss.incrementDate();
		PLInstance.aNewDay();
		
		assertTrue("Method did not return expected value", (dayInstance.isPermitted() == true));
		
	}
	@Test
	void testANewDayPhase3() {
			
		Day_visitor_permit dayInstance = PLInstance.createDayVisitorPermit(permitHolderName1, currentDate, permitHostName1, day_vis_per_visitDate);	
		Ss.incrementDate();
		PLInstance.aNewDay();
		Ss.incrementDate();
		PLInstance.aNewDay();
		
		assertTrue("Method did not return expected value", (dayInstance.isPermitted() == false));
		
	}
	
	/*
	 * The following 2 tests will validate the aNewYear method 
	 * 
	 * Phase 1 -
	 * The system is initialised on day nine, and one of each permit is added
	 * to the permit list. The system is then incremented and aNewDay is run.
	 * At this point we expect the system to still contain all permits and
	 * we assert that this is the case and if not report a failure
	 * 
	 * Phase 2 -
	 * The system is initialised on day ten, and one of each permit is added
	 * to the permit list. The system is then incremented and aNewYear is run.
	 * At this point we expect two results. That the return Set of names contains
	 * the name of the day permit holder and the regular permit holder are in 
	 * the set of returned strings, and also that the permanent and regular permits 
	 * are not. I have created two assertions which check both of these expectations.
	 * 
	 * @param String 						permitHolderName1-4		
	 * The names of the permit holders and the key used to store the permit object
	 * 
	 * @param Date							currentDate				
	 * The reference to the current Date being used by the System_status which is passed to the Permit when constructed
	 * 
	 * @param Set<String>					rtn
	 * The set of Strings which are all the permit holder names / keys which are to be removed from the list
	 */
	@Test
	void testANewYearPhase1() {
		
		Permanent_visitor_permit perInstance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
		University_member_permit uniInstance = PLInstance.createUniversityMemberPermit(permitHolderName2, currentDate);
		Regular_visitor_permit regInstance = PLInstance.createRegularVisitorPermit(permitHolderName3, currentDate, permitHostName2, reg_vis_per_startDate, reg_vis_per_endDate);		
		Day_visitor_permit dayInstance = PLInstance.createDayVisitorPermit(permitHolderName4, currentDate, permitHostName1, day_vis_per_visitDate);
		
		Ss.getDateRef().setDate(9);
		Ss.incrementDate();
		PLInstance.aNewDay();
		
		assertTrue("Some Permits are missing from the list",((PLInstance.checkForPermit(permitHolderName1) == true) && 
															 (PLInstance.checkForPermit(permitHolderName2) == true) && 
															 (PLInstance.checkForPermit(permitHolderName3) == true) && 
															 (PLInstance.checkForPermit(permitHolderName4) == true)));

		
	}
	@Test
	void testANewYearPhase2() {
		
		Permanent_visitor_permit perInstance = PLInstance.createPermanentVisitorPermit(permitHolderName1, currentDate);
		University_member_permit uniInstance = PLInstance.createUniversityMemberPermit(permitHolderName2, currentDate);
		Regular_visitor_permit regInstance = PLInstance.createRegularVisitorPermit(permitHolderName3, currentDate, permitHostName2, reg_vis_per_startDate, reg_vis_per_endDate);		
		Day_visitor_permit dayInstance = PLInstance.createDayVisitorPermit(permitHolderName4, currentDate, permitHostName1, day_vis_per_visitDate);
		
		Ss.getDateRef().setDate(10);
		Ss.incrementDate();
	    Set<String> rtn = PLInstance.aNewYear();
	    	    		
		assertFalse("Some Permits have been selected which should not have been", (rtn.contains(permitHolderName1) || rtn.contains(permitHolderName2)));
		assertFalse("Some Permits have not been selected for removal and should have been", (!(rtn.contains(permitHolderName3)) || !(rtn.contains(permitHolderName4))));
	}

}
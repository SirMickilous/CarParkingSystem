import java.util.Hashtable;
import java.util.Set;

/* Generated by Together */

/**
 * Vehicle list manages the collection of vehicles currently associated with
 * permits. It handles checks of whether vehicles are allowed through the
 * barriers, records warnings, and various other functions. Note that each
 * Vehicle_info object must have a unique registration number, to allow sensible
 * checking and recording of entries onto the campus (so a HashTable is probably
 * a good implementation of the collection, with registration number as key).
 *
 * There will only be one instance of this class.
 */
public class Vehicle_list
{
	/**
	 * The Vehicle list maintains a collection of the known Vehicle_infos associated
	 * with all permits. This association must be implemented by an attribute
	 * holding a collection data structure (for example: array, hash table - the
	 * latter is recommended).
	 *
	 * Note that no two Vehicle_infos may have the same registration number (this
	 * information is not represented diagrammatically) - this is to guarantee
	 * consistency with the constraint that no vehicle is associated with more than
	 * one permit.
	 *
	 * Note that, given a registration number, the Vehicle_list can look up the
	 * appropriate Vehicle_info instance, and via that it can obtain the vehicle's
	 * permit information.
	 * 
	 * @associates Vehicle_info
	 * @label Contains
	 * @clientCardinality 1
	 * @supplierCardinality 0..*
	 * @directed
	 */
	private Hashtable<String, Vehicle_info> lnkVehicle;

	String regNo1;
	String regNo2;
	String regNo3;
	String regNo4;

	public Vehicle_list(Permit[] dummyPermits)
	{
		// New Hashtable of all vehicles in the list
		lnkVehicle = new Hashtable<String, Vehicle_info>();

		// Dummy instances to load into the system on start up
		regNo1 = "SG32 HLS";
		regNo2 = "CM87 XQK";
		regNo3 = "JW55 PRE";
		regNo4 = "GO88 LES";

		Permanent_visitor_permit permit1 = (Permanent_visitor_permit) dummyPermits[0];
		Vehicle_info vehicle1 = new Vehicle_info(regNo1, permit1);
		lnkVehicle.put(regNo1, vehicle1);
		University_member_permit permit2 = (University_member_permit) dummyPermits[1];
		Vehicle_info vehicle2 = new Vehicle_info(regNo2, permit2);
		lnkVehicle.put(regNo2, vehicle2);
		Regular_visitor_permit permit3 = (Regular_visitor_permit) dummyPermits[2];
		Vehicle_info vehicle3 = new Vehicle_info(regNo3, permit3);
		lnkVehicle.put(regNo3, vehicle3);
		Day_visitor_permit permit4 = (Day_visitor_permit) dummyPermits[3];
		Vehicle_info vehicle4 = new Vehicle_info(regNo4, permit4);
		lnkVehicle.put(regNo4, vehicle4);
	}
	
	public Vehicle_list() {
		
		// New Hashtable of all vehicles in the list
		lnkVehicle = new Hashtable<String, Vehicle_info>();
		
	}

	/**
	 * The checkForVehicle method takes a registration/key in the form of a String 
	 * and attempts to retrieve the vehicle from the list, it returns a boolean 
	 * value to indicate if it successfully retrieved a non null value
	 * 
	 * @param String:name		The key/registration of the vehicle to check
	 * 
	 * @return boolean			Returns true if that key/registration returns a 
	 * 							vehicle and false if it returns nothing 
	 */
	public boolean checkForVehicle(String regNo)
	{
		if (lnkVehicle.get(regNo) != null)
		{
			return true;
		}
		return false;
	}

	/**
	 * The getVehicle method takes a registration/key in the form of a String 
	 * and retrieves the vehicle from the list using the registration if there
	 * is no vehicle a null value is returned.
	 * 
	 * @param String:name		The key/registration of the vehicle to retrieve
	 * 
	 * @return Vehicle_info		The return Vehicle_info if found or null if not 
	 */
	public Vehicle_info getVehicle(String regNo)
	{
		return lnkVehicle.get(regNo);
	}

	/**
	 * The addVehicle method takes a registration/key in the form of a String 
	 * and a reference to a new Permit it then creates a new vehicle. It then 
	 * stores that vehicle in the list using the registration as a key. Finally 
	 * it check and returns if it can find the new vehicle in the list.
	 *  
	 * @param String:reg			The key/registration of the vehicle
	 * @param Permit:p 				A reference to permit this vehicle will be associated with 
	 * 
	 * @return boolean				A return value to indicate if the vehicle is now in the list 
	 */
	public boolean addVehicle(String reg, Permit p) 
	{
		lnkVehicle.put(reg, new Vehicle_info(reg, p));
		
		if(checkForVehicle(reg)) 
		{
			return true;
		}
		return false;
	}
	
	/**
	 * The removeVehicle method takes a registration/key in the form of a String 
	 * and searches for that vehicle_info in the list and then removes itself from the list 
	 * of permitted vehicles of it's associated permit. It then removes the 
	 * dis-associated vehicle from the list of vehicles.
	 *  
	 * @param String:reg			The key/registration of the vehicle to be removed 
	 */
	public void removeVehicle(String reg) {
		lnkVehicle.get(reg).getPermit().removePermittedVehicle(reg);
		lnkVehicle.remove(reg);
	}
	
	/**
	 * The removeVehicles method takes a Set of registrations/keys in the form of Strings
	 * and passes each of those registrations/keys to the removeVehicle method to carry out
	 * each removal.
	 *  
	 * @param Set<String>:keys		The keys/registrations of the vehicles to be removed 
	 */
	public void removeVehicles(Set<String> keys) {
		for (String k : keys) {
			if(lnkVehicle.containsKey(k)) {
				lnkVehicle.remove(k);
			}
		}
	}
    
	/**
	 * The getTableSize method returns the size of the Vehicle_list
	 *  
	 * @return int		The size of the vehicle_list hashtable 
	 */
	public int getTableSize() 
    {
    	return lnkVehicle.size();
    }

}
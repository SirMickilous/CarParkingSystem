/* Generated by Together */

/**
 * For a description of Day visitors, follow hyperlink to the Administration use case for
 * issuing a new Day visitor permit.
 */
public class Day_visitor_permit extends Permit {
    /**
     * The name of the University member hosting the visit.
     */
    private String hostName;

    /**
     * The date that the visitor is visiting on - entry will be allowed on that date only.
     * @clientCardinality 1
     * @supplierCardinality 1
     * @label Visiting on
     * @link aggregation
     * @directed
     */
    private int lnkDateVisit;
    
    public Day_visitor_permit(String permitHolder, Date currentDate, String hostName, int date) {
		super(permitHolder, currentDate);
			this.hostName = hostName;
			this.lnkDateVisit = date;
			if (currentDate.getDate() == date) {
			    this.setPermitted(true);
			}
			else {
				this.setPermitted(false);
			}
    }
    
	/**
	 * Returns the name of the host/sponsor of this day permit
	 * 
	 * @return String		The name of the host 
	 */
    public String getHostName() {
		return this.hostName;
	}

	/**
	 * Returns the day this day permit is permitted access
	 * 
	 * @return int		The day this permit permits access  
	 */
	public int getVisitDate() {
		return this.lnkDateVisit;
	}

	/**
	 * Sets the name of the host/sponsor of this day permit
	 * 
	 * @param String		The name of the host 
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * Sets the day this day permit is permitted access
	 * 
	 * @param int		The day this permit permits access  
	 */
	public void setVisitDate(int date) {
		this.lnkDateVisit = date;
	}
	
	/**
	 * The day permit new day update sets entered 
	 * to false, clears any vehicle references in 
	 * vehicleUsedToday and checks if the current 
	 * date matches the visit date and if they match 
	 * permitted is set to true.
	 */
	public void newDayUpdate() {
		this.setEntered(false);
		this.clearVehicleUsedToday();
		if (currentDate.getDate() == lnkDateVisit) {
			this.setPermitted(true);
		}
		else {
			this.setPermitted(false);
		}
	}
	/**
	 * The day permit newYearUpdate method is empty as it is not currently necessary we call it.
	 */
	public void newYearUpdate(){}

}

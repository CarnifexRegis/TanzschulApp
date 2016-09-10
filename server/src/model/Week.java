package model;

// TODO: Auto-generated Javadoc
/**
 * The Enum Week.
 *
 * @author Simon
 * This Class is representing a full week
 * 8 is an default value and is used if the User wants to call all object not minding the day value 
 * The Object SUNDAY is not used because  the Sunday is no business day also at most dancing scools in Germany
 */
public enum Week {
	
	/** The monday. */
	//TODO test and debug
	  MONDAY("'Montag'",1),
	  
  	/** The tuesday. */
  	TUESDAY("'Dienstag'",2),
	  
  	/** The wednessday. */
  	WEDNESSDAY("'Mittwoch'",3),
	  
  	/** The thursday. */
  	THURSDAY("'Donnerstag'",4),
	  
  	/** The friday. */
  	FRIDAY("'Freitag'",5),
	  
  	/** The saturday. */
  	SATURDAY("'Samstag'",6),
	  
  	/** The sunday. */
  	SUNDAY("'Sonntag'",7),
	  
  	/** The none. */
  	NONE("WOCHENTAG",8);
		
		
		/**
		 * Gets the d na.
		 *
		 * @return the d na
		 */
		public String getdNa() {
		return dNa;
	}
	
	/**
	 * Gets the d nu.
	 *
	 * @return the d nu
	 */
	public int getdNu() {
		return dNu;
	}
		
		/** The d na. */
		String dNa; // DayName
		
		/** The d nu. */
		int dNu; // DayNumber
	 
 	/**
 	 * Instantiates a new week.
 	 *
 	 * @param dNa the d na
 	 * @param dNu the d nu
 	 */
 	Week(String dNa,int dNu ) {	
		 this.dNa=dNa;
		 this.dNu=dNu;
	 }
	 
	}
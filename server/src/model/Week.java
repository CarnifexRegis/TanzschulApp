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
	
	//TODO test and debug
	  MONDAY("'Montag'",1),
  	TUESDAY("'Dienstag'",2),
  	WEDNESSDAY("'Mittwoch'",3),
  	THURSDAY("'Donnerstag'",4),
  	FRIDAY("'Freitag'",5),
  	SATURDAY("'Samstag'",6),
  	SUNDAY("'Sonntag'",7),
  	NONE("WOCHENTAG",8);
		
		public String getdNa() {
		return dNa;
	}

	public int getdNu() {
		return dNu;
	}

		String dNa; // DayName
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
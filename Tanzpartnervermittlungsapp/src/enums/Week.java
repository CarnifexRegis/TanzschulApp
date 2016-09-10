package enums;


// TODO: Auto-generated Javadoc
/**
 * The Enum Week.
 */
public enum Week {
	  
  	/** The monday. */
  	MONDAY("Montag",1),
	  
  	/** The tuesday. */
  	TUESDAY("Dienstag",2),
	  
  	/** The wednessday. */
  	WEDNESSDAY("Mittwoch",3),
	  
  	/** The thursday. */
  	THURSDAY("Donnserstag",4),
	  
  	/** The friday. */
  	FRIDAY("Freitag",5),
	  
  	/** The saturday. */
  	SATURDAY("Samstag",6),
	  
  	/** The sunday. */
  	SUNDAY("Sonntag",7);
		
		
		/**
		 * Gets the d na.
		 *
		 * @return the d na
		 */
		public String getdNa() {
		return dNa;
	}
	
	/**
	 * Sets the d na.
	 *
	 * @param dNa the new d na
	 */
	public void setdNa(String dNa) {
		this.dNa = dNa;
	}
	
	/**
	 * Gets the d nu.
	 *
	 * @return the d nu
	 */
	public int getdNu() {
		return dNu;
	}
	
	/**
	 * Sets the d nu.
	 *
	 * @param dNu the new d nu
	 */
	public void setdNu(int dNu) {
		this.dNu = dNu;
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
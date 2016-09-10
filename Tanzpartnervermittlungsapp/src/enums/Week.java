package enums;


// TODO: Auto-generated Javadoc
/**
 *@author Simon sTOLZ
 */
public enum Week {
  	MONDAY("Montag",1),
  	TUESDAY("Dienstag",2),
  	WEDNESSDAY("Mittwoch",3),
  	THURSDAY("Donnserstag",4),
  	FRIDAY("Freitag",5),
  	SATURDAY("Samstag",6),
  	SUNDAY("Sonntag",7);
		
		public String getdNa() {
		return dNa;
	}
	public void setdNa(String dNa) {
		this.dNa = dNa;
	}
	public int getdNu() {
		return dNu;
	}
	public void setdNu(int dNu) {
		this.dNu = dNu;
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
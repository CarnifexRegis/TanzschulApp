package model;


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
	 Week(String dNa,int dNu ) {	
		 this.dNa=dNa;
		 this.dNu=dNu;
	 }
	 
	}
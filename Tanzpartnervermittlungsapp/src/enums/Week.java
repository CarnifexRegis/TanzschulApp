package enums;


public enum Week {
	  MONDAY("Monday",1),
	  TUESDAY("Tuesday",2),
	  WEDNESSDAY("Wednesday",3),
	  THURSDAY("Thursday",4),
	  FRIDAY("Friday",5),
	  SATURDAY("Saturday",6),
	  SUNDAY("Sunday",7);
		
		
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
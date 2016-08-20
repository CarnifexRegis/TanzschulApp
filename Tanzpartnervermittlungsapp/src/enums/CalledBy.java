package enums;

import android.app.Activity;

public enum CalledBy {
EditProfile("ep"),Menue("m");
	
	String activity;
	private CalledBy(String activity) {
		this.activity = activity;
	}

	public String getActivity() {
		return activity;
	}
	
}

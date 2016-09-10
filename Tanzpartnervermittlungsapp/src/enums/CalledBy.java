package enums;

import android.app.Activity;

// TODO: Auto-generated Javadoc
/**
 * @author Simon Stolz
 */
public enum CalledBy {
EditProfile("ep"),
Menue("m");

	private  String activity;
	
	/**
	 * Instantiates a new called by.
	 *
	 * @param activity the activity
	 */
	private CalledBy(String activity) {
		this.activity = activity;
	}

	public String getActivity() {
		return activity;
	}
	
}
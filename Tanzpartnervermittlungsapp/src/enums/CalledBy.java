package enums;

import android.app.Activity;

// TODO: Auto-generated Javadoc
/**
 * The Enum CalledBy.
 */
public enum CalledBy {

/** The Edit profile. */
EditProfile("ep"),
/** The Menue. */
Menue("m");
	
	/** The activity. */
	String activity;
	
	/**
	 * Instantiates a new called by.
	 *
	 * @param activity the activity
	 */
	private CalledBy(String activity) {
		this.activity = activity;
	}

	/**
	 * Gets the activity.
	 *
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}
	
}

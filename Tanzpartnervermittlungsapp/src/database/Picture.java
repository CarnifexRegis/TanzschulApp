package database;

/**
 * TODO
 */
public class Picture {
	private String source;
	private String name;
	private int called;
	private int gotright;
	private int inarow;
	private String showAs;

	public Picture() {}

	public String getSource() {
		return source;
	}

	public String getName() {
		return name;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setShowAs(String showAs) {
		this.showAs = showAs;
	}

	/**
	 *
	 * @param o The Picture to be compared
	 * @return  if the two Pictures match in all their attributes
	 */
	@Override
	public boolean equals(Object o) {
		Picture p = (Picture) o;
		return (p.source.equals(source) && p.name.equals(name) && p.called == called && p.gotright == gotright && p.inarow == inarow);
	}
}

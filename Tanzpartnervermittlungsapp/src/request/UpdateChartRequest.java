package request;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "updatechartrequest")
//gender needed
public class UpdateChartRequest {
	public UpdateChartRequest(int id, int kursstufe, boolean gender) {
		super();
		this.id = id;
		this.kursstufe = kursstufe;
		this.gender = gender;
	}
	@Element(name = "id")
	int id;
	@Element(name ="kursstufe")
	int kursstufe;
	@Element(name = "gender")
	boolean gender;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKursstufe() {
		return kursstufe;
	}
	public void setKursstufe(int kursstufe) {
		this.kursstufe = kursstufe;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
}

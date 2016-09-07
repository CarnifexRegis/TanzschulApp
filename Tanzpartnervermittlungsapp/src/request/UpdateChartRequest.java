package request;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "updatechartrequest")
//gender needed
public class UpdateChartRequest {
	
	@Element(name = "id")
	int id;
	@Element(name ="kursstufe")
	int kursstufe;
	@Element(name = "gender")
	boolean gender;
	@Element (name = "day")
	int day;
	public UpdateChartRequest(){
		super();
		
	}
	public UpdateChartRequest(int id, int kursstufe, boolean gender, int day) {
		super();
		this.id = id;
		this.kursstufe = kursstufe;
		this.gender = gender;
		this.day = day;
	}
	public int getId() {
		return id;
	}
	public int getKursstufe() {
		return kursstufe;
	}
	public boolean isGender() {
		return gender;
	}
	
	public int getDay() {
		return day;
	}
	
}

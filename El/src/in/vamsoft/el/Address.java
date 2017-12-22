package in.vamsoft.el;

public class Address {

	String Houseno;
	String city;
	public String getHouseno() {
		return Houseno;
	}
	public void setHouseno(String houseno) {
		Houseno = houseno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [Houseno=" + Houseno + ", city=" + city + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String houseno, String city) {
		super();
		Houseno = houseno;
		this.city = city;
	}
}

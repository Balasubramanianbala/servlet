package in.vamsoft.pojo;

public class UserCreation {
	
	
	String username;
	int phno;
	String email_id;
	String passwd;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public UserCreation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCreation( String username, int phno, String email_id, String passwd) {
		super();
		
		this.username = username;
		this.phno = phno;
		this.email_id = email_id;
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "UserCreation [username=" + username + ", phno=" + phno + ", email_id=" + email_id
				+ ", passwd=" + passwd + "]";
	}
	

}

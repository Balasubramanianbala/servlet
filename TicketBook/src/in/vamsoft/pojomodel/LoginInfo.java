package in.vamsoft.pojomodel;

public class LoginInfo {

  String date;
  String email;
  String ipAddress;
  String browser;
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
  public String getBrowser() {
    return browser;
  }
  public void setBrowser(String browser) {
    this.browser = browser;
  }
  @Override
  public String toString() {
    return "LoginInfo [date=" + date + ", email=" + email + ", ipAddress=" + ipAddress + ", browser=" + browser + "]";
  }
  public LoginInfo() {
    super();
    // TODO Auto-generated constructor stub
  }
  public LoginInfo(String date, String email, String ipAddress, String browser) {
    super();
    this.date = date;
    this.email = email;
    this.ipAddress = ipAddress;
    this.browser = browser;
  }
  
}

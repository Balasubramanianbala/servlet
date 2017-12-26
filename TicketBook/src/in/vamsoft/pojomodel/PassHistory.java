package in.vamsoft.pojomodel;

public class PassHistory {

  private String loginDate;
  private String password;
  private String email;

  public String getLoginDate() {
    return loginDate;
  }

  public void setLoginDate(String loginDate) {
    this.loginDate = loginDate;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PassHistory(String loginDate, String email,String password) {
    super();
    this.loginDate = loginDate;
    this.password = password;
    this.email = email;
  }

  public PassHistory() {
    super();
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return "PassHistory [loginDate=" + loginDate + ", password=" + password + ", email=" + email + "]";
  }

}

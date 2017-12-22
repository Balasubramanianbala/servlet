package in.vamsoft.pojomodel;

public class UserCreation {

  private String firstName;
  private String lastName;
  private String email;
  private String password;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserCreation [firstName=" + firstName + ", lastName=" + lastName 
                      + ", email=" + email + ", password="  + password + "]";
      
  }

  public UserCreation() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @param firstName.
   * @param lastName.
   * @param email.
   * @param password.
   */
  public UserCreation(String firstName, String lastName, String email, String password) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

}

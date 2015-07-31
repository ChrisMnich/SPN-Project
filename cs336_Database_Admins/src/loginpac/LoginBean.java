package loginpac;

//Data Encapsulation using Getters and Setters
public class LoginBean {
	
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  public boolean admin;
  public boolean valid;
  
  
  public String getFirstName()					//returns FirstName
  {
      return firstName;
  }
  public void setFirstName(String newFirstName)	//sets firstName
  {
      firstName = newFirstName;
  }
  public String getLastName() 					//returnss LastName
  {
      return lastName;
  }
  public void setLastName(String newLastName)	//sets LastName
  {
      lastName = newLastName;
  }
  public String getPassword()					//returnss Password
  {
      return password;
  }
  public void setPassword(String newPassword)	//sets password
  {
      password = newPassword;
  }
  public String getUsername()					//returns username
  {
      return username;
  }
  public void setUserName(String newUsername)	//sets username
  {
      username = newUsername;
  }
  public boolean isValid()						//returns valid
  {
      return valid;
  }
  public void setValid(boolean newValid)		//sets valid
  {
      valid = newValid;
  }
  public boolean isAdmin()						//returns valid
  {
      return admin;
  }
  public void setAdmin(boolean newAdmin)		//sets valid
  {
      admin = newAdmin;
  }
}
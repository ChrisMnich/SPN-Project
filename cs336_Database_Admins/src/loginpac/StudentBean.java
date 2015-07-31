package loginpac;


public class StudentBean {
	
	  private String Major;
	  private String GPA;
	  private String Credits;
	  public boolean valid;
	  
	  public String getMajor(){					//returns Major
	      return Major;
	  }
	  
	  public void setMajor(String Major){		//sets Major
	      this.Major = Major;
	  }
	  
	  public String getGPA() {					//returnss GPA
		  return GPA;
	  }
	  public void setGPA(String GPA){			//sets GPA
	      this.GPA = GPA;
	  }
	  public String getCredits(){					//returnss Credits
		  return Credits;
	  }
	  
	  public void setCredits(String Credits){		//sets Credits
	      this.Credits = Credits;
	  }
	  
}
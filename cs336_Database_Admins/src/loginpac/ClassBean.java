package loginpac;

public class ClassBean {
	private String courseID;
	private String section;
	private String credits;
	private String room;
	private String type;
	private String grade;
	
	public String getCourse(){
		return courseID;
	}
	
	public void setCourse(String course){
		courseID = course;
	}
	
	public  String getSection(){
		return section;
	}
	
	public void setSection(String section){
		this.section = section;
	}
	
	public String getCredits(){
		return credits;
	}
	
	public void setCredits(String credits){
		this.credits = credits;
	}
	
	public String getRoom(){
		return room;
	}
	
	public void setRoom(String room){
		this.room = room;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getGrade(){
		return grade;
	}
	public void setGrade(String grade){
		this.grade = grade;
	}
}

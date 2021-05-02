package kodlamaio;

public class Student extends User {
	String educationInformation;
	String userType = "Student";
	public String getEducationInformation() {
		return educationInformation;
	}
	public void setEducationInformation(String educationInformation) {
		this.educationInformation = educationInformation;
	}
	public String getUserType() {
		return userType;
	}

	
}

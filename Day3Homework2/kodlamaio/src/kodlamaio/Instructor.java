package kodlamaio;

public class Instructor extends User{
	String graduationInformation;
	String userType = "Instructor";
	
	public String getGraduationInformation() {
		return graduationInformation;
	}
	public void setGraduationInformation(String graduationInformation) {
		this.graduationInformation = graduationInformation;
	}

	public String getUserType() {
		return userType;
	}
	
	
}

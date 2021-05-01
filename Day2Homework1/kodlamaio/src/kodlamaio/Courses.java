package kodlamaio;

public class Courses {
	
	public Courses() {
		System.out.println("Course has been created");
	}
	
	public Courses(int id,String name,String tutorName) {
		this();
		this.id = id;
		this.name = name;
		this.tutorName = tutorName;
	}
	
	int id;
	String name;
	String tutorName;
	int progress = 0;
}

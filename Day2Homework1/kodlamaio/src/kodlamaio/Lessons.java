package kodlamaio;

public class Lessons {
	
	public Lessons() {
		System.out.println("Lesson has been created");
	}
	
	public Lessons(int id,String name,int courseId) {
		this();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
	}
	int id;
	String name;
	int courseId;
	boolean isDone = false;
}

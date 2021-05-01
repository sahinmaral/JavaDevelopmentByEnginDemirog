package kodlamaio;

public class CourseManager {
	public void removeCourse(Courses course) {
		System.out.println(course.name+" has been deleted");
		course.id = 0;
		course.name = "";
		course.progress = 0;
		course.tutorName = "";
	}
	
	public void getCourseList(Courses[] courses){
		
		for (Courses course : courses) {
			System.out.println("Course Id : "+course.id);
			System.out.println("Course Name : "+course.name);
			System.out.println("Course Tutor Name : "+course.tutorName);
			System.out.println("Course Progress : "+course.progress);
			System.out.println("--------------------");
		}
		
	}
	
public void getLessonList(Lessons[] lessons){
		
	for (Lessons lesson : lessons) {
		System.out.println("Lesson Id : "+lesson.id);
		System.out.println("Lesson Name : "+lesson.name);
		System.out.println("Lesson Course Id : "+lesson.courseId);
		System.out.println("--------------------");
	}
		
	}
	
	
}

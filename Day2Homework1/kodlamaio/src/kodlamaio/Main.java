package kodlamaio;

public class Main {

	public static void main(String[] args) {
		
		Courses course1 = new Courses(1,
				"Java Yaz�l�m Geli�tirici Yeti�tirme Kamp� (Java + React)","Engin Demiro�");
		Courses course2 = new Courses(2,
				"Yaz�l�m Geli�tirici Yeti�tirme Kamp� (C# + ANGULAR)","Engin Demiro�");
		
		Courses[] courses = new Courses[] {
				course1,course2
		};
		
		CourseManager courseManager = new CourseManager();
		courseManager.getCourseList(courses);
		
		Lessons lesson1 = new Lessons(1,"Ders 1",1);
		Lessons lesson2 = new Lessons(2,"Ders 2",1);
		Lessons lesson3 = new Lessons(3,"Ders 1",2);
		
		Lessons[] lessons = new Lessons[] {
				lesson1,lesson2,lesson3
		};
		
		
		courseManager.getLessonList(lessons);
		
		
		
		

	}

}

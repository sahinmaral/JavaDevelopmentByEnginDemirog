package kodlamaio;

public class Main {

	public static void main(String[] args) {
		
		Instructor instructor1 = new Instructor();
		instructor1.setId(1);
		instructor1.setUsername("enginDemirog");
		instructor1.setPassword("12345");
		instructor1.setGraduationInformation("ODTÜ Master");
		
		Student student1 = new Student();
		student1.setId(2);
		student1.setUsername("sahinMaral");
		student1.setPassword("12345");
		student1.setEducationInformation("Ýstanbul Ticaret Üniversitesi Lisans");

		User[] users = new User[] {instructor1 , student1};
		
		UserManager userManager1 = new StudentManager();
		userManager1.addCommentOnLesson(student1, "Java", "Çok güzel ders");
		
		UserManager userManager2 = new InstructorManager();
		userManager2.addCommentOnLesson(instructor1, "Java", "Teþekkür ederim yorumunuz için");
		
		UserManager userManager3 = new UserManager();
		userManager3.getUserList(users);
		
	}

}

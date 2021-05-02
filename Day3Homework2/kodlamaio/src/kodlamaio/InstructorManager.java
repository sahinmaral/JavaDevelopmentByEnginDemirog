package kodlamaio;

public class InstructorManager extends UserManager {

	@Override
	public void addCommentOnLesson(User user, String lessonName, String message) {
		System.out.println("Kullanýcý türü : Instructor");
		System.out.println(user.username);
		System.out.println(lessonName+" adlý derse yorumunuz yollanmýþtýr");
		System.out.println("Mesaj : "+message);
		System.out.println("--------------------------");
	}

}

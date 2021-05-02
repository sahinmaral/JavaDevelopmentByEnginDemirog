package kodlamaio;

public class StudentManager extends UserManager{

	@Override
	public void addCommentOnLesson(User user, String lessonName, String message) {
		System.out.println("Kullanýcý türü : Student");
		System.out.println(user.username);
		System.out.println(lessonName+" adlý derse yorumunuz yollanmýþtýr");
		System.out.println("Mesaj : "+message);
		System.out.println("--------------------------");
	}
	
}

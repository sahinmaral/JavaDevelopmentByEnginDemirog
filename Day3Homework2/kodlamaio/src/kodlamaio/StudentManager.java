package kodlamaio;

public class StudentManager extends UserManager{

	@Override
	public void addCommentOnLesson(User user, String lessonName, String message) {
		System.out.println("Kullan�c� t�r� : Student");
		System.out.println(user.username);
		System.out.println(lessonName+" adl� derse yorumunuz yollanm��t�r");
		System.out.println("Mesaj : "+message);
		System.out.println("--------------------------");
	}
	
}

package kodlamaio;

public class UserManager {
	public void addCommentOnLesson(User user, String lessonName , String message)
	{
		
	}

	public void getUserList(User[] users)
	{
		System.out.println("Kullan�c�lar");
		System.out.println("-------------------");
		for (User user : users) {
			System.out.println("Kullan�c� ad� : "+user.getUsername());
			System.out.println("Kullan�c� tipi : "+user.getUserType());
			System.out.println("-------------------");
		}
	}
	
	
	
}

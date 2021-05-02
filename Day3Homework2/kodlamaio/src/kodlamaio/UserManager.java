package kodlamaio;

public class UserManager {
	public void addCommentOnLesson(User user, String lessonName , String message)
	{
		
	}

	public void getUserList(User[] users)
	{
		System.out.println("Kullanýcýlar");
		System.out.println("-------------------");
		for (User user : users) {
			System.out.println("Kullanýcý adý : "+user.getUsername());
			System.out.println("Kullanýcý tipi : "+user.getUserType());
			System.out.println("-------------------");
		}
	}
	
	
	
}

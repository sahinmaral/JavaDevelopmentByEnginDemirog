package intro;

public class Main {

	public static void main(String[] args) {
		int number = 27;  //1+2+3 = 6
		int total = 0;
		
		for(int i=1;i<number;i++)
		{
			if(number % i == 0)
				total += i;
		}
		
		if(total == number)
			System.out.println(number+" is prime number");
		else
			System.out.println(number+" is not prime number");
	}

}

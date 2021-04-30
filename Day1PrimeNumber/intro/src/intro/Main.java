package intro;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		int number = 2;
		
		boolean isPrime = true;
		
		for(int i=2;i<number;i++)
		{
			if (number % 2==0) {
				isPrime=false;
			}
		}
		
		System.out.println("Prime : "+isPrime);
		
		
	}

}

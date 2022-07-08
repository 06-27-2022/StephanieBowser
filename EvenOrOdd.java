/*
 *  Write a method that prints "even" if the number passed is even and "odd" 
 *  if the number is odd
 */

import java.util.Scanner;

public class EvenOrOdd {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter any number (must be an integer): ");
		int number = scanner.nextInt();
		
		if(number % 2 == 0)
			System.out.println(number + " is even");
		else
			System.out.println(number + " is odd");
		
			
	}

}

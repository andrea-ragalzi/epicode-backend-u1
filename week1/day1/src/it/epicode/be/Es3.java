package it.epicode.be;

import java.util.Scanner; // Import the Scanner class

public class Es3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String userInputs = "";
		String userInputsReversed = "";
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter string " + (i + 1) + ':');
			String userInput = scanner.nextLine();
			userInputs += userInput;
			userInputsReversed = userInput + userInputsReversed;
		}
		scanner.close();
		System.out.println(userInputs);
		System.out.println(userInputsReversed);
	}

}

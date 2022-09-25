package com.java;

public class Matcher {

	public static void main(String[] args) {
		

		// Declaring and initializing a string
		// Input string
		String Str = new String("12025");

		// Display message for better readability
		System.out.print(
			"Does String contains regex (.*)geeks(.*) ? : ");
		// Testing if regex is present or not
		System.out.println(Str.matches("1[0-9]025"));

		// Display message for better readability
		System.out.print(
			"Does String contains regex geeks ? : ");

		// Testing if regex is present or not
		System.out.println(Str.matches("geeks"));
	}
}

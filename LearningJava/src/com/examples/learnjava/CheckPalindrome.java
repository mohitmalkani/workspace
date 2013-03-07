package com.examples.learnjava;

import java.util.Scanner;

public class CheckPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String original, reverse="";
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a String to check if it is a palindrome or not : \n");
		original = in.next();
		
		int len = original.length();
		
		for (int i = len-1; i>=0; i-- ){
			reverse = reverse + original.charAt(i);
		}
		if(original.equals(reverse))
			System.out.println(original + " is a Palindrome");
		else
			System.out.println(original + " is not a Palindrome"); 
	}

}

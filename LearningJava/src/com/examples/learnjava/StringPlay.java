package com.examples.learnjava;

public class StringPlay {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] helloArray = {'h', 'e', 'l','l','o', '.'};
		String helloString = new String (helloArray);
		System.out.println(helloString);
		
		String palindrome = "Malayalam";
		int len = palindrome.length();
		char[] tempCharArray = new char[len];
		char[] charArray = new char[len];
		// put original string in an 
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = 
                palindrome.charAt(i);
        } 
        
        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] =
                tempCharArray[len - 1 - j];
        }
        
        String reversePalindrome =
            new String(charArray);
        System.out.println(reversePalindrome);
	}

}

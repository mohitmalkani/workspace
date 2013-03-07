package practicePackage;
import java.util.Scanner;

public class Reverse {
	public static void main(String args[]) {
		
		 Scanner input = new Scanner(System.in);
    	 System.out.print("Enter a string, that you 'd like to be reversed: ");
    	 String s;
    	 s=input.next();
    	 char arr[]=s.toCharArray();
    	 System.out.print("Original is : ");
    	 for(int i=0 ; i<arr.length ; i++){
    		System.out.print(arr[i]);
    	 }
    	 	String reverseString="";
    	 	System.out.println();
    	 	System.out.println("Length: "+ arr.length);
    	 for (int i=arr.length-1;i>=0;i--) {
    		 reverseString=reverseString+arr[i];
    	 }
    	 System.out.println("Reverse: " + reverseString);
    	 
    	 //public String isPalindrome(String original, String reversed){
    		 if(s.equalsIgnoreCase(reverseString)){
    			 System.out.println("This is a Palindrome");
    		 }
    		 else System.out.println("String Not Palindrome");
     }
}
	
	/*
	static String s= "Hey There";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		String name;
		System.out.println("Please enter your name here: ");
		name= scan.next();
		System.out.println("\n"+s+" "+name+" \n");
		for(int i=name.length()-1;i>=0;i--){
	        //name = name.replaceAll("(\\r|\\n)", "");
			System.out.println(name.charAt(i));
		}
	}*/



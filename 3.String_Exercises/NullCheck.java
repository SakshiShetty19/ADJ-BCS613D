/*Q1. Write a Java Program for Checking if a given string is null or contains only whitespace using user
defined function isNullOrEmpty().*/

public class NullCheck {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String str = sc.nextLine();

	        if (str == null || str.trim().isEmpty()) {
	            System.out.println("The string is null or empty (only whitespace).");
	        } else {
	            System.out.println("The string is not null and not empty.");
	        }

	        sc.close();
	    }
	}

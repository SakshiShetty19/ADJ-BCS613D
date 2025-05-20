/*Q7. Write a Java Program for Shortening a string to a specified length and adds an ellipsis using user
defined function truncate()*/


public class Truncate {
	    public static String truncate1(String input, int length) {
	        if (input.length() <= length) {
	            return input;
	        }
	        return input.substring(0, length) + "...";
	    }

	    public static void main(String[] args) {
	        String input = "Sakshi Shetty CSE";
	        int length = 10;
	        System.out.println("Input:"+input);
	        System.out.println(truncate1(input, length));
	    }
	}

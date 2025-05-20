/*Q8. Write a Java Program for Verifying if a string contains only numeric characters using user defined
function isNumeric()*/

public class IsNumeric {
	    public static boolean isNumeric1(String input) {
	        return input.matches("\\d+");
	    }

	    public static void main(String[] args) {
	        String input1 = "123456";
	        String input2 = "12abcd";
	        System.out.println("is input1 numeric "+isNumeric1(input1)); // true
	        System.out.println("is input2 numeric "+isNumeric1(input2)); // false
	    }
	}

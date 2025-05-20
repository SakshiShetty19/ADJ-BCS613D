/*1b. Array List programs
1. Write a java program for getting different colors through ArrayList interface and search whether
the color "Red" is available or not*/
package assignment;
import java.util.*;
public class IsRedFound {
	
	    public static void main(String[] args) {
	        ArrayList<String> colors = new ArrayList<>();
	        colors.add("Red");
	        colors.add("Green");
	        colors.add("Blue");
	        colors.add("Yellow");

	        boolean found = colors.contains("Red");
	        System.out.println("Is Red present? " + found);
	    }
	

}



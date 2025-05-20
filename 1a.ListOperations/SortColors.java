/*3. Write a java program for getting different colors through ArrayList interface and sort them
using Collections.sort( ArrayListObj)*/
import java.util.*;

public class SortColors
{
	public static void main(String[] args) {
		 
ArrayList<String> colors = new ArrayList<>();
        colors.add("Orange");
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
         System.out.println("UnSorted colors: " + colors);
        Collections.sort(colors);
        
        System.out.println("Sorted colors: " + colors);
	}
}

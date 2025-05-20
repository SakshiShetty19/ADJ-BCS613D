
/*2. Write a java program for getting different colors through ArrayList interface and remove the
2nd element and color "Blue" from the ArrayList*/
import java.util.*;

public class RemoveColors
{
	public static void main(String[] args) {
		  ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
         System.out.println("before removal: " + colors);
        colors.remove(1); // 2nd element (index 1)
        colors.remove("Blue");

        System.out.println("After removal: " + colors);
	}
}

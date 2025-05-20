/*5. Write a java program for getting different colors through ArrayList interface and delete nth
element from the ArrayList object by using remove by index*/
import java.util.*;

public class DeletenthIndex
{
	public static void main(String[] args) {
  ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");

        System.out.println("before deleting 3rd element: " + colors);
        int n = 2; // 3rd element (index 2)
        if (n < colors.size()) {
            colors.remove(n);
        }

        System.out.println("After deleting 3rd element: " + colors);
	}
}

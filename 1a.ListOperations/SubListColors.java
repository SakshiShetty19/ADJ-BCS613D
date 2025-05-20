/*4. Write a java program for getting different colors through ArrayList interface and extract the
elements 1st and 2nd from the ArrayList object by using SubList()*/
import java.util.*;

public class SubListColors
{
	public static void main(String[] args) {
		    ArrayList<String> colors = new ArrayList<>();
        colors.add("Pink");
        colors.add("Purple");
        colors.add("Black");
        colors.add("White");

        List<String> sub = colors.subList(0, 2); // 1st and 2nd
        System.out.println("Sublist (1st and 2nd): " + sub);
	}
}

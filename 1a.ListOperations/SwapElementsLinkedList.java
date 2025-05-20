/*5. Write a Java program that swaps two elements ( first and third elements ) in a linked list ( using Collections.swap(l_list, 0, 2))*/
import java.util.*;

public class SwapElementsLinkedList
{
	public static void main(String[] args) {
      LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        System.out.println("Before swapping: " + list);
        Collections.swap(list, 0, 2); // swap 1st and 3rd
        System.out.println("After swapping 1st and 3rd: " + list);
        
	}
}

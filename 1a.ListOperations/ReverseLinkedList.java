/*2. Write a Java program to iterate a linked list in reverse order (using objlist.descendingIterator())*/
import java.util.*;

public class ReverseLinkedList
{
	public static void main(String[] args) {
  LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        System.out.println("Original list: " + list);
        System.out.println("Reverse order:");

        Iterator<String> it = list.descendingIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
	}
}

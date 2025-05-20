/*1c. Linked List Programs

1. Write a Java program to iterate through all elements in a linked list starting at the specified position ( 2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))*/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
     LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Green");
        list.add("Blue");
        list.add("Yellow");

        System.out.println("Full list: " + list);
        System.out.println("Iterating from 2nd position:");

        Iterator<String> it = list.listIterator(1); // index 1 = 2nd element
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
	}
}


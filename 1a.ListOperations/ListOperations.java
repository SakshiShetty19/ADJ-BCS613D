/*1.a Develop a Java program for adding elements [Apple, Banana, Orange] into an ArrayList
and a LinkedList to perform the following operations with different functions directed as
follows
1. Adding elements, 2. Adding element at specific index, 3. Adding multiple elements, 4.
Accessing elements,5. Updating elements, 6. Removing elements, 7. Searching elements, 8. List
size, 9. Iterating over list, 10. Using Iterator, 11. Sorting, 12. Sublist, 13. Clearing the list*/
package assignment;
import java.util.*;
public class ListOperations {
	 public static void main(String[] args) {
	        // 1. Adding elements
	        List<String> aList = new ArrayList<>();
	        List<String> lList = new LinkedList<>();

	        aList.add("Apple");
	        aList.add("Banana");
	        aList.add("Orange");

	        lList.add("Apple");
	        lList.add("Banana");
	        lList.add("Orange");

	        System.out.println("ArrayList: " + aList);
	        System.out.println("LinkedList: " + lList);

	        // 2. Adding element at specific index
	        aList.add(1, "Mango");
	        lList.add(1, "Mango");

	        // 3. Adding multiple elements
	        List<String> extra = Arrays.asList("Grapes", "Pineapple");
	        aList.addAll(extra);
	        lList.addAll(extra);

	        // 4. Accessing elements
	        System.out.println("First element in ArrayList: " + aList.get(0));
	        System.out.println("First element in LinkedList: " + lList.get(0));

	        // 5. Updating elements
	        aList.set(0, "Kiwi");
	        lList.set(0, "Kiwi");

	        // 6. Removing elements
	        aList.remove("Banana");
	        lList.remove("Banana");

	        // 7. Searching elements
	        boolean a = aList.contains("Orange");
	        boolean b = lList.contains("Orange");
	        System.out.println("Orange in ArrayList? " + a);
	        System.out.println("Orange in LinkedList? " + b);

	        // 8. List size
	        System.out.println("Size of ArrayList: " + aList.size());
	        System.out.println("Size of LinkedList: " + lList.size());

	        // 9. Iterating over list using for-each
	        System.out.println("ArrayList items:");
	        for (String item : aList) {
	            System.out.println(item);
	        }

	        // 10. Using Iterator
	        System.out.println("LinkedList items using Iterator:");
	        Iterator<String> it = lList.iterator();
	        while (it.hasNext()) {
	            System.out.println(it.next());
	        }

	        // 11. Sorting
	        Collections.sort(aList);
	        Collections.sort((LinkedList<String>) lList);
	        System.out.println("Sorted ArrayList: " + aList);
	        System.out.println("Sorted LinkedList: " + lList);

	        // 12. Sublist
	        List<String> subA = aList.subList(1, 3);
	        List<String> subL = lList.subList(1, 3);
	        System.out.println("Sublist of ArrayList: " + subA);
	        System.out.println("Sublist of LinkedList: " + subL);

	        // 13. Clearing the list
	        aList.clear();
	        lList.clear();
	        System.out.println("ArrayList after clearing: " + aList);
	        System.out.println("LinkedList after clearing: " + lList);
	    }

}


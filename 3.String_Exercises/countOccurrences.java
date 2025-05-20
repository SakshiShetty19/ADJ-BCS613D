/*Q2. Write a Java Program for Counting how many times a substring appears in a main string
using user defined function countOccurrences()*/

public class countOccurrences {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter the main string: ");
	        String str = sc.nextLine();

	        System.out.print("Enter the substring to count: ");
	        String sub = sc.nextLine();

	        int c = 0;
	        int i = 0;

	        if (str != null && sub != null && !sub.isEmpty()) {
	            while ((i = str.indexOf(sub, i)) != -1) {
	                c++;
	                i += sub.length();
	            }
	        }

	        System.out.println("The substring appears " + c + " times.");

	        sc.close();
	    }
	}

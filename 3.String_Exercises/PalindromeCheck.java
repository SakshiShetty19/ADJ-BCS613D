/*Q4. Write a Java Program for Checking if a string reads the same backward as forward (ignoring case
and punctuation) using user defined function isPalindrome():*/
import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int i = 0;
        int j = str.length() - 1;
        boolean isPal = true;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                isPal = false;
                break;
            }
            i++;
            j--;
        }

        if (isPal) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }

        sc.close();
    }
}

/*Q3. Write a Java Program for Reversing the characters in a string using user defined function
reverseString().*/

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String rev = reverseString(str);
        System.out.println("Reversed string: " + rev);

        sc.close();
    }

    static String reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
        return rev;
    }
}

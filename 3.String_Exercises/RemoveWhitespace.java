/*Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined
function removeWhitespace()*/
import java.util.Scanner;

public class RemoveWhitespace {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        String res = str.replaceAll("\\s", "");
        System.out.println("String after removing whitespace: " + res);

        sc.close();
    }
}

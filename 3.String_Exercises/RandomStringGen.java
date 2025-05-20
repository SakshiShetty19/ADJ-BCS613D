/*Q9. Write a Java Program for Creating a random string of a specified length using user defined
function generateRandomString()*/
import java.util.Random;

public class RandomStringGen {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomString1(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int length = 8;
        System.out.println("random generated string of lenth 8 is "+generateRandomString1(length));
    }
}

//3c. String Exercise progams
/*Q6. Write a Java Program for Capitalizing the first letter of each word. using user defined function
capitalizeWords() */
public class FirstCapital {
    public static String capitalizeWords1(String input) {
        String[] words = input.split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    capitalized.append(word.substring(1).toLowerCase());
                }
                capitalized.append(" ");
            }
        }
        return capitalized.toString().trim();
    }

    public static void main(String[] args) {
        String input = "java programming language";
       System.out.println("before captalization " +input);
        System.out.println(capitalizeWords1(input));
    }
}

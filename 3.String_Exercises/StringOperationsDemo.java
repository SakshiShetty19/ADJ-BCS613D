/*2 a. Develop a java program for performing various string operations with different string
handling functions directed as follows
String Creation and Basic Operations, Length and Character Access, String Comparison, String
Searching, Substring Operations , String Modification, Whitespace Handling, String
Concatenation, String Splitting, StringBuilder Demo, String Formatting , Validate Email with
contains( ) and startsWith() and endsWith()*/

public class StringOperationsDemo {

    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String name = "Sakshi";
        String course = new String("Computer Science");
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);

        // 2. Length and Character Access
        System.out.println("Length of name: " + name.length());
        System.out.println("Character at index 2 in name: " + name.charAt(2));

        // 3. String Comparison
        String nameCheck = "Sakshi";
        System.out.println("name equals nameCheck? " + name.equals(nameCheck));
        System.out.println("name equalsIgnoreCase 'sakshi'? " + name.equalsIgnoreCase("sakshi"));
        System.out.println("name compareTo course: " + name.compareTo(course));

        // 4. String Searching
        String intro = "Sakshi is learning Java at Alvas Institute";
        System.out.println("Index of 'Java' in intro: " + intro.indexOf("Java"));
        System.out.println("Does intro contain 'Sakshi'? " + intro.contains("Sakshi"));

        // 5. Substring Operations
        System.out.println("Substring from index 10 in intro: " + intro.substring(10));
        System.out.println("Substring from index 0 to 6 in intro: " + intro.substring(0, 6));

        // 6. String Modification
        String modifiedIntro = intro.replace("Java", "Python");
        System.out.println("After replace: " + modifiedIntro);
        System.out.println("Uppercase: " + intro.toUpperCase());
        System.out.println("Lowercase: " + intro.toLowerCase());

        // 7. Whitespace Handling
        String messy = "   Sakshi studies at Alvas   ";
        System.out.println("Original: '" + messy + "'");
        System.out.println("Trimmed: '" + messy.trim() + "'");

        // 8. String Concatenation
        String info = name + " is a " + course + " student.";
        System.out.println("Concatenated Info: " + info);
        System.out.println("Using concat(): " + name.concat(" is learning ").concat("Java"));

        // 9. String Splitting
        String sentence = "Sakshi studies at Alvas Institute and loves Java";
        String[] words = sentence.split(" ");
        System.out.println("Words in sentence:");
        for (String word : words) {
            System.out.println(word);
        }

        // 10. StringBuilder Demo
        StringBuilder builder = new StringBuilder("Sakshi");
        builder.append(" from Alvas");
        builder.insert(6, " R ");
        builder.replace(0, 6, "She");
        builder.delete(3, 4);
        System.out.println("StringBuilder result: " + builder.toString());

        // 11. String Formatting
        String institute = "Alvas Institute";
        int year = 2025;
        String formatted = String.format("Student: %s, Institute: %s, Year: %d", name, institute, year);
        System.out.println("Formatted String: " + formatted);

        // 12. Validate Email
        String email = "sakshi@alvas.edu";
        boolean valid = email.contains("@") && email.startsWith("sakshi") && email.endsWith(".edu");
        System.out.println("Email: " + email);
        System.out.println("Is valid email? " + valid);
    }
}

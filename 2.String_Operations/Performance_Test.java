/*2.b. Develop a Java program to make a Performance Test on StringBuffer and StringBuilder for
appending the string ‘AIET’ for 10000 times both in the StringBuffer and StringBuilder. Justify
your answer which one is better.*/


public class PerformanceTest {

    public static void main(String[] args) {

        String input = "SakshiLearningJava";
        int times = 10000;

        // Using StringBuffer
        StringBuffer buffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();

        for (int i = 0; i < times; i++) {
            buffer.append(input);
        }

        long endTimeBuffer = System.nanoTime();
        long timeTakenBuffer = endTimeBuffer - startTimeBuffer;
        System.out.println("Time taken by StringBuffer: " + timeTakenBuffer + " ns");

        // Using StringBuilder
        StringBuilder builder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();

        for (int i = 0; i < times; i++) {
            builder.append(input);
        }

        long endTimeBuilder = System.nanoTime();
        long timeTakenBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("Time taken by StringBuilder: " + timeTakenBuilder + " ns");

        // Final result
        if (timeTakenBuilder < timeTakenBuffer) {
            System.out.println("StringBuilder is faster than StringBuffer.");
        } else {
            System.out.println("StringBuffer is faster than StringBuilder.");
        }
    }
}

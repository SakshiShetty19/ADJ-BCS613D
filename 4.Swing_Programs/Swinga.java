/*4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing
Programming in Blue color plain font with font size of 32 using Jframe and Jlabel*/


import javax.swing.*;
import java.awt.*;

public class HelloSwing {

    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Welcome");

        // Create a JLabel with the desired message
        JLabel label = new JLabel("Hello! VI B, Welcome to Swing Programming", SwingConstants.CENTER);

        // Set font: plain, size 32
        label.setFont(new Font("Arial", Font.PLAIN, 32));

        // Set text color to blue
        label.setForeground(Color.BLUE);

        // Add the label to the frame
        frame.add(label);

        // Set frame size and behavior
        frame.setSize(800, 200); // width x height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Display the frame
    }
}

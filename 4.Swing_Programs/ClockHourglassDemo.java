/*4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour
Glass is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is
pressed by implementing the event handling mechanism with addActionListener( ).*/
package Swings;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClockHourglassDemo  extends JFrame implements ActionListener{

	JButton digitalClockButton, hourGlassButton;

    public ClockHourglassDemo() {
        // Frame settings
        setTitle("Clock and Hour Glass Demo");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Load and resize images (replace with valid image paths)
        ImageIcon digitalClockIcon = resizeIcon("digital_clock.jpeg", 50, 50);
        ImageIcon hourGlassIcon = resizeIcon("hourglass.jpg", 50, 50);

        // Create buttons with resized images
        digitalClockButton = new JButton("Digital Clock", digitalClockIcon);
        hourGlassButton = new JButton("Hour Glass", hourGlassIcon);

        // Add action listeners
        digitalClockButton.addActionListener(this);
        hourGlassButton.addActionListener(this);

        // Add buttons to frame
        add(digitalClockButton);
        add(hourGlassButton);
    }

    // Method to resize image
    private ImageIcon resizeIcon(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    // Event handling
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == digitalClockButton) {
            JOptionPane.showMessageDialog(this, "Digital Clock is pressed");
        } else if (e.getSource() == hourGlassButton) {
            JOptionPane.showMessageDialog(this, "Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClockHourglassDemo().setVisible(true);
        });
    }


}

/*
 5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada,
Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and
display the capital of the countries on console whenever the countries are selected on the list.
o/p
Capital of USA is: Washington D.C.
Capital of India is: New Delhi
Capital of Vietnam is: Hanoi
Capital of Denmark is: Copenhagen
Capital of Africa is: Addis Ababa
Capital of Japan is: Tokyo
Capital of Greenland is: Nuuk
Capital of Singapore is: Singapore
 */
package swings;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.awt.*;

public class JListExample2 extends JFrame {
    private JList<String> countryList;

    public JListExample2() {
        // Mapping of countries to capitals
        Map<String, String> capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        // Creating the list model
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String country : capitals.keySet()) {
            listModel.addElement(country);
        }

        countryList = new JList<>(listModel);
        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    List<String> selected = countryList.getSelectedValuesList();
                    for (String country : selected) {
                        System.out.println("Capital of " + country + " is: " + capitals.get(country));
                    }
                    System.out.println(); 
                }
            }
        });

        add(new JScrollPane(countryList));
        setTitle("Country Capital List");
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JListExample2();
    }
}

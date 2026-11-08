package borderlayoutactivity;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutActivity extends JFrame {

    private JButton northButton;
    private JButton southButton;
    private JButton eastButton;
    private JButton westButton;
    private JButton centerButton;

    // Constructor
    public BorderLayoutActivity() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        northButton = new JButton("NORTH");
        southButton = new JButton("SOUTH");
        eastButton = new JButton("EAST");
        westButton = new JButton("WEST");
        centerButton = new JButton("CENTER");
    }

    // Arranges the buttons using BorderLayout
    private void layoutComponents() {
        setLayout(new BorderLayout());

        add(northButton, BorderLayout.NORTH);
        add(southButton, BorderLayout.SOUTH);
        add(eastButton, BorderLayout.EAST);
        add(westButton, BorderLayout.WEST);
        add(centerButton, BorderLayout.CENTER);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("BorderLayout Activity");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new BorderLayoutActivity();
    }
}
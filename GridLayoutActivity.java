package gridlayoutactivity;

import javax.swing.*;
import java.awt.*;

public class GridLayoutActivity extends JFrame {

    private JLabel titleLabel;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    // Constructor
    public GridLayoutActivity() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("GRID LAYOUT", SwingConstants.CENTER);

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
    }

    // Arranges the components
    private void layoutComponents() {
        setLayout(new BorderLayout());

        // Text at the top
        add(titleLabel, BorderLayout.NORTH);

        // Panel for the 3 x 3 buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);

        // Buttons in the center
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("GridLayout Activity");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new GridLayoutActivity();
    }
}
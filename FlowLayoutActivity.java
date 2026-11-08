package flowlayoutactivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FlowLayoutActivity extends JFrame implements ActionListener {
    private JLabel titleLabel;
    
    private JButton leftButton;
    private JButton centerButton;
    private JButton rightButton;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;

    private JPanel buttonPanel;

    // Constructor
    public FlowLayoutActivity() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("FLOW LAYOUT");
        
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");
        button4 = new JButton("Button 4");
        button5 = new JButton("Button 5");
        
        leftButton = new JButton("LEFT");
        centerButton = new JButton("CENTER");
        rightButton = new JButton("RIGHT");

        leftButton.addActionListener(this);
        centerButton.addActionListener(this);
        rightButton.addActionListener(this);
    }

    // Arranges the components
private void layoutComponents() {
    setLayout(null);
    
    // Panel for the five buttons
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

    buttonPanel.setBounds(20, 40, 400, 80);

    buttonPanel.add(button1);
    buttonPanel.add(button2);
    buttonPanel.add(button3);
    buttonPanel.add(button4);
    buttonPanel.add(button5);

    // Alignment buttons using setBounds
    titleLabel.setBounds(175, 10, 180, 25);
    leftButton.setBounds(60, 150, 90, 30);
    centerButton.setBounds(160, 150, 100, 30);
    rightButton.setBounds(270, 150, 90, 30);

    add(titleLabel);
    add(buttonPanel);
    add(leftButton);
    add(centerButton);
    add(rightButton);
}

    // Changes the alignment when a button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftButton) {
            buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        } else if (e.getSource() == centerButton) {
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        } else if (e.getSource() == rightButton) {
            buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        }

        // Refresh the layout
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("FlowLayout Activity");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Main method
    public static void main(String[] args) {
        new FlowLayoutActivity();
    }
}
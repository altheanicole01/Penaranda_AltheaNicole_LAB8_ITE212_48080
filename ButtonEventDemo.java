package buttoneventdemo;

import javax.swing.*;
import java.awt.event.*;

public class ButtonEventDemo extends JFrame implements ActionListener {

    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;
    private JLabel resultLabel;

    // Constructor
    public ButtonEventDemo() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        redButton = new JButton("RED");
        greenButton = new JButton("GREEN");
        blueButton = new JButton("BLUE");
        resultLabel = new JLabel("Selected: ");

        // Each button has an event listener
        redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
    }

    // Arranges the components in fixed positions
    private void layoutComponents() {
        setLayout(null);

        redButton.setBounds(40, 50, 90, 30);
        greenButton.setBounds(150, 50, 90, 30);
        blueButton.setBounds(260, 50, 90, 30);
        resultLabel.setBounds(40, 110, 300, 30);

        add(redButton);
        add(greenButton);
        add(blueButton);
        add(resultLabel);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Button Event Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Determines which button generated the event
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redButton) {
            resultLabel.setText("Selected: RED");
        } else if (e.getSource() == greenButton) {
            resultLabel.setText("Selected: GREEN");
        } else if (e.getSource() == blueButton) {
            resultLabel.setText("Selected: BLUE");
        }
    }

    // Main method
    public static void main(String[] args) {
        new ButtonEventDemo();
    }
}
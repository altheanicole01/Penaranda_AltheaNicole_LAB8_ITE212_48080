package studentnameform;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentNameForm extends JFrame implements ActionListener {

    private JLabel nameLabel;
    private JTextField nameField;
    private JButton displayButton;
    private JLabel resultLabel;

    // Constructor
    public StudentNameForm() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(20);
        displayButton = new JButton("DISPLAY");
        resultLabel = new JLabel("");

        displayButton.addActionListener(this);
    }

    // Arranges and adds the components to the frame
    private void layoutComponents() {
        setLayout(null);
        
        nameLabel.setBounds(50, 30, 120, 25);
        nameField.setBounds(180, 30, 150, 25);
        displayButton.setBounds(130, 70, 100, 30);
        resultLabel.setBounds(50, 115, 250, 25);
        
        add(nameLabel);
        add(nameField);
        add(displayButton);
        add(resultLabel);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Student Name Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Runs when the DISPLAY button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();

        if (name.isEmpty()) {
            resultLabel.setText("Please enter your name.");
        } else {
            resultLabel.setText("Welcome, " + name + "!");
        }
    }

    // Main method
    public static void main(String[] args) {
        new StudentNameForm();
    }
}
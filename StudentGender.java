package studentgender;

import javax.swing.*;
import java.awt.event.*;

public class StudentGender extends JFrame implements ItemListener {

    private JLabel titleLabel;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton otherRadioButton;

    private ButtonGroup genderGroup;
    private JLabel resultLabel;

    // Constructor
    public StudentGender() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("Select your gender:");

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        otherRadioButton = new JRadioButton("Prefer not to say");

        resultLabel = new JLabel("Selected: None");

        // Put the radio buttons in the same group
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderGroup.add(otherRadioButton);

        // Register the ItemListener for each radio button
        maleRadioButton.addItemListener(this);
        femaleRadioButton.addItemListener(this);
        otherRadioButton.addItemListener(this);
    }

    // Arranges the components in fixed positions
    private void layoutComponents() {
        setLayout(null);

        titleLabel.setBounds(40, 30, 200, 25);

        maleRadioButton.setBounds(40, 70, 80, 25);
        femaleRadioButton.setBounds(125, 70, 90, 25);
        otherRadioButton.setBounds(220, 70, 150, 25);

        resultLabel.setBounds(40, 120, 300, 25);

        add(titleLabel);
        add(maleRadioButton);
        add(femaleRadioButton);
        add(otherRadioButton);
        add(resultLabel);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Student Gender");
        setSize(420, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Updates the result label when the selection changes
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == maleRadioButton) {
                resultLabel.setText("Selected: Male");
            } else if (e.getSource() == femaleRadioButton) {
                resultLabel.setText("Selected: Female");
            } else if (e.getSource() == otherRadioButton) {
                resultLabel.setText("Selected: Prefer not to say");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new StudentGender();
    }
}
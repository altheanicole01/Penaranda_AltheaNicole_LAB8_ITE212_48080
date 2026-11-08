package courseselection;

import javax.swing.*;
import java.awt.event.*;

public class CourseSelection extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JComboBox<String> courseComboBox;
    private JButton selectButton;
    private JLabel resultLabel;

    // Constructor
    public CourseSelection() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("Select your course:");

        courseComboBox = new JComboBox<>();

        // Add the courses to the drop-down list
        courseComboBox.addItem("BS Information Systems");
        courseComboBox.addItem("BS Computer Science");
        courseComboBox.addItem("BS Information Technology");
        courseComboBox.addItem("Associate in Computer Technology");

        selectButton = new JButton("SELECT");
        resultLabel = new JLabel("Selected Course: ");

        selectButton.addActionListener(this);
    }

    // Arranges the components in fixed positions
    private void layoutComponents() {
        setLayout(null);

        titleLabel.setBounds(40, 30, 200, 25);
        courseComboBox.setBounds(40, 70, 250, 30);
        selectButton.setBounds(40, 115, 100, 30);
        resultLabel.setBounds(40, 160, 350, 25);

        add(titleLabel);
        add(courseComboBox);
        add(selectButton);
        add(resultLabel);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Course Selection");
        setSize(400, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Runs when the SELECT button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCourse = (String) courseComboBox.getSelectedItem();

        resultLabel.setText("Selected Course: " + selectedCourse);
    }

    // Main method
    public static void main(String[] args) {
        new CourseSelection();
    }
}
package studentcomments;

import javax.swing.*;
import java.awt.event.*;

public class StudentComments extends JFrame implements ActionListener {

    private JLabel titleLabel;
    private JTextArea commentsTextArea;
    private JScrollPane scrollPane;
    private JButton clearButton;

    // Constructor
    public StudentComments() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("Enter your comments:");

        // JTextArea with 5 rows and 20 columns
        commentsTextArea = new JTextArea(5, 20);
        commentsTextArea.setLineWrap(true);
        commentsAreaWrapStyle();

        // Place the JTextArea inside a JScrollPane
        scrollPane = new JScrollPane(commentsTextArea);

        clearButton = new JButton("CLEAR");

        clearButton.addActionListener(this);
    }

    // Enables word wrapping for the text area
    private void commentsAreaWrapStyle() {
        commentsTextArea.setWrapStyleWord(true);
    }

    // Arranges the components in fixed positions
    private void layoutComponents() {
        setLayout(null);

        titleLabel.setBounds(40, 30, 200, 25);
        scrollPane.setBounds(40, 70, 300, 150);
        clearButton.setBounds(40, 240, 100, 30);

        add(titleLabel);
        add(scrollPane);
        add(clearButton);
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Student Comments");
        setSize(400, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Clears the text area when CLEAR is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        commentsTextArea.setText("");
    }

    // Main method
    public static void main(String[] args) {
        new StudentComments();
    }
}
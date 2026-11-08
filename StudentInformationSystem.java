package studentinformationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentInformationSystem extends JFrame implements ActionListener, ItemListener {

    // Labels
    private JLabel titleLabel;
    private JLabel studentIDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel programLabel;
    private JLabel genderLabel;
    private JLabel skillsLabel;
    private JLabel remarksLabel;
    private JLabel resultLabel;

    // Text fields
    private JTextField studentIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;

    // Combo box
    private JComboBox<String> programComboBox;

    // Radio buttons
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JRadioButton preferNotToSayRadioButton;
    private ButtonGroup genderGroup;

    // Checkboxes
    private JCheckBox javaCheckBox;
    private JCheckBox webDevelopmentCheckBox;
    private JCheckBox databaseCheckBox;
    private JCheckBox networkingCheckBox;

    // Text areas
    private JTextArea remarksTextArea;
    private JScrollPane remarksScrollPane;

    private JTextArea resultTextArea;
    private JScrollPane resultScrollPane;

    // Buttons
    private JButton registerButton;
    private JButton clearButton;
    private JButton exitButton;

    // Constructor
    public StudentInformationSystem() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("STUDENT INFORMATION SYSTEM", SwingConstants.CENTER);

        studentIDLabel = new JLabel("Student ID:");
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        programLabel = new JLabel("Program:");
        genderLabel = new JLabel("Gender:");
        skillsLabel = new JLabel("Skills:");
        remarksLabel = new JLabel("");
        resultLabel = new JLabel("");

        // Create the student ID input field
        studentIDField = new JTextField(15);

        // Create the first name input field
        firstNameField = new JTextField(15);

        // Create the last name input field
        lastNameField = new JTextField(15);

        // Create the program drop-down list
        programComboBox = new JComboBox<>();
        programComboBox.addItem("BS Information Systems");
        programComboBox.addItem("BS Computer Science");
        programComboBox.addItem("BS Information Technology");
        programComboBox.addItem("ACT");

        // Create gender radio buttons
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferNotToSayRadioButton = new JRadioButton("Prefer not to say");

        // Put radio buttons in one group
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderGroup.add(preferNotToSayRadioButton);

        // Create skills checkboxes
        javaCheckBox = new JCheckBox("Java");
        webDevelopmentCheckBox = new JCheckBox("Web Development");
        databaseCheckBox = new JCheckBox("Database");
        networkingCheckBox = new JCheckBox("Networking");

        // Create remarks text area and scroll pane
        remarksTextArea = new JTextArea(10, 20);
        remarksTextArea.setLineWrap(true);
        remarksTextArea.setWrapStyleWord(true);
        remarksScrollPane = new JScrollPane(remarksTextArea);

        // Create result text area and scroll pane
        resultTextArea = new JTextArea(10, 40);
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);
        resultScrollPane = new JScrollPane(resultTextArea);

        // Create buttons
        registerButton = new JButton("REGISTER");
        clearButton = new JButton("CLEAR");
        exitButton = new JButton("EXIT");

        // Register ActionListener for buttons
        registerButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        // Register ItemListener for checkboxes
        javaCheckBox.addItemListener(this);
        webDevelopmentCheckBox.addItemListener(this);
        databaseCheckBox.addItemListener(this);
        networkingCheckBox.addItemListener(this);
    }

    // Arranges the components horizontally
    private void layoutComponents() {
        // Main window uses BorderLayout
        setLayout(new BorderLayout(10, 10));

        // Title panel at the top
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Student information panel on the left
        JPanel studentInfoPanel = new JPanel();
        studentInfoPanel.setLayout(new GridLayout(4, 1, 5, 5));
        studentInfoPanel.setBorder(BorderFactory.createTitledBorder("Student Information"));

        JPanel studentIDPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        studentIDPanel.add(studentIDLabel);
        studentIDPanel.add(studentIDField);

        JPanel firstNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        firstNamePanel.add(firstNameLabel);
        firstNamePanel.add(firstNameField);

        JPanel lastNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lastNamePanel.add(lastNameLabel);
        lastNamePanel.add(lastNameField);

        studentInfoPanel.add(studentIDPanel);
        studentInfoPanel.add(firstNamePanel);
        studentInfoPanel.add(lastNamePanel);

        // Program, gender, and skills panel in the center
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(3, 1, 5, 5));
        middlePanel.setBorder(BorderFactory.createTitledBorder("Program, Gender, and Skills"));

        JPanel programPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        programPanel.add(programLabel);
        programPanel.add(programComboBox);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(genderLabel);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.add(preferNotToSayRadioButton);

        JPanel skillsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        skillsPanel.add(skillsLabel);
        skillsPanel.add(javaCheckBox);
        skillsPanel.add(webDevelopmentCheckBox);
        skillsPanel.add(databaseCheckBox);
        skillsPanel.add(networkingCheckBox);

        middlePanel.add(programPanel);
        middlePanel.add(genderPanel);
        middlePanel.add(skillsPanel);

        // Remarks panel on the right
        JPanel remarksPanel = new JPanel(new BorderLayout(5, 5));
        remarksPanel.setBorder(BorderFactory.createTitledBorder("Remarks"));
        remarksPanel.add(remarksLabel, BorderLayout.NORTH);
        remarksPanel.add(remarksScrollPane, BorderLayout.CENTER);

        // Put the three sections side by side
        JPanel mainPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        mainPanel.add(studentInfoPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(remarksPanel);

        // Put the sections and summary together
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.add(mainPanel, BorderLayout.CENTER);
        contentPanel.add(resultPanel(), BorderLayout.SOUTH);

        add(contentPanel, BorderLayout.CENTER);

        // Button panel at the very bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Creates the registration summary panel
    private JPanel resultPanel() {
        JPanel resultPanel = new JPanel(new BorderLayout(5, 5));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Registration Summary"));

        resultPanel.add(resultLabel, BorderLayout.NORTH);
        resultPanel.add(resultScrollPane, BorderLayout.CENTER);

        return resultPanel;
    }

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Student Information System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Handles button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            registerStudent();
        } else if (e.getSource() == clearButton) {
            clearForm();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    // Collects and displays the student information
    private void registerStudent() {
        String studentID = studentIDField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String program = (String) programComboBox.getSelectedItem();

        String gender = "None";

        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (preferNotToSayRadioButton.isSelected()) {
            gender = "Prefer not to say";
        }

        String skills = "";

        if (javaCheckBox.isSelected()) {
            skills += "Java\n";
        }

        if (webDevelopmentCheckBox.isSelected()) {
            skills += "Web Development\n";
        }

        if (databaseCheckBox.isSelected()) {
            skills += "Database\n";
        }

        if (networkingCheckBox.isSelected()) {
            skills += "Networking\n";
        }

        String remarks = remarksTextArea.getText();

        String summary = "STUDENT REGISTRATION SUMMARY\n\n"
                + "Student ID: " + studentID + "\n"
                + "Name: " + firstName + " " + lastName + "\n"
                + "Program: " + program + "\n"
                + "Gender: " + gender + "\n\n"
                + "Skills:\n"
                + skills + "\n"
                + "Remarks:\n"
                + remarks;

        resultTextArea.setText(summary);
    }

    // Clears all form fields and selections
    private void clearForm() {
        studentIDField.setText("");
        firstNameField.setText("");
        lastNameField.setText("");

        programComboBox.setSelectedIndex(0);

        genderGroup.clearSelection();

        javaCheckBox.setSelected(false);
        webDevelopmentCheckBox.setSelected(false);
        databaseCheckBox.setSelected(false);
        networkingCheckBox.setSelected(false);

        remarksTextArea.setText("");
        resultTextArea.setText("Form cleared.");
    }

    // Responds when a skill checkbox is selected or deselected
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            resultTextArea.setText("Skill selected: " + ((JCheckBox) e.getSource()).getText());
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
            resultTextArea.setText("Skill deselected: " + ((JCheckBox) e.getSource()).getText());
        }
    }
    

    // Main method
    public static void main(String[] args) {
        new StudentInformationSystem();
    }
}
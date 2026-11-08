package studentskills;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentSkills extends JFrame implements ItemListener {

    private JLabel titleLabel;
    private JCheckBox javaCheckBox;
    private JCheckBox databaseCheckBox;
    private JCheckBox cybersecurityCheckBox;
    private JCheckBox networkingCheckBox;
    private JCheckBox webDevelopmentCheckBox;
    private JTextArea outputArea;

    // Constructor
    public StudentSkills() {
        initComponents();
        layoutComponents();
        setupFrame();
    }

    // Creates all GUI components
    private void initComponents() {
        titleLabel = new JLabel("Select your skills:");
        
        javaCheckBox = new JCheckBox("Java");
        databaseCheckBox = new JCheckBox("Database");
        cybersecurityCheckBox = new JCheckBox("Cybersecurity");
        networkingCheckBox = new JCheckBox("Networking");
        webDevelopmentCheckBox = new JCheckBox("Web Development");

        outputArea = new JTextArea(8, 30);
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        

        // Each checkbox has an item listener
        javaCheckBox.addItemListener(this);
        databaseCheckBox.addItemListener(this);
        cybersecurityCheckBox.addItemListener(this);
        networkingCheckBox.addItemListener(this);
        webDevelopmentCheckBox.addItemListener(this);
    }

    // Arranges the components in the frame
private void layoutComponents() {
    setLayout(null);
    
    titleLabel.setBounds(40, 10, 180, 25);
    javaCheckBox.setBounds(40, 40, 180, 25);
    databaseCheckBox.setBounds(40, 60, 180, 25);
    cybersecurityCheckBox.setBounds(40, 80, 180, 25);
    networkingCheckBox.setBounds(40, 100, 180, 25);
    webDevelopmentCheckBox.setBounds(40, 120, 180, 25);

    outputArea.setBounds(40, 150, 250, 100);

    add(titleLabel);
    add(javaCheckBox);
    add(databaseCheckBox);
    add(cybersecurityCheckBox);
    add(networkingCheckBox);
    add(webDevelopmentCheckBox);
    add(outputArea);
}

    // Sets the frame properties and displays it
    private void setupFrame() {
        setTitle("Student Skills");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // Updates the output area whenever a checkbox changes
    @Override
    public void itemStateChanged(ItemEvent e) {
        String selectedSkills = "Selected Skills:\n";

        if (javaCheckBox.isSelected()) {
            selectedSkills += "Java\n";
        }

        if (databaseCheckBox.isSelected()) {
            selectedSkills += "Database\n";
        }

        if (cybersecurityCheckBox.isSelected()) {
            selectedSkills += "Cybersecurity\n";
        }

        if (networkingCheckBox.isSelected()) {
            selectedSkills += "Networking\n";
        }

        if (webDevelopmentCheckBox.isSelected()) {
            selectedSkills += "Web Development\n";
        }

        outputArea.setText(selectedSkills);
    }

    // Main method
    public static void main(String[] args) {
        new StudentSkills();
    }
}
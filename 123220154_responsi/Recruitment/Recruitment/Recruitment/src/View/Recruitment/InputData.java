package View.Recruitment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InputData extends JFrame {
    private JTextField nameField = new JTextField(20);
    private JComboBox<String> pathField = new JComboBox<>(new String[]{"Android Developer", "Web Developer"});
    private JTextField writingExamField = new JTextField(5);
    private JTextField codingTestField = new JTextField(5);
    private JTextField interviewTestField = new JTextField(5);
    private JButton submitButton = new JButton("Submit");

    public InputData() {
        setTitle("Candidate Recruitment System");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Path:"));
        panel.add(pathField);
        panel.add(new JLabel("Writing Exam:"));
        panel.add(writingExamField);
        panel.add(new JLabel("Coding Test:"));
        panel.add(codingTestField);
        panel.add(new JLabel("Interview Test:"));
        panel.add(interviewTestField);
        panel.add(new JLabel(""));
        panel.add(submitButton);
        add(panel);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getPath() {
        return (String) pathField.getSelectedItem();
    }

    public float getWritingExam() {
        return Float.parseFloat(writingExamField.getText());
    }

    public float getCodingTest() {
        return Float.parseFloat(codingTestField.getText());
    }

    public float getInterviewTest() {
        return Float.parseFloat(interviewTestField.getText());
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
    
}

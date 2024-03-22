package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InternshipApplicationUI extends JFrame implements ActionListener {
    // Components
    private JTextField nameField, nimField, writingField, codingField, interviewField;
    private JButton calculateButton;
    private JLabel resultLabel;

    // Constructor
    public InternshipApplicationUI() {
        setTitle("Aplikasi Penghitung Nilai");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2));

        // Labels
        JLabel nameLabel = new JLabel("Nama:");
        JLabel nimLabel = new JLabel("NIM:");
        JLabel writingLabel = new JLabel("Writing Test:");
        JLabel codingLabel = new JLabel("Coding Test:");
        JLabel interviewLabel = new JLabel("Interview Test:");
        JLabel blankLabel = new JLabel("");
        JLabel resultTitleLabel = new JLabel("Hasil:");
        resultLabel = new JLabel("");

        // Text fields
        nameField = new JTextField();
        nimField = new JTextField();
        writingField = new JTextField();
        codingField = new JTextField();
        interviewField = new JTextField();

        // Button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // tambahkan komponen ke frame

        add(nameLabel);
        add(nameField);
        add(nimLabel);
        add(nimField);
        add(writingLabel);
        add(writingField);
        add(codingLabel);
        add(codingField);
        add(interviewLabel);
        add(interviewField);
        add(blankLabel);
        add(calculateButton);
        add(resultTitleLabel);
        add(resultLabel);

        nameField.setBounds(getBounds().width / 2, 20, 100, 20);
        nimField.setBounds(getBounds().width / 2, 50, 200, 20);
        writingField.setBounds(getBounds().width / 2, 80, 200, 20);
        codingField.setBounds(getBounds().width / 2, 110, 200, 20);
        interviewField.setBounds(getBounds().width / 2, 140, 200, 20);

        setVisible(true);
    }
    
   
    public void actionPerformed(ActionEvent e) {
        try {
            // ambil input
            String name = nameField.getText();
            String nim = nimField.getText();
            double nilaitulis = Double.parseDouble(writingField.getText());
            double nilaingoding = Double.parseDouble(codingField.getText());
            double nilaiinterview = Double.parseDouble(interviewField.getText());

            double lulusandroid = (nilaitulis * 0.2 + nilaingoding * 0.5 + nilaiinterview * 0.3);
            double lulusweb = (nilaitulis * 0.4 + nilaingoding * 0.35 + nilaiinterview * 0.25);

            String result;
            if (lulusandroid >= 85) {
                result = "Kamu keterima jadi Android Developer";
            } else if (lulusweb >= 85) {
                result = "Kamu keterima jadi Web Developer";
            } else {
                result = "wkwkw kamu ga keterima";
            }

            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "lu salah input.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "kamu salah: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
}
}


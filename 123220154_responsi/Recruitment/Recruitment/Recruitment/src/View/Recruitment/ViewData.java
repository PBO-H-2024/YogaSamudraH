package View.Recruitment;

import Model.Recruitment.Candidate;
import controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewData extends JFrame {

    private Integer selectedRow;
    private Controller controller;

    // Initialize components
    JLabel header = new JLabel("Internship Candidate Data");
    JButton addButton = new JButton("Add");
    JButton editButton = new JButton("Edit");
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");
    
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String columnNames[] = {"ID", "Name", "Path", "Writing Exam", "Coding Test", "Interview Test", "Final Score", "Status"};

    public ViewData() {
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Candidate List");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(800, 600);

        add(header);
        add(scrollPane);
        add(addButton);
        add(editButton);
        add(deleteButton);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 740, 400);
        addButton.setBounds(20, 450, 740, 40);
        editButton.setBounds(20, 500, 360, 40);
        deleteButton.setBounds(400, 500, 360, 40);

        controller = new Controller(this);
        controller.showAllCandidates();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selectedRow = table.getSelectedRow();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new InputData();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != null) {
                    Candidate selectedCandidate = new Candidate();
                    Integer id = (int) table.getValueAt(selectedRow, 0);
                    String name = table.getValueAt(selectedRow, 1).toString();
                    String path = table.getValueAt(selectedRow, 2).toString();
                    float writingExam = Float.parseFloat(table.getValueAt(selectedRow, 3).toString());
                    float codingTest = Float.parseFloat(table.getValueAt(selectedRow, 4).toString());
                    float interviewTest = Float.parseFloat(table.getValueAt(selectedRow, 5).toString());
                    float finalScore = Float.parseFloat(table.getValueAt(selectedRow, 6).toString());
                    String status = table.getValueAt(selectedRow, 7).toString();

                    selectedCandidate.setId(id);
                    selectedCandidate.setName(name);
                    selectedCandidate.setPath(path);
                    selectedCandidate.setWritingExam(writingExam);
                    selectedCandidate.setCodingTest(codingTest);
                    selectedCandidate.setInterviewTest(interviewTest);
                    selectedCandidate.setFinalScore(finalScore);
                    selectedCandidate.setStatus(status);

                    dispose();
                    new EditData(selectedCandidate);
                } else {
                    JOptionPane.showMessageDialog(null, "No data selected.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedRow != null) {
                    int id = (int) table.getValueAt(selectedRow, 0);
                    controller.deleteCandidate(id);
                    selectedRow = null;
                } else {
                    JOptionPane.showMessageDialog(null, "No data selected.");
                }
            }
        });
    }

    public JTable getCandidateTable() {
        return table;
    }

    /**
     *
     * @param refreshListener
     */
    public void addRefreshListener(Controller.RefreshListener refreshListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

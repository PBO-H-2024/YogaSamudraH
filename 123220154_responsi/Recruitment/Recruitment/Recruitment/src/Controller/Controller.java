package controller;

import Model.Recruitment.*;
import View.Recruitment.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {
    private ViewData tableView;
    private InputData inputView;
    private DAO candidateDAO;

    public Controller(ViewData tableView) {
        this.tableView = tableView;
        this.candidateDAO = new DAO();
        this.tableView.addRefreshListener(new RefreshListener());
        showAllCandidates();
    }

    public Controller(InputData inputView) {
        this.inputView = inputView;
        this.candidateDAO = new DAO();
        this.inputView.addSubmitListener(new SubmitListener());
    }

    public void deleteCandidate(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showAllCandidates();
        }
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String name = inputView.getName();
                String path = inputView.getPath();
                float writingExam = inputView.getWritingExam();
                float codingTest = inputView.getCodingTest();
                float interviewTest = inputView.getInterviewTest();

                if (name.isEmpty() || path.isEmpty()) {
                    throw new Exception("Name or Path cannot be empty!");
                }

                Model candidate = new Model(name, path, writingExam, codingTest, interviewTest);
                candidateDAO.addCandidate(candidate);

                JOptionPane.showMessageDialog(null, "Candidate added successfully!");

                inputView.dispose();
                new ViewData().setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    public void showAllCandidates() {
        List<Model> candidates = candidateDAO.getAll();
        ModelTable tableModel = new ModelTable(candidates);
        tableView.getCandidateTable().setModel(tableModel);
    }
}

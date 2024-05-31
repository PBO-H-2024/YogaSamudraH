package Model.Recruitment;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModelTable extends AbstractTableModel {
    private List<Model> candidates;
    private String[] columnNames = {"ID", "Name", "Path", "Writing Exam", "Coding Test", "Interview Test", "Final Score", "Status"};

    public ModelTable(List<Model> candidates) {
        this.candidates = candidates;
    }

    @Override
    public int getRowCount() {
        return candidates.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Model candidate = candidates.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return candidate.getId();
            case 1:
                return candidate.getName();
            case 2:
                return candidate.getPath();
            case 3:
                return candidate.getWritingExam();
            case 4:
                return candidate.getCodingTest();
            case 5:
                return candidate.getInterviewTest();
            case 6:
                return candidate.getFinalScore();
            case 7:
                return candidate.getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}

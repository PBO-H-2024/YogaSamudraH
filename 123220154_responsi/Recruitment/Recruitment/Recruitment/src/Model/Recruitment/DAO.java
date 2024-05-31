package Model.Recruitment;

import Model.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements InterfaceDAO {
    private Connection connection;

    public DAO() {
        connection = Connector.Connect();
    }

    @Override
    public void addCandidate(Model candidate) {
        String sql = "INSERT INTO candidates (name, path, writing_exam, coding_test, interview_test, final_score, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getPath());
            statement.setFloat(3, candidate.getWritingExam());
            statement.setFloat(4, candidate.getCodingTest());
            statement.setFloat(5, candidate.getInterviewTest());
            statement.setFloat(6, candidate.getFinalScore());
            statement.setString(7, candidate.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Model> getAll() {
        List<Model> candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Model candidate = new Model(
                        resultSet.getString("name"),
                        resultSet.getString("path"),
                        resultSet.getFloat("writing_exam"),
                        resultSet.getFloat("coding_test"),
                        resultSet.getFloat("interview_test")
                );
                candidate.setId(resultSet.getInt("id"));
                candidate.setFinalScore(resultSet.getFloat("final_score"));
                candidate.setStatus(resultSet.getString("status"));
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }

    @Override
    public void update(Model candidate) {
        String sql = "UPDATE candidates SET name=?, path=?, writing_exam=?, coding_test=?, interview_test=?, final_score=?, status=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getPath());
            statement.setFloat(3, candidate.getWritingExam());
            statement.setFloat(4, candidate.getCodingTest());
            statement.setFloat(5, candidate.getInterviewTest());
            statement.setFloat(6, candidate.getFinalScore());
            statement.setString(7, candidate.getStatus());
            statement.setInt(8, candidate.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM candidates WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

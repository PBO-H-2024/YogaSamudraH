package Model.Recruitment;

import java.util.List;

public interface InterfaceDAO {
    void addCandidate(Model candidate);
    List<Model> getAll();
    void update(Model candidate);
    void delete(int id);
}

import java.sql.SQLException;
import java.util.List;

public interface DevelopersRepository<Developers> {
    List<Developers> findAll() throws SQLException;
    Developers findById(String id) throws SQLException;
    void insert(Developers developer);
    void update(Developers developer);
    void delete(String id);
}

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevelopersRepositoryImpl implements DevelopersRepository {
    DatabaseHandler dbHandler = new DatabaseHandler();
    @Override
    public List<Developers> findAll() throws SQLException {
        ResultSet resultSet = dbHandler.getDevelopers();
        List<Developers> devList = new ArrayList<>();
        Developers dev;
        while (resultSet.next())
        {
            dev=new Developers();
            dev.setId(resultSet.getString("id"));
            dev.setName(resultSet.getString("name"));
            dev.setSurname(resultSet.getString("surname"));
            dev.setAge(resultSet.getString("age"));
            dev.setPosition(resultSet.getString("position"));
            devList.add(dev);

        }
        return devList;
    }

    @Override
    public Object findById(String id) throws SQLException {
        ResultSet resultSet = dbHandler.getDeveloper(id);
        Developers dev = new Developers();
        while (resultSet.next())
        {
            dev.setId(resultSet.getString("id"));
            dev.setName(resultSet.getString("name"));
            dev.setSurname(resultSet.getString("surname"));
            dev.setAge(resultSet.getString("age"));
            dev.setPosition(resultSet.getString("position"));
        }
        return dev;
    }

    @Override
    public void insert(Object developer) {
        dbHandler.setDeveloper((Developers) developer);

    }

    @Override
    public void update(Object developer) {
        String result = dbHandler.updateDeveloper((Developers) developer);
        System.out.println("Update was " + result);
    }

    @Override
    public void delete(String id) {
        String result = dbHandler.deleteDeveloper(id);
        System.out.println("Delete was "+result);
    }
}

import java.io.*;
import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    private Connection getDbConnection() throws ClassNotFoundException, SQLException
    {
        String connectionString = "jdbc:mysql://"+ dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public ResultSet getDeveloper(String id)
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.DEVELOPERS_TABLE+" WHERE "+ Const.DEV_ID+"=?";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet getDevelopers()
    {
        ResultSet resultSet = null;
        String select = "SELECT * FROM " + Const.DEVELOPERS_TABLE;
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void setDeveloper(Developers developer)
    {
        String set = "INSERT INTO "+Const.DEVELOPERS_TABLE+ "("+Const.DEV_NAME+","+ Const.DEV_SURNAME+","+ Const.DEV_AGE+","+ Const.DEV_POSITION+")"+
                "VALUES (?,?,?,?)";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(set);
            preparedStatement.setString(1, developer.getName());
            preparedStatement.setString(2, developer.getSurname());
            preparedStatement.setString(3, developer.getAge());
            preparedStatement.setString(4, developer.getPosition());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String updateDeveloper(Developers developer)
    {
        String update= "UPDATE "+Const.DEVELOPERS_TABLE+" SET `"+Const.DEV_NAME+"`='"+developer.getName()+"', `"+
                Const.DEV_SURNAME+"`='"+developer.getSurname()+"', `"+
                Const.DEV_AGE+"`='"+developer.getAge()+"', `"+
                Const.DEV_POSITION+"`='"+developer.getPosition()+"' WHERE `"+ Const.DEV_ID+"`='"+developer.getId()+"'";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);
            preparedStatement.executeUpdate();
            return "Success";
        }
        catch (SQLException|ClassNotFoundException e)
        {
            System.out.println("Unable to update a record");
            return "Error";
        }

    }

    public String deleteDeveloper(String id)
    {
        String delete = "DELETE FROM "+Const.DEVELOPERS_TABLE+" WHERE "+ Const.DEV_ID+"='"+id+"'";
        try
        {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(delete);
            preparedStatement.executeUpdate();
            return "Success";
        } catch (SQLException|ClassNotFoundException e) {
            return "Error";
        }
    }


}

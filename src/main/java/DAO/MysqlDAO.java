package DAO;
import DTO.Cat;
import Exceptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class MysqlDAO
{
    public Connection getConnection() throws DAOException
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/CreateCats";
        String username = "root";
        String password = System.getenv("MYSQL_PASSWORD");
        Connection con = null;

        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found " + e.getMessage());
            System.exit(1);
        }
        catch (SQLException e)
        {
            System.out.println("Connection failed " + e.getMessage());
        }
        System.out.println("Connection successful");
        return con;
    }


    public void freeConnection(Connection con) throws DAOException
    {
        try
        {
            if(con != null)
            {
                con.close();
                con = null;
            }
        }
        catch (SQLException e)
        {
            System.out.println("Failed to free the connection " + e.getMessage());
            System.exit(1);
        }
    }

    public abstract Cat findCatById(String catId) throws DAOException;
}


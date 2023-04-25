package DAO;
import Exceptions.DAOException;
import DTO.Cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MysqlCatDAO extends MysqlDAO  implements ICatDAOInterface 
{
    @Override
    public List<Cat> findAllCats() throws DAOException
    {
        List<Cat> cats = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            String query = "SELECT * FROM cat";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                int catId = rs.getInt("catId");
                float weight = rs.getFloat("weight");
                Cat cat = new Cat(name, catId, weight);
                cats.add(cat);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("findAllCats() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return cats;
    }



    @Override
    public Cat findCatByID(String catId) throws DAOException {
        return null;
    }

    @Override
    public void deleteCatByCatID(String catId) throws DAOException {

    }

    @Override
    public void insertCat(Cat cat) throws DAOException {

    }


     private Set<Integer> catIds = new HashSet<>();
    @Override
    public Cat findCatById(String catId) throws DAOException
    {
        Cat cat = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            con = getConnection();
            String query = "SELECT * FROM cat WHERE catId = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, catId);
            rs = ps.executeQuery();

            if (rs.next())
            {
                String name = rs.getString("name");
                int catID = rs.getInt("catId");
                float weight = rs.getFloat("weight");
                cat = new Cat(name, catID, weight);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("findCatById() " + e.getMessage());
        }
        finally
        {
            this.freeConnection(con);
        }
        return cat;
    }

}

package DAO;
import Exceptions.DAOException;
import DTO.Cat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Cat findCatByCatID(String catId) throws DAOException {
        return null;
    }

    @Override
    public void deleteCatByCatID(String catId) throws DAOException {

    }

    @Override
    public void insertCat(Cat cat) throws DAOException {

    }

}

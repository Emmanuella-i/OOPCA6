import DAO.ICatDAOInterface;
import DAO.MysqlCatDAO;
import DTO.Cat;
import Exceptions.DAOException;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        ICatDAOInterface catDAO = new MysqlCatDAO();
        getAndPrintAllCats(catDAO);
    }



    private static void getAndPrintAllCats(ICatDAOInterface catDAO)
    {
        try
        {
            List<Cat> cats = catDAO.findAllCats();
            for (Cat cat : cats)
            {
                System.out.println(cat);
            }
        }
        catch (DAOException e)
        {
            System.out.println("Failed to get all cats " + e.getMessage());
        }
    }

}



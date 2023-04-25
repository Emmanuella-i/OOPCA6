import DAO.ICatDAOInterface;
import DAO.MysqlCatDAO;
import DTO.Cat;
import Exceptions.DAOException;

import java.util.Collections;
import java.util.Comparator;
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

        getAndPrintCatById(catDAO, "1");
        deleteCatById(catDAO, "1");
        getAndPrintCatsUsingComparator(catDAO, new CatWeightComparator());
    }


    private static class CatWeightComparator implements Comparator<Cat>
    {
        @Override
        public int compare(Cat o1, Cat o2)
        {
            return Float.compare(o1.getWeight(), o2.getWeight());
        }
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


    private static void getAndPrintCatById(ICatDAOInterface catDAO, String catId)
    {
        try
        {
            Cat cat = catDAO.findCatByID(catId);
            System.out.println(cat);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to get cat by id " + e.getMessage());
        }
    }

    private static void deleteCatById(ICatDAOInterface catDAO, String catId)
    {
        try
        {
            catDAO.deleteCatByCatID(catId);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to delete cat by id " + e.getMessage());
        }
    }

    private static void insertCat(ICatDAOInterface catDAO, Cat cat)
    {
        try
        {
            catDAO.insertCat(cat);
        }
        catch (DAOException e)
        {
            System.out.println("Failed to insert cat " + e.getMessage());
        }
    }


    private static void getAndPrintCatsUsingComparator(ICatDAOInterface catDAO, Comparator<Cat> catComparator)
    {
        try
        {
            List<Cat> cats = catDAO.findAllCats();
            Collections.sort(cats, catComparator);
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



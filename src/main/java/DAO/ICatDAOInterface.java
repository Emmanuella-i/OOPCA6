package DAO;
import DTO.Cat;
import Exceptions.DAOException;
import java.util.List;

public interface ICatDAOInterface
{
    public List<Cat> findAllCats() throws DAOException;
    public Cat findCatByCatID(String catId) throws DAOException;
    public void deleteCatByCatID(String catId) throws DAOException;
    public void insertCat(Cat cat) throws DAOException;
}

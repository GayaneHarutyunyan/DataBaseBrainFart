package dao.postgres;


import dao.DaoFactory;
import dao.SubjectsDao;
import exception.*;
import model.Subjects;
import org.apache.log4j.Logger;

public class PostgreSqlSubjectsDao implements SubjectsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestsDao.class.getName());


    @Override
    public Subjects create(long id, String subject) throws DAOException {
        Subjects subjects=null;
        return subjects;

    }

    @Override
    public Subjects read(long id) throws DAOException {
        Subjects subjects = null;
        return subjects;

    }

    @Override
    public void delete(long id) throws DAOException {
        Subjects subjects = null;


    }

}

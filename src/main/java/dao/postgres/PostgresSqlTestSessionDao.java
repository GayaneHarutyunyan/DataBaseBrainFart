package dao.postgres;

import dao.DaoFactory;
import dao.TestSessionDao;
import exception.*;
import model.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;

/**
 * Created by mystic on 19.05.2016.
 */
public class PostgresSqlTestSessionDao implements TestSessionDao {


    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgresSqlTestSessionDao.class.getName());

    @Override
    public List<TestSession> getAll() throws DAOException {
        List<TestSession> testSession = new ArrayList<>();

        return testSession;
    }


}

package dao.postgres;

import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by mystic on 19.05.2016.
 */
public class PostgreSqlTestAvailabilityDao implements TestAvailabilityDao {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestAvailabilityDao.class.getName());

    @Override
    public List<TestAvailability> getAll() throws DAOException {
        List<TestAvailability> testAvailabilityes = new ArrayList<>();


        return testAvailabilityes;
    }
}

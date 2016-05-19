package dao;

import exception.DAOException;
import model.*;

import java.util.*;

/**
 * Created by mystic on 17.05.2016.
 */
public interface TestAvailabilityDao {

    List<TestAvailability> getAll() throws DAOException;
}

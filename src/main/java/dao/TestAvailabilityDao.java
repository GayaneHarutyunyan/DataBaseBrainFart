package dao;

import exception.DAOException;
import model.*;

import java.util.*;

public interface TestAvailabilityDao {

    List<TestAvailability> getAll() throws DAOException;
}

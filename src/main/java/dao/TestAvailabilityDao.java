package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;

public interface TestAvailabilityDao {

    List<TestAvailability> getAll() throws DaoRuntimeException;
}

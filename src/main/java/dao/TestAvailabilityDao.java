package dao;

import exception.*;
import model.*;

import java.util.*;

public interface TestAvailabilityDao {

    void addTestAvailability(TestAvailability testAvailability) throws DaoRuntimeException;

    TestAvailability readTestAvailability(long id) throws DaoRuntimeException;

    void updateTestAvailability(TestAvailability testAvailability) throws DaoRuntimeException;

    void deleteTestAvailability(TestAvailability testAvailability) throws DaoRuntimeException;

    List<TestAvailability> getTestAvailability() throws DaoRuntimeException;

    //List<TestAvailability> getAll() throws DaoRuntimeException;
}

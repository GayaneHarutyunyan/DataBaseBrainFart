package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;

public interface TestsDao {


    void addTests(Tests tests) throws DaoRuntimeException;

    Tests readTests(long id) throws DaoRuntimeException;

    void updateTests(Tests tests) throws DaoRuntimeException;

    void deleteTests(Tests tests) throws DaoRuntimeException;

    List<Tests> getTests() throws DaoRuntimeException;


}

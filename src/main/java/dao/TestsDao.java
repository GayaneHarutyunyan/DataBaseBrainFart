package dao;

import exception.DaoRuntimeException;
import model.Subjects;
import model.Tests;

import java.util.*;

public interface TestsDao {

    Tests create(Subjects subjectId, String description, String name, boolean publicity) throws DaoRuntimeException;

    Tests read(long id) throws DaoRuntimeException;

    void delete(long id) throws DaoRuntimeException;

    List<Tests> getAll() throws DaoRuntimeException;

}

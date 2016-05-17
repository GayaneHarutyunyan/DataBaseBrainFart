package dao;

import exception.DAOException;
import model.QuestionConnections;
import model.Subjects;
import model.TestAvailability;
import model.Tests;

import java.util.*;

public interface TestsDao {

    Tests create(Subjects subjectId, String description, String name, boolean publicity) throws DAOException;

    Tests read(long id) throws DAOException;

   // Tests update(long id, String name, Subjects subjectId, String description, boolean publicity) throws DAOException;

    void delete(long id) throws DAOException;
/*
    List<QuestionConnections> getAll() throws DAOException;

    List<TestAvailability> getAllSubgroups(long id) throws DAOException;
    */
}

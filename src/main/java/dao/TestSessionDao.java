package dao;

import exception.DAOException;
import model.*;

import java.util.*;


public interface TestSessionDao {

    List<TestSession> getAll() throws DAOException;

    List<TestSession> getTestSessionByResult(Integer testResult) throws DAOException;
}

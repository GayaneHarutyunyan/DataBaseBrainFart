package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;


public interface TestSessionDao {

    List<TestSession> getAll() throws DaoRuntimeException;

    List<TestSession> getTestSessionByResult(Integer testResult) throws DaoRuntimeException;
}

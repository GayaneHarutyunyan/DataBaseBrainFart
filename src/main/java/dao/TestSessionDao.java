package dao;

import exception.*;
import model.*;

import java.util.*;


public interface TestSessionDao {

    void addTestSession(TestSession testSession) throws DaoRuntimeException;

    TestSession readTestSession(long id) throws DaoRuntimeException;

    void updateTestSession(TestSession testSession) throws DaoRuntimeException;

    void deleteTestSession(TestSession testSession) throws DaoRuntimeException;

    List<TestSession> getTestSession() throws DaoRuntimeException;

}

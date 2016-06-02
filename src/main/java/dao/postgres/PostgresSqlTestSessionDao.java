package dao.postgres;

import app.HibernateUtil;
import dao.TestSessionDao;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.*;

public class PostgresSqlTestSessionDao implements TestSessionDao {


    //private DaoFactory daoFactory = DaoFactory.getInstance();
   // private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgresSqlTestSessionDao.class.getName());

    @Override
    public void addTestSession(TestSession testSession) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(testSession);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public TestSession readTestSession(long id) throws DaoRuntimeException {

        TestSession result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (TestSession) session.get(TestSession.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public void updateTestSession(TestSession testSession) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(testSession);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteTestSession(TestSession testSession) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(testSession);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public List<TestSession> getTestSession() throws DaoRuntimeException {
        Session session = null;
        List<TestSession> testSessions = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            testSessions = session.createCriteria(TestSession.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return testSessions;
    }



    /*
    @Override
    public List<TestSession> getAll()  {

        List<TestSession> testSession = new ArrayList<>();

        String sql = "select * from public.test_session;";

        TestSession testSession1 = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);

                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        log.trace("Create test Session to add to the set");
                        testSession1 = new TestSession(resultSet.getDate("submit_date"), resultSet.getInt("test_result"));
                        testSession1.setId(resultSet.getInt("id"));
                        testSession.add(testSession1);
                        log.trace("TestSession " + testSession1.getId() + " added to set");
                    }
                } finally {
                    try {
                        resultSet.close();
                        log.trace("result set closed");
                    } catch (SQLException e) {
                        log.warn("Cannot close result set", e);
                    }
                }
            } finally {
                try {
                    preparedStatement.close();
                    log.trace("statement closed");
                } catch (SQLException e) {
                    log.warn("Cannot close statement", e);
                }
            }
        } catch (SQLException e) {
            log.warn("Cannot get all test Session", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning testSession");
        return testSession;
    }

    @Override
    public List<TestSession> getTestSessionByResult(Integer testResult) {
        List<TestSession> testSessions = new ArrayList<>();
        String sql = "SELECT * FROM public.test_session where test_result=?";

        TestSession testSession = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, testResult);

                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        log.trace("Create test session to add to the set");
                        testSession = new TestSession(resultSet.getDate("submit_date"), resultSet.getInt("test_result"));

                        testSession.setId(resultSet.getInt("id"));
                        testSessions.add(testSession);
                        log.trace("TestSession " + testSession.getId() + " added to set");
                    }
                } finally {
                    try {
                        resultSet.close();
                        log.trace("result set closed");
                    } catch (SQLException e) {
                        log.warn("Cannot close result set", e);
                    }
                }
            } finally {
                try {
                    preparedStatement.close();
                    log.trace("statement closed");
                } catch (SQLException e) {
                    log.warn("Cannot close statement", e);
                }
            }
        } catch (SQLException e) {
            log.warn("Cannot get testSession by testResult=" + testResult, e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        log.trace("Returning all testSession with testResult=" + testResult);

        return testSessions;
    }
    */
}

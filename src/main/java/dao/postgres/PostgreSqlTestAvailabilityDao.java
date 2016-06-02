package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.*;
import java.util.*;


public class PostgreSqlTestAvailabilityDao implements TestAvailabilityDao {

   // private DaoFactory daoFactory = DaoFactory.getInstance();
  //  private static Logger log = Logger.getLogger(PostgreSqlTestAvailabilityDao.class.getName());

    @Override
    public void addTestAvailability(TestAvailability testAvailability) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(testAvailability);
            session.getTransaction().commit();
        } finally {
            if ((session == null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public TestAvailability readTestAvailability(long id) throws DaoRuntimeException {
        TestAvailability result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (TestAvailability) session.get(TestAvailability.class, id);
        } finally {
            if ((session == null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public void updateTestAvailability(TestAvailability testAvailability) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(testAvailability);
            session.getTransaction().commit();
        } finally {
            if ((session == null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteTestAvailability(TestAvailability testAvailability) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(testAvailability);
            session.getTransaction().commit();
        } finally {
            if ((session == null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public List<TestAvailability> getTestAvailability() throws DaoRuntimeException {
        Session session = null;
        List<TestAvailability> testAvailabilities = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            testAvailabilities = session.createCriteria(TestAvailability.class).list();
        } finally {
            if ((session == null) && (session.isOpen())) session.close();
        }
        return testAvailabilities;
    }


/*
    @Override
    public List<TestAvailability> getAll() {
        List<TestAvailability> testAvailabilityes = new ArrayList<>();
        String sql = "SELECT * FROM public.test_availability";

        TestAvailability testAvailability = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            log.trace("open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);
                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        log.trace("Create testAvailability to add to the set");
                        testAvailability = new TestAvailability(resultSet.getDate("startDate"), resultSet.getDate("endDate"));
                        testAvailability.setId(resultSet.getLong("id"));
                        testAvailabilityes.add(testAvailability);
                        log.trace("TestAvailability " + testAvailability.getId() + " added to set");
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
            log.warn("Cannot get all testAvailability", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        log.trace("Returning testAvailabilityes");
        return testAvailabilityes;
    }
    */
}

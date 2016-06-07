package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.*;


public class PostgreSqlTestAvailabilityDao implements TestAvailabilityDao {

  //  private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgreSqlTestAvailabilityDao.class.getName());

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
}

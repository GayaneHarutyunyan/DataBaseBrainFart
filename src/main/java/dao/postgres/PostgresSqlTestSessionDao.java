package dao.postgres;

import app.HibernateUtil;
import dao.TestSessionDao;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.*;

public class PostgresSqlTestSessionDao implements TestSessionDao {


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
}

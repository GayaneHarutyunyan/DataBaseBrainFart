package dao.postgres;


import java.util.*;


import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;

import org.hibernate.Session;


public class PostgreSqlTestsDao implements TestsDao {

   // private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgreSqlTestsDao.class.getName());

    @Override
    public void addTests(Tests tests) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(tests);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateTests(Tests tests) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(tests);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteTests(Tests tests) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(tests);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }


    @Override
    public Tests readTests(long id) throws DaoRuntimeException {
        Tests result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Tests) session.get(Tests.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<Tests> getTests() throws DaoRuntimeException {
        Session session = null;
        List<Tests>  testses = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            testses = session.createCriteria(Tests.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return testses;
    }

}
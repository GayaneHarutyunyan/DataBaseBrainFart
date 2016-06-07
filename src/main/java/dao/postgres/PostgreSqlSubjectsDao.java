package dao.postgres;


import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class PostgreSqlSubjectsDao implements SubjectsDao {
   // private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgreSqlSubjectsDao.class.getName());

    @Override
    public void addSubjects(Subjects subjects) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(subjects);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Subjects readSubjects(long id) throws DaoRuntimeException {
        Subjects result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Subjects) session.get(Subjects.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public void updateSubjects(Subjects subjects) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(session);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteSubjects(Subjects subjects) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(subjects);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public List<Subjects> getSubjects() throws DaoRuntimeException {
        Session session = null;
        List<Subjects> subjectses = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            subjectses = session.createCriteria(Subjects.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return subjectses;
    }
}
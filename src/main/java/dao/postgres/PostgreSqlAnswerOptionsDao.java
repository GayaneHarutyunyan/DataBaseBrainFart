package dao.postgres;


import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.hibernate.Session;
import org.apache.log4j.Logger;

import java.util.*;


public class PostgreSqlAnswerOptionsDao implements AnswerOptionsDao {
    private static Logger log = Logger.getLogger(PostgreSqlAnswerOptionsDao.class.getName());

    @Override
    public void addAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(answerOptions);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(answerOptions);
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(answerOptions);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public AnswerOptions readAnswerOptions(long id) throws DaoRuntimeException {
        AnswerOptions result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (AnswerOptions) session.get(AnswerOptions.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<AnswerOptions> getAnswerOptions() throws DaoRuntimeException {
        Session session = null;
        List<AnswerOptions> answerOptionses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            answerOptionses = session.createCriteria(AnswerOptions.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return answerOptionses;
    }
}

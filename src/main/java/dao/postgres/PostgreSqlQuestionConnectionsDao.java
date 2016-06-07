package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.*;

/**
 * не знаю как соединить 3 листа в один
 */
public class PostgreSqlQuestionConnectionsDao implements QuestionConnectionsDao {
   //private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgreSqlQuestionConnectionsDao.class.getName());

    @Override
    public void addQuestionConnections(QuestionConnections questionConnections) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(questionConnections);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteQuestionConnections(QuestionConnections questionConnections) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(questionConnections);
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateQuestionConnections(QuestionConnections questionConnections) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(questionConnections);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public QuestionConnections readQuestionConnections(long id) throws DaoRuntimeException {
        QuestionConnections result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (QuestionConnections) session.get(QuestionConnections.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<QuestionConnections> getQuestionConnections() throws DaoRuntimeException {
        Session session = null;
        List<QuestionConnections> questionConnectionses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            questionConnectionses = session.createCriteria(QuestionConnections.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return questionConnectionses;
    }
}

package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.*;


public class PostgreSqlQuestionResultsDao implements QuestionResultsDao {
    //private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgreSqlQuestionResultsDao.class.getName());

    @Override
    public void addQuestionResults(QuestionResults questionResults) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(questionResults);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteQuestionResults(QuestionResults questionResults) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(questionResults);
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateQuestionResults(QuestionResults questionResults) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(questionResults);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public QuestionResults readQuestionResults(long id) throws DaoRuntimeException {
        QuestionResults result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (QuestionResults) session.get(QuestionResults.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<QuestionResults> getQuestionResults() throws DaoRuntimeException {
        Session session = null;
        List<QuestionResults> questionResultses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            questionResultses = session.createCriteria(QuestionResults.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return questionResultses;
    }
}

package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.*;


public class PostgreSqlQuestionResultsDao implements QuestionResultsDao {
    //private DaoFactory daoFactory = DaoFactory.getInstance();
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
/*
    @Override
    public List<QuestionResults> getAll() {
        List<QuestionResults> questionResultses = new ArrayList<>();
        String sql = "SELECT * FROM public.question_results";

        QuestionResults questionResults = null;
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
                        log.trace("Create questionResults to add to the set");
                        questionResults = new QuestionResults(resultSet.getInt("result"));
                        questionResults.setId(resultSet.getLong("id"));
                        questionResultses.add(questionResults);
                        log.trace("QuestionResults " + questionResults.getId() + " added to set");
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
            log.warn("Cannot get all questionResultses", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning questionResultses");
        return questionResultses;
    }
    */
}

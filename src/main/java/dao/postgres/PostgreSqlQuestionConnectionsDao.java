package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.*;
import java.util.*;

/**
 * не знаю как соединить 3 листа в один
 */
public class PostgreSqlQuestionConnectionsDao implements QuestionConnectionsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlQuestionConnectionsDao.class.getName());

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
/*
    @Override
    public List<QuestionConnections> getAll() {
        List<QuestionConnections> questionConnectionses = new ArrayList<>();
        String sql = "SELECT * FROM public.question_results";

        QuestionConnections questionConnections = null;
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
                        log.trace("Create questionConnections to add to the set");
                        //questionConnections = new QuestionConnections(resultSet.getLong("id"),);
                        questionConnections.setId(resultSet.getLong("id"));
                        questionConnectionses.add(questionConnections);
                        log.trace("QuestionConnections " + questionConnections.getId() + " added to set");
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
            log.warn("Cannot get all questionConnections", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning questionConnectionses");


        return questionConnectionses;
    }
    */
}

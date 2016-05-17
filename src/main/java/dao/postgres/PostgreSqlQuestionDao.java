package dao.postgres;


import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;

import java.sql.*;

public class PostgreSqlQuestionDao implements QuestionDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestsDao.class.getName());

    @Override
    public Questions create(long id, String content, Integer value) throws DAOException {
        log.info("Creating new question with id=" + id);
        String sql = "insert into public.questions (content,value) VALUES (?,?)";
        Questions questions = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, content);
                preparedStatement.setInt(2, value);
                preparedStatement.execute();
                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    log.trace("Create group to return");
                    questions = new Questions(resultSet.getString("content"), resultSet.getInt("value"));
                    questions.setId(resultSet.getLong("id"));

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
            log.warn("Cannot create user", e);
            throw new DAOException("Cannot create tests", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Return questions");
        return questions;
    }

    @Override
    public Questions read() throws DAOException {
        Questions questions = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        return questions;
    }

    @Override
    public void delete() throws DAOException {
        Questions questions = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        log.trace("Open connection");
        connection = daoFactory.getConnection();


    }

}

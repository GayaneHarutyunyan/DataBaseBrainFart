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
    public Questions create(long id, String content, Integer value) throws DaoRuntimeException {
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
            log.warn("Cannot create questions", e);
            throw new DaoRuntimeException("Cannot create questions", e);
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
    public Questions read(long id) throws DaoRuntimeException {

        log.trace("Get parameters: id=" + id);
        String sql = "select from public.questions where id = ?;";

        Questions questions = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);

                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.executeQuery();
                    resultSet.next();
                    log.trace("Create tests to return");
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
            log.warn("Cannot create questions", e);
            throw new DaoRuntimeException("Cannot read questions", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        if (null == questions) {
            log.debug("Questions not found");
        } else {
            log.trace("Questions " + id + " found");
        }
        log.trace("Return questions");
        return questions;
    }

    @Override
    public void delete(long id) throws DaoRuntimeException {

        log.trace("Get parameters: id=" + id);
        String sql = "delete from public.questions where id = ?;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {


                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                log.info("Questions " + id + " deleted");
            } finally {
                try {
                    preparedStatement.close();
                    log.trace("statement closed");
                } catch (SQLException e) {
                    log.warn("Cannot close statement", e);
                }
            }
        } catch (SQLException e) {
            log.warn("Cannot create questions", e);
            throw new DaoRuntimeException("Cannot delete questions", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
    }
}



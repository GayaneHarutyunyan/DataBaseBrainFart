package dao.postgres;


import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PostgreSqlAnswerOptionsDao implements AnswerOptionsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlAnswerOptionsDao.class.getName());


    @Override
    public AnswerOptions create(long id, String content, boolean correctness) throws DAOException {
        String sql = "INSERT INTO public.answer_options (content,correctness) VALUES (?,?)";


        AnswerOptions answerOptions = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, content);
                preparedStatement.setBoolean(2, correctness);
                preparedStatement.execute();
                try {

                    log.trace("Get result set");
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    log.trace("Create group to return");
                    answerOptions = new AnswerOptions(resultSet.getString("content"), resultSet.getBoolean("correctness"));
                    answerOptions.setId(resultSet.getLong("id"));
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
            log.warn("Cannot create answerOptions", e);
            throw new DAOException("Cannot create answerOptions", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }


        return answerOptions;
    }

    @Override
    public AnswerOptions read(long id) throws DAOException {

        log.trace("Get parameters: id=" + id);
        String sql = "select from public.answer_options where id = ?;";
        AnswerOptions answerOptions = null;

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
                    answerOptions = new AnswerOptions(resultSet.getString("content"), resultSet.getBoolean("correctness"));
                    answerOptions.setId(resultSet.getLong("id"));


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
            log.warn("Cannot create AnswerOptions", e);
            throw new DAOException("Cannot read AnswerOptions", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        if (null == answerOptions) {
            log.debug("answerOptions not found");
        } else {
            log.trace("answerOptions " + id + " found");
        }
        log.trace("Return answerOptions");

        return answerOptions;
    }

    @Override
    public void delete(long id) throws DAOException {
        log.trace("Get parameters: id=" + id);
        String sql = "delete from public.answer_options where id = ?;";

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
                log.info("AnswerOptions " + id + " deleted");
            } finally {
                try {
                    preparedStatement.close();
                    log.trace("statement closed");
                } catch (SQLException e) {
                    log.warn("Cannot close statement", e);
                }
            }
        } catch (SQLException e) {
            log.warn("Cannot create AnswerOptions", e);
            throw new DAOException("Cannot delete AnswerOptions", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

    }

    @Override
    public List<AnswerOptions> getAll() throws DAOException {

        List<AnswerOptions> answerOptionses = new ArrayList<>();
        return answerOptionses;
    }


}

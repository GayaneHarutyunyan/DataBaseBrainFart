package dao.postgres;


import dao.*;
import exception.*;
import model.*;

import org.apache.log4j.Logger;

import java.sql.*;


public class PostgreSqlSubjectsDao implements SubjectsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestsDao.class.getName());


    @Override
    public Subjects create(long id, String subject) throws DAOException {

        log.info("Creating new subject with id=" + id);
        String sql = "insert into public.subjects (subject) values (?)";

        Subjects subjects = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();

            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, subject);
                preparedStatement.execute();
                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    log.trace("Create group to return");
                    subjects = new Subjects(resultSet.getString("subject"));
                    subjects.setId(resultSet.getLong("id"));

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

        log.trace("Return subjects");

        return subjects;

    }

    @Override
    public Subjects read(long id) throws DAOException {

        Subjects subjects = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        log.trace("Open connection");
        connection = daoFactory.getConnection();

        return subjects;

    }

    @Override
    public void delete(long id) throws DAOException {
        Subjects subjects = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        log.trace("Open connection");
        connection = daoFactory.getConnection();


    }

}

package dao.postgres;

import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;


public class PostgreSqlQuestionResultsDao implements QuestionResultsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlQuestionResultsDao.class.getName());

    @Override
    public List<QuestionResults> getAll() throws DAOException {
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
            throw new DAOException("Cannot get all testAvailability", e);
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
}

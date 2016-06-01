package dao.postgres;

import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;


public class PostgreSqlTestAvailabilityDao implements TestAvailabilityDao {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestAvailabilityDao.class.getName());

    @Override
    public List<TestAvailability> getAll() throws DaoRuntimeException {
        List<TestAvailability> testAvailabilityes = new ArrayList<>();
        String sql = "SELECT * FROM public.test_availability";

        TestAvailability testAvailability = null;
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
                        log.trace("Create testAvailability to add to the set");
                        testAvailability = new TestAvailability(resultSet.getDate("startDate"), resultSet.getDate("endDate"));
                        testAvailability.setId(resultSet.getLong("id"));
                        testAvailabilityes.add(testAvailability);
                        log.trace("TestAvailability " + testAvailability.getId() + " added to set");

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
            throw new DaoRuntimeException("Cannot get all testAvailability", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        log.trace("Returning testAvailabilityes");
        return testAvailabilityes;
    }
}

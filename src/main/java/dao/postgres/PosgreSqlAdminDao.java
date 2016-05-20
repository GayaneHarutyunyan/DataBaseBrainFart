package dao.postgres;

import dao.*;
import exception.*;
import modelAdmin.*;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.*;


public class PosgreSqlAdminDao implements AdminDao {

    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PosgreSqlAdminDao.class.getName());

    @Override
    public List<Admins> getAll() throws DAOException {
        List<Admins> adminses = new ArrayList<>();
        String sql = "SELECT * FROM public.admins";

        Admins admins = null;
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
                        log.trace("Create admins to add to the set");
                        admins = new Admins(resultSet.getString("email"), resultSet.getString("password"));
                        admins.setId(resultSet.getLong("id"));
                        adminses.add(admins);
                        log.trace("Admins " + admins.getId() + " added to set");
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
            throw new DAOException("Cannot get all adminses", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning adminses");
        return adminses;
    }
}

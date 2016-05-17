package dao;


import java.io.IOException;
import java.sql.*;
import java.util.*;

import dao.postgres.*;
import exception.*;
import org.apache.log4j.Logger;


public class DaoFactory {

    private static DaoFactory daoFactory;
    private static String type;
    private String user;
    private String password;
    private String url;
    private String driver;

    private static Logger log = Logger.getLogger(DaoFactory.class.getName());

    private DaoFactory() {
        loadProperties();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("Driver not found\n", e);
        }
    }

    public static DaoFactory getInstance() {
        if (null == daoFactory) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public Connection getConnection() throws DAOException {
        log.trace("Driver manager get connection");
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DAOException("No connection to DB", e);
        }
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(DaoFactory.class.getResourceAsStream("/db.properties"));
            type = properties.getProperty("type");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new NoDBPropertiesException("Can't read file", e);
        }
    }

    public UsersDao getUsersDao() {
        if (type.equalsIgnoreCase("postgres")) {
            return new PostgreSqlUsersDao();
        } else {
            return new PostgreSqlUsersDao();
        }
    }

    public TestsDao getTestsDao() {
        if (type.equalsIgnoreCase("postgres")) {
            return new PostgreSqlTestsDao();
        } else {
            return new PostgreSqlTestsDao();
        }
    }

    public SubjectsDao getSubjectsDao() {
        if (type.equalsIgnoreCase("postgres")) {
            return new PostgreSqlSubjectsDao();
        } else {
            return new PostgreSqlSubjectsDao();
        }
    }

    public QuestionDao getQuestionDao() {
        if (type.equalsIgnoreCase("postgres")) {
            return new PostgreSqlQuestionDao();
        } else {
            return new PostgreSqlQuestionDao();
        }
    }

    public AnswerOptionsDao getAnswerOptionsDao() {
        if (type.equalsIgnoreCase("postgres")) {
            return new PostgreSqlAnswerOptionsDao();
        } else {
            return new PostgreSqlAnswerOptionsDao();
        }
    }

}







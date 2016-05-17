package dao.postgres;


import java.sql.*;
import java.util.*;


import dao.*;
import exception.*;
import model.*;

import org.apache.log4j.Logger;


public class PostgreSqlTestsDao implements TestsDao {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    private static Logger log = Logger.getLogger(PostgreSqlTestsDao.class.getName());

    @Override
    public Tests create(Subjects subjectId, String description, String name, boolean publicity) throws DAOException {
        log.trace("Get parameters: name=" + name + ", subjectId=" + subjectId + ", description=" + description + ", publicity" + publicity);
        String sql = "insert into public.tests (subjectId, description, name,publicity) values (?, ?,?,?)";

        Tests tests = null;
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
                //  preparedStatement.setLong(2, subjectId);
                preparedStatement.setString(2, description);
                preparedStatement.setString(3, name);
                preparedStatement.setBoolean(4, publicity);
                preparedStatement.execute();

                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    log.trace("Create group to return");
                    tests = new Tests(resultSet.getString("description"), resultSet.getString("name"), resultSet.getBoolean("publicity"));
                    tests.setId(resultSet.getInt("id"));


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
            log.warn("Cannot create tests", e);
            throw new DAOException("Cannot create tests", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning tests");
        return tests;
    }

    @Override
    public Tests read(long id) throws DAOException {
        log.trace("Get parameters: id=" + id);
        String sql = "select from public.tests where id = ?;";

        Tests tests = null;
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

                    tests = new Tests(resultSet.getString("description"), resultSet.getString("name"), resultSet.getBoolean("publicity"));


                    tests.setId(resultSet.getInt("id"));


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
            log.warn("Cannot create tests", e);
            throw new DAOException("Cannot read tests", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        if (null == tests) {
            log.debug("Tests not found");
        } else {
            log.trace("Tests " + id + " found");
        }
        log.trace("Returning tests");
        return tests;
    }

    @Override
    public void delete(long id) throws DAOException {
        log.trace("Get parameters: id=" + id);
        String sql = "delete from public.tests where id = ?;";

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
                log.info("Test " + id + " deleted");
            } finally {
                try {
                    preparedStatement.close();
                    log.trace("statement closed");
                } catch (SQLException e) {
                    log.warn("Cannot close statement", e);
                }
            }
        } catch (SQLException e) {
            log.warn("Cannot create tests", e);
            throw new DAOException("Cannot delete tests", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
    }


/*
    @Override
    public List<QuestionConnections> getAll() throws DAOException {
        List<QuestionConnections> questionConnections = new ArrayList<>();
        String sql = "select * from public.question_connections order by id;";

        QuestionConnections tempGroup = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);

                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.executeQuery();
                    log.trace("Reading groups from DB and add them to Set");
                    while (resultSet.next()) {
                        tempGroup = new QuestionConnections(resultSet.getString("group_name"),
                                resultSet.getInt("group_parent_id"));


                        tempGroup.setId(resultSet.getInt("id"));
                        questionConnections.add(tempGroup);
                        log.trace("Group " + tempGroup.getId() + " added to set");
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
            log.warn("Cannot create user", e);
            throw new DAOException("Cannot get all root groups", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Return groups");
        return questionConnections;
    }

    @Override
    public List<TestAvailability> getAllSubgroups(long id) throws DAOException {
        List<TestAvailability> testAvailability = new ArrayList<>();
        String sql = "select * from public.test_availability where testId = ? order by id;";

        TestAvailability tempGroup = null;
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
                    log.trace("Reading groups from DB and add them to Set");
                    while (resultSet.next()) {

                        tempGroup = new TestAvailability(resultSet.getString("group_name"),
                                resultSet.getInt("group_parent_id"));
                        tempGroup.setId(resultSet.getInt("id"));

                        testAvailability.add(tempGroup);

                        log.trace("Group " + tempGroup.getId() + " added to set");
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
            log.warn("Cannot create user", e);
            throw new DAOException("Cannot get all root groups", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Return groups");
        return testAvailability;
    }
    */
}
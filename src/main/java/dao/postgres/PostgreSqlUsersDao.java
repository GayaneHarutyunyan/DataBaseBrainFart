package dao.postgres;

import java.sql.*;
import java.util.*;


import app.HibernateUtil;
import exception.*;
import dao.*;
import model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;


public class PostgreSqlUsersDao implements UsersDao {
    //  private DaoFactory daoFactory = DaoFactory.getInstance();
    //  private static Logger log = Logger.getLogger(PostgreSqlUsersDao.class.getName());

    @Override
    public void addUser(Users users) throws DaoRuntimeException{
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Мы начинаем транзакцию
            session.beginTransaction();
            //сохраняем юзера
            session.save(users);
            //возвращаем транзакцию и закончили
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Users readUser(long id) throws DaoRuntimeException {
        Users result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Users) session.get(Users.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public void updateUser(Users users) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Мы начинаем транзакцию
            session.beginTransaction();
            //обновление юзера
            session.update(users);
/*
            Users temp = new Users();
            temp.setId(users.getId());
            temp.setFirstName(users.getFirstName());
            temp.setSecondName(users.getSecondName());
            temp.setEmail(users.getEmail());
            temp.setPhoneNumber(users.getPhoneNumber());
           session.update(temp);
           */
            //возвращаем транзакцию и закончили
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteUser(Users users) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Мы начинаем транзакцию
            session.beginTransaction();
            //сохраняем юзера
            session.delete(users);
            //возвращаем транзакцию и закончили
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public List<Users> getUser() throws DaoRuntimeException {
        Session session = null;
        List<Users> userses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            userses = session.createCriteria(Users.class).list();
        } finally {
            //lazy="false" чтобы не вываливалась ошибка что мы закрываем сессию не релдизавав его
            if ((session != null) && (session.isOpen())) session.close();
        }
        return userses;
    }



/*
    @Override
    public Users create(long id, String firstName, String secondName, String email, String phoneNumber) {
        //создаем нового юзера
        log.info("Creating new user with id=" + id);
        String sql = "insert into customers (id, email, firstName, secondName, phoneNumber) values (?,?,?,?,?);";

        Users users = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, id);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, firstName);
                preparedStatement.setString(4, secondName);
                preparedStatement.setString(4, phoneNumber);
                preparedStatement.execute();
                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    log.trace("Create user to return");
                    users = new Users(resultSet.getString("email"), resultSet.getString("firstName"), resultSet.getString("secondName"), resultSet.getString("phoneNumber"));
                    users.setId(resultSet.getLong("id"));

                    log.info("User with id=" + id + " created!");
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
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning customer");
        return users;
    }

    @Override
    public Users read(long id)  {
        log.trace("Looking for customer with id=" + id);
        String sql = "select * from public.users where id = ?;";

        Users users = null;
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
                    if (resultSet.next()) {
                        log.trace("Create customer to return");
                        users = new Users(resultSet.getString("firstName"), resultSet.getString("secondName"),
                                resultSet.getString("email"), resultSet.getString("phoneNumber"));

                        users.setId(resultSet.getInt("id"));

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
            log.warn("Cannot read user", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }

        if (null == users) {
            log.debug("Users not found");
        } else {
            log.trace("Users " + id + " found");
        }
        log.trace("Returning users");
        return users;
    }

    @Override
    public Users update(long id, String email, String firstName, String secondName, String phoneNumber) {
        String sql = "update public.users set firstName = ?, secondName = ?, email = ?, phoneNumber = ?, where id = ?";
        Users users = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
       // Set<TestSession> testSession=new HashSet<>();
        try {
            log.trace("Open connection");
            connection = daoFactory.getConnection();
            try {
                log.trace("Create prepared statement");
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, secondName);
                preparedStatement.setString(4, phoneNumber);
                preparedStatement.execute();

                try {
                    log.trace("Get result set");
                    resultSet = preparedStatement.getGeneratedKeys();
                    resultSet.next();
                    log.trace("Create customer to return");
                    users = new Users(resultSet.getString("email"), resultSet.getString("firstName"),
                            resultSet.getString("secondName"), resultSet.getString("phoneNumber"));
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
            log.warn("Cannot update user ", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Users " + id + " has updated info");
        log.trace("Returning updated user");
        return users;
    }
*/
}
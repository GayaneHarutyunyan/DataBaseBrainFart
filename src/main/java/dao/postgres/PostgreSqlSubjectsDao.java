package dao.postgres;


import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PostgreSqlSubjectsDao implements SubjectsDao {
  //  private DaoFactory daoFactory = DaoFactory.getInstance();
   // private static Logger log = Logger.getLogger(PostgreSqlSubjectsDao.class.getName());

    @Override
    public void addSubjects(Subjects subjects) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(subjects);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Subjects readSubjects(long id) throws DaoRuntimeException {
        Subjects result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Subjects) session.get(Subjects.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public void updateSubjects(Subjects subjects) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(session);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteSubjects(Subjects subjects) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(subjects);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public List<Subjects> getSubjects() throws DaoRuntimeException {
        Session session = null;
        List<Subjects> subjectses = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            subjectses = session.createCriteria(Subjects.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return subjectses;
    }


/*

    @Override
    public Subjects create(long id, String subject) {

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
            log.warn("Cannot create Subjects", e);
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
    public Subjects read(long id) {

        log.trace("Get parameters: id=" + id);
        String sql = "select from public.subjects where id = ?;";

        Subjects subjects = null;
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
            log.warn("Cannot create Subjects", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        if (null == subjects) {
            log.debug("Subjects not found");
        } else {
            log.trace("Subjects " + id + " found");
        }
        log.trace("Return Subjects");
        return subjects;

    }

    @Override
    public void delete(long id) {

        log.trace("Get parameters: id=" + id);
        String sql = "delete from public.subjects where id = ?;";
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
                log.info("Subjects " + id + " deleted");
            } finally {
                try {
                    preparedStatement.close();
                    log.trace("statement closed");
                } catch (SQLException e) {
                    log.warn("Cannot close statement", e);
                }
            }
        } catch (SQLException e) {
            log.warn("Cannot create Subjects", e);
        } finally {
            try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
    }
    */
}
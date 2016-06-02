package dao.postgres;


import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import java.sql.*;
import java.util.*;


public class PostgreSqlAnswerOptionsDao implements AnswerOptionsDao {
    //private DaoFactory daoFactory = DaoFactory.getInstance();
   // private static Logger log = Logger.getLogger(PostgreSqlAnswerOptionsDao.class.getName());

    @Override
    public void addAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(answerOptions);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(answerOptions);
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(answerOptions);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public AnswerOptions readAnswerOptions(long id) throws DaoRuntimeException {
        AnswerOptions result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (AnswerOptions) session.get(AnswerOptions.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<AnswerOptions> getAnswerOptions() throws DaoRuntimeException {
        Session session = null;
        List<AnswerOptions> answerOptionses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            answerOptionses = session.createCriteria(AnswerOptions.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return answerOptionses;
    }


/*

    @Override
    public AnswerOptions create(long id, String content, boolean correctness) {
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
    public AnswerOptions read(long id) {

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
    public void delete(long id) {
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
    public List<AnswerOptions> getAll() {

        List<AnswerOptions> answerOptionses = new ArrayList<>();

        String sql = "SELECT * FROM public.answer_options";


        AnswerOptions answerOptions = null;
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
                        log.trace("Create answerOptions to add to the set");

                        answerOptions = new AnswerOptions(resultSet.getString("content"), resultSet.getBoolean("correctness"));
                        answerOptions.setId(resultSet.getLong("id"));
                        answerOptionses.add(answerOptions);
                        log.trace("AnswerOptions " + answerOptions.getId() + " added to set");
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
            log.warn("Cannot get all answerOptionses", e);
            } finally {
                try {
                connection.close();
                log.trace("Connection closed");
            } catch (SQLException e) {
                log.warn("Cannot close connection", e);
            }
        }
        log.trace("Returning answerOptionses");
        return answerOptionses;
    }
    */


}

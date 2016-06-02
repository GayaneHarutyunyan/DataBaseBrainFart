package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import modelAdmin.*;
import org.hibernate.Session;

import java.util.*;


public class PosgreSqlAdminDao implements AdminDao {

   // private DaoFactory daoFactory = DaoFactory.getInstance();
   // private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PosgreSqlAdminDao.class.getName());

    @Override
    public void addAdmins(Admins admins) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(admins);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteAdmins(Admins admins) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(admins);
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateAdmins(Admins admins) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(admins);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Admins readAdmins(long id) throws DaoRuntimeException {
        Admins result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Admins) session.get(Admins.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;    }

    @Override
    public List<Admins> getAdmins() throws DaoRuntimeException {
        Session session = null;
        List<Admins>  adminses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            adminses = session.createCriteria(Admins.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return adminses;
    }
/*
    @Override
    public List<Admins> getAll() {
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
            log.warn ("Cannot get all adminses", e);
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
    */
}

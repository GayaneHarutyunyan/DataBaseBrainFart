package dao.postgres;

import app.HibernateUtil;
import dao.*;
import exception.*;
import model.Admins;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.apache.log4j.*;
import java.util.*;

@Repository
public class PosgreSqlAdminDao implements AdminDao {
    private static Logger log = Logger.getLogger(PosgreSqlAdminDao.class.getName());

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
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Admins> getAdmins() throws DaoRuntimeException {
        Session session = null;
        List<Admins> adminses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            adminses = session.createCriteria(Admins.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return adminses;
    }
}
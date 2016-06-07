package dao.postgres;

import app.HibernateUtil;
import dao.PowersDao;
import exception.DaoRuntimeException;
import model.Admins;
import model.Powers;
import model.Subjects;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaya on 07.06.2016.
 */
public class PosgreSqlPowersDao implements PowersDao {

    @Override
    public void addPowers(Powers powers) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(powers);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Powers readPowers(long id) throws DaoRuntimeException {
        Powers result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Powers) session.get(Powers.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;    }

    @Override
    public void updatePowers(Powers powers) throws DaoRuntimeException {

    }

    @Override
    public void deletePowers(Powers powers) throws DaoRuntimeException {

    }

    @Override
    public List<Powers> getPowers() throws DaoRuntimeException {

        Session session = null;
        List<Powers> powerses = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            powerses = session.createCriteria(Powers.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return powerses;
    }
}

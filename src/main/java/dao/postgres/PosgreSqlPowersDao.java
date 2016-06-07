package dao.postgres;

import app.HibernateUtil;
import dao.PowersDao;
import exception.DaoRuntimeException;
import model.Powers;
import org.hibernate.Session;

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
        return null;
    }

    @Override
    public void updatePowers(Powers powers) throws DaoRuntimeException {

    }

    @Override
    public void deletePowers(Powers powers) throws DaoRuntimeException {

    }

    @Override
    public List<Powers> getPowers() throws DaoRuntimeException {
        return null;
    }
}

package dao.postgres;

import dao.*;
import exception.DAOException;
import modelAdmin.Admins;
import org.apache.log4j.Logger;

import java.util.*;


public class PosgreSqlAdminDao implements AdminDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PosgreSqlAdminDao.class.getName());


    @Override
    public List<Admins> getAll() throws DAOException {
        List<Admins> adminses = new ArrayList<>();
        return adminses;
    }
}

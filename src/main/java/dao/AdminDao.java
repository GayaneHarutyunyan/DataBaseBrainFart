package dao;

import exception.DAOException;
import modelAdmin.Admins;

import java.util.List;

/**
 * Created by mystic on 17.05.2016.
 */
public interface AdminDao {

    List<Admins> getAll() throws DAOException;
}

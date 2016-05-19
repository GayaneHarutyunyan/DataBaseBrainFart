package dao;

import exception.DAOException;
import modelAdmin.Admins;

import java.util.List;


public interface AdminDao {

    List<Admins> getAll() throws DAOException;
}

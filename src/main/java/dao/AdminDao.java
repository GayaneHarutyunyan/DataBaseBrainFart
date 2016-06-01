package dao;

import exception.DaoRuntimeException;
import modelAdmin.Admins;

import java.util.List;


public interface AdminDao {

    List<Admins> getAll() throws DaoRuntimeException;
}

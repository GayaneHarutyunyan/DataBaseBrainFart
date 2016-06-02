package dao;

import exception.*;
import modelAdmin.*;

import java.util.*;


public interface AdminDao {

    void addAdmins(Admins admins) throws DaoRuntimeException;

    Admins readAdmins(long id) throws DaoRuntimeException;

    void updateAdmins(Admins admins) throws DaoRuntimeException;

    void deleteAdmins(Admins admins) throws DaoRuntimeException;

    List<Admins> getAdmins() throws DaoRuntimeException;


    //  List<Admins> getAll() throws DaoRuntimeException;
}

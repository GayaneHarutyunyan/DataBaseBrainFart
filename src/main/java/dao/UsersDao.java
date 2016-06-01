package dao;


import exception.*;
import model.*;

public interface UsersDao {

    Users create(long id, String firstName, String secondName, String email, String phoneNumber) throws DaoRuntimeException;

    Users read(long id) throws DaoRuntimeException;

    Users update(long id, String email, String firstName, String secondName, String phoneNumber) throws DaoRuntimeException;

}
package dao;


import exception.*;
import model.*;

import java.util.List;

public interface UsersDao {

    void addUser(Users users) throws DaoRuntimeException;

    //получение по id
    Users readUser(long id) throws DaoRuntimeException;

    void updateUser(Users users) throws DaoRuntimeException;

    void deleteUser(Users users) throws DaoRuntimeException;

    List<Users> getUser() throws DaoRuntimeException;

}
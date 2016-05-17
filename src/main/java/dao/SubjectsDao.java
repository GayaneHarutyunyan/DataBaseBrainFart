package dao;

import exception.DAOException;


public interface SubjectsDao {

    SubjectsDao create(long id, String subject) throws DAOException;

    SubjectsDao read(long id) throws DAOException;

    void delete(long id) throws DAOException;
}

package dao;

import exception.DAOException;
import model.Subjects;


public interface SubjectsDao {

    Subjects create(long id, String subject) throws DAOException;

    Subjects read(long id) throws DAOException;

    void delete(long id) throws DAOException;
}

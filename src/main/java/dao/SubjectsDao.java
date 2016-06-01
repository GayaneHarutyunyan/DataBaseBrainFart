package dao;

import exception.DaoRuntimeException;
import model.Subjects;


public interface SubjectsDao {

    Subjects create(long id, String subject) throws DaoRuntimeException;

    Subjects read(long id) throws DaoRuntimeException;

    void delete(long id) throws DaoRuntimeException;
}

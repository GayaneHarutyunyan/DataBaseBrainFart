package dao;

import exception.*;
import model.*;


import java.util.*;


public interface SubjectsDao {

    void addSubjects(Subjects subjects) throws DaoRuntimeException;

    Subjects readSubjects(long id) throws DaoRuntimeException;

    void updateSubjects(Subjects subjects) throws DaoRuntimeException;

    void deleteSubjects(Subjects subjects) throws DaoRuntimeException;

    List<Subjects> getSubjects() throws DaoRuntimeException;

}

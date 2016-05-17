package dao;

import exception.DAOException;
import model.Questions;


public interface QuestionDao {

    Questions create(long id, String content, Integer value) throws DAOException;

    Questions read(long id) throws DAOException;

    void delete(long id) throws DAOException;
}

package dao;

import exception.DAOException;
import model.Questions;


public interface QuestionDao {

    Questions create(long id, String content, Integer value) throws DAOException;

    Questions read() throws DAOException;

    void delete() throws DAOException;
}

package dao;

import exception.DaoRuntimeException;
import model.Questions;


public interface QuestionDao {

    Questions create(long id, String content, Integer value) throws DaoRuntimeException;

    Questions read(long id) throws DaoRuntimeException;

    void delete(long id) throws DaoRuntimeException;
}

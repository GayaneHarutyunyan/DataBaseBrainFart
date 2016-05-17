package dao;

import exception.DAOException;
import model.AnswerOptions;

public interface AnswerOptionsDao {

    AnswerOptions create(long id, String content, boolean correctness) throws DAOException;

    AnswerOptions read(long id) throws DAOException;

    void delete(long id) throws DAOException;
}

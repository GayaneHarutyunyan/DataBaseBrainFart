package dao;

import exception.DAOException;

public interface AnswerOptionsDao {

    AnswerOptionsDao create(long id, String content, boolean correctness) throws DAOException;

    AnswerOptionsDao read(long id) throws DAOException;

    void delete(long id) throws DAOException;
}

package dao;

import exception.DAOException;
import model.AnswerOptions;

import java.util.List;

public interface AnswerOptionsDao {

    AnswerOptions create(long id, String content, boolean correctness) throws DAOException;

    AnswerOptions read(long id) throws DAOException;

    void delete(long id) throws DAOException;

    List<AnswerOptions> getAll() throws DAOException;
}

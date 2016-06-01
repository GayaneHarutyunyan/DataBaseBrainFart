package dao;

import exception.DaoRuntimeException;
import model.AnswerOptions;

import java.util.List;

public interface AnswerOptionsDao {

    AnswerOptions create(long id, String content, boolean correctness) throws DaoRuntimeException;

    AnswerOptions read(long id) throws DaoRuntimeException;

    void delete(long id) throws DaoRuntimeException;

    List<AnswerOptions> getAll() throws DaoRuntimeException;
}

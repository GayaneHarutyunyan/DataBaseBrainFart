package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;

public interface AnswerOptionsDao {

    void addAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException;

    AnswerOptions readAnswerOptions(long id) throws DaoRuntimeException;

    void updateAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException;

    void deleteAnswerOptions(AnswerOptions answerOptions) throws DaoRuntimeException;

    List<AnswerOptions> getAnswerOptions() throws DaoRuntimeException;

    /*
    AnswerOptions create(long id, String content, boolean correctness) throws DaoRuntimeException;

    AnswerOptions read(long id) throws DaoRuntimeException;

    void delete(long id) throws DaoRuntimeException;

    List<AnswerOptions> getAll() throws DaoRuntimeException;
    */
}

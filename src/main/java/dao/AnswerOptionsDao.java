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
    }

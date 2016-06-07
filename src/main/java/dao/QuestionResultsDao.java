package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;


public interface QuestionResultsDao {

    void addQuestionResults(QuestionResults questionResults) throws DaoRuntimeException;

    QuestionResults readQuestionResults(long id) throws DaoRuntimeException;

    void updateQuestionResults(QuestionResults questionResults) throws DaoRuntimeException;

    void deleteQuestionResults(QuestionResults questionResults) throws DaoRuntimeException;

    List<QuestionResults> getQuestionResults() throws DaoRuntimeException;

}

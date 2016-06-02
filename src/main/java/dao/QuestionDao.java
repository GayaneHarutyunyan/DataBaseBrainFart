package dao;

import exception.*;
import model.*;

import java.util.*;


public interface QuestionDao {

    void addQuestions(Questions questions) throws DaoRuntimeException;

    Questions readQuestions(long id) throws DaoRuntimeException;

    void updateQuestions(Questions questions) throws DaoRuntimeException;

    void deleteQuestions(Questions questions) throws DaoRuntimeException;

    List<Questions> getQuestions() throws DaoRuntimeException;

    /*
    Questions create(long id, String content, Integer value) throws DaoRuntimeException;

    Questions read(long id) throws DaoRuntimeException;

    void delete(long id) throws DaoRuntimeException;
    */
}

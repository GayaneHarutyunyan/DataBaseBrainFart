package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;

public interface QuestionConnectionsDao {

    void addQuestionConnections(QuestionConnections questionConnections) throws DaoRuntimeException;

    QuestionConnections readQuestionConnections(long id) throws DaoRuntimeException;

    void updateQuestionConnections(QuestionConnections questionConnections) throws DaoRuntimeException;

    void deleteQuestionConnections(QuestionConnections questionConnections) throws DaoRuntimeException;


    List<QuestionConnections> getQuestionConnections() throws DaoRuntimeException;

}

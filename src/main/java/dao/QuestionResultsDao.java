package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;


public interface QuestionResultsDao {

    List<QuestionResults> getAll() throws DaoRuntimeException;
}

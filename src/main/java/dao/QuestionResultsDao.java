package dao;

import exception.DAOException;
import model.*;

import java.util.*;


public interface QuestionResultsDao {

    List<QuestionResults> getAll() throws DAOException;
}

package dao;

import exception.DAOException;
import model.*;

import java.util.*;

public interface QuestionConnectionsDao {
    List<QuestionConnections> getAll() throws DAOException;
}

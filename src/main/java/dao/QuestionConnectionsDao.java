package dao;

import exception.DaoRuntimeException;
import model.*;

import java.util.*;

public interface QuestionConnectionsDao {
    List<QuestionConnections> getAll() throws DaoRuntimeException;
}

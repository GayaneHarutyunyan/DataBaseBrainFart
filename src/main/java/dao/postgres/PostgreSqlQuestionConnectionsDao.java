package dao.postgres;

import dao.DaoFactory;
import dao.QuestionConnectionsDao;
import exception.DAOException;
import model.QuestionConnections;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mystic on 19.05.2016.
 */
public class PostgreSqlQuestionConnectionsDao implements QuestionConnectionsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlQuestionConnectionsDao.class.getName());

    @Override
    public List<QuestionConnections> getAll() throws DAOException {
        List<QuestionConnections> questionConnectionses = new ArrayList<>();

        return questionConnectionses;
    }
}

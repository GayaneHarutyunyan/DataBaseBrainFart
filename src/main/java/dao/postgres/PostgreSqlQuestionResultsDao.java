package dao.postgres;

import com.sun.jmx.remote.internal.ArrayQueue;
import dao.DaoFactory;
import dao.QuestionResultsDao;
import exception.DAOException;
import model.QuestionResults;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mystic on 19.05.2016.
 */
public class PostgreSqlQuestionResultsDao implements QuestionResultsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlQuestionResultsDao.class.getName());

    @Override
    public List<QuestionResults> getAll() throws DAOException {
        List<QuestionResults> questionResultses = new ArrayList<>();
        return questionResultses;
    }
}

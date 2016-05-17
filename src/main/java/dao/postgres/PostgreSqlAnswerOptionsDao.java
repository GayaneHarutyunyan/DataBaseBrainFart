package dao.postgres;


import dao.AnswerOptionsDao;
import dao.DaoFactory;
import exception.DAOException;
import model.AnswerOptions;
import org.apache.log4j.Logger;

public class PostgreSqlAnswerOptionsDao implements AnswerOptionsDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestsDao.class.getName());


    @Override
    public AnswerOptions create(long id, String content, boolean correctness) throws DAOException {
        AnswerOptions answerOptions = null;
        return answerOptions;
    }

    @Override
    public AnswerOptions read(long id) throws DAOException {
        AnswerOptions answerOptions = null;
        return answerOptions;
    }

    @Override
    public void delete(long id) throws DAOException {
        AnswerOptions answerOptions = null;
    }
}

package dao.postgres;


import dao.DaoFactory;
import dao.QuestionDao;
import exception.DAOException;
import model.Questions;
import org.apache.log4j.Logger;

public class PostgreSqlQuestionDao implements QuestionDao {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static Logger log = Logger.getLogger(PostgreSqlTestsDao.class.getName());

    @Override
    public Questions create(long id, String content, Integer value) throws DAOException {
        Questions questions = null;
        return questions;
    }

    @Override
    public Questions read() throws DAOException {
        Questions questions = null;
        return questions;
    }

    @Override
    public void delete() throws DAOException {
        Questions questions = null;
    }

}

package utils.fdb;

import dao.QuestionConnectionDao;
import models.QuestionConnection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionConnectionFileDao")
public class QuestionConnectionFileDao extends FileAbstractDao<QuestionConnection> implements QuestionConnectionDao {

    public QuestionConnectionFileDao() {

    }

    @Override
    public List<QuestionConnection> getAll() {
        return null;
    }

    @Override
    public QuestionConnection getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

}

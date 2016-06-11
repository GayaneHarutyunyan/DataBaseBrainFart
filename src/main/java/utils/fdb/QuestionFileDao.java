package utils.fdb;

import dao.QuestionDao;
import models.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionFileDao")
public class QuestionFileDao extends FileAbstractDao<Question> implements QuestionDao {

    public QuestionFileDao() {

    }

    @Override
    public List<Question> getAll() {
        return null;
    }

    @Override
    public Question getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }
}

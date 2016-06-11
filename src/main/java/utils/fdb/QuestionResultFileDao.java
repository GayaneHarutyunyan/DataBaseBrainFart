package utils.fdb;

import dao.QuestionResultDao;
import models.QuestionResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("questionResultFileDao")
public class QuestionResultFileDao extends FileAbstractDao<QuestionResult> implements QuestionResultDao {

    public QuestionResultFileDao() {

    }

    @Override
    public List<QuestionResult> getAll() {
        return null;
    }

    @Override
    public QuestionResult getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

}

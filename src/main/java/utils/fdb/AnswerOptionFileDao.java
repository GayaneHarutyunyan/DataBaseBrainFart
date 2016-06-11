package utils.fdb;

import dao.AnswerOptionDao;
import models.AnswerOption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("answerOptionFileDao")
public class AnswerOptionFileDao extends FileAbstractDao<AnswerOption> implements AnswerOptionDao {

    public AnswerOptionFileDao() {

    }

    @Override
    public List<AnswerOption> getAll() {
        return null;
    }

    @Override
    public AnswerOption getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }
}

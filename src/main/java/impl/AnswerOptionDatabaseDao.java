package impl;

import dao.AnswerOptionDao;
import models.AnswerOption;
import org.springframework.stereotype.Repository;


@Repository(value = "answerOptionDatabaseDao")
public class AnswerOptionDatabaseDao extends HibernateAbstractDao<AnswerOption> implements AnswerOptionDao {

    public AnswerOptionDatabaseDao() {

    }


}

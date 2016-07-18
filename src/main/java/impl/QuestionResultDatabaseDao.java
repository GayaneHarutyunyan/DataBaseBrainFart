package impl;

import dao.QuestionResultDao;
import models.QuestionResult;
import org.springframework.stereotype.Repository;

@Repository(value = "questionResultDatabaseDao")
public class QuestionResultDatabaseDao extends HibernateAbstractDao<QuestionResult> implements QuestionResultDao {


    public QuestionResultDatabaseDao() {

    }

}

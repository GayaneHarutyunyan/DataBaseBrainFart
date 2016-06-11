package impl;

import dao.QuestionResultDao;
import models.QuestionResult;
import org.springframework.stereotype.Repository;

@Repository(value = "questionResutDatabaseDao")
public class QuestionResutDatabaseDao extends HibernateAbstractDao<QuestionResult> implements QuestionResultDao {


    public QuestionResutDatabaseDao() {

    }

}

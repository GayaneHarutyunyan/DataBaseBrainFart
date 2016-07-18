package impl;

import dao.QuestionDao;
import models.Question;
import org.springframework.stereotype.Repository;


@Repository(value = "questionDatabaseDao")
public class QuestionDatabaseDao extends HibernateAbstractDao<Question> implements QuestionDao {


    public QuestionDatabaseDao() {

    }

}

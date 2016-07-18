package impl;

import dao.QuestionConnectionDao;
import models.QuestionConnection;
import org.springframework.stereotype.Repository;


@Repository(value = "questionConnectionDatabaseDao")
public class QuestionConnectionDatabaseDao extends HibernateAbstractDao<QuestionConnection> implements QuestionConnectionDao {

    public QuestionConnectionDatabaseDao() {

    }

   }

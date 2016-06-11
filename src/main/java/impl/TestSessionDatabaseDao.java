package impl;

import dao.TestSessionDao;
import models.TestSession;
import org.springframework.stereotype.Repository;

@Repository(value = "testSessionDatabaseDao")
public class TestSessionDatabaseDao extends HibernateAbstractDao<TestSession> implements TestSessionDao {


    public TestSessionDatabaseDao() {

    }

}

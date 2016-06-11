package impl;

import dao.TestDao;
import models.Test;
import org.springframework.stereotype.Repository;

@Repository(value = "testDatabaseDao")
public class TestDatabaseDao extends HibernateAbstractDao<Test> implements TestDao {

    public TestDatabaseDao() {

    }


}

package impl;

import dao.TestAvailabilityDao;
import models.TestAvailability;
import org.springframework.stereotype.Repository;


@Repository(value = "testAwailableDatabaseDao")
public class TestAwailableDatabaseDao extends HibernateAbstractDao<TestAvailability> implements TestAvailabilityDao {

    public TestAwailableDatabaseDao() {

    }

}

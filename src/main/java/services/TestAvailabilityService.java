package services;

import dao.TestAvailabilityDao;
import models.TestAvailability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "testAvailabilityService")
public class TestAvailabilityService {

    @Autowired
    @Qualifier("testAwailableDatabaseDao")
    private TestAvailabilityDao testAvailabilityDao;

    public TestAvailabilityService() {
    }

@Transactional
    public List<TestAvailability> getAll() {
        return testAvailabilityDao.getAll();
    }
}

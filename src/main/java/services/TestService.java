package services;

import dao.TestDao;
import models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "testService")
public class TestService {

    @Autowired
    @Qualifier("testDatabaseDao")
    private TestDao testDao;


    public TestService() {
    }

    @Transactional
    public List<Test> getAll() {
        return testDao.getAll();
    }
}

package services;

import dao.TestSessionDao;
import models.TestSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "testSessionService")
public class TestSessionService {

    @Autowired
    @Qualifier("testSessionDatabaseDao")
    private TestSessionDao testSessionDao;

    public TestSessionService() {

    }
    @Transactional
    public List<TestSession> getAll(){
        return testSessionDao.getAll();
    }
}

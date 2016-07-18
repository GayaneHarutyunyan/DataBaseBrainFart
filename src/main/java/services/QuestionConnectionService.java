package services;

import dao.QuestionConnectionDao;
import models.QuestionConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "questionConnectionService")
public class QuestionConnectionService {

    @Autowired
    @Qualifier("questionConnectionDatabaseDao")
    private QuestionConnectionDao questionConnectionDao;

    public QuestionConnectionService() {
    }

    @Transactional
    public List<QuestionConnection> getAll() {
        return questionConnectionDao.getAll();
    }
}

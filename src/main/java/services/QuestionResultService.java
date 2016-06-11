package services;

import dao.QuestionResultDao;
import models.QuestionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "questionResultService")
public class QuestionResultService {

    @Autowired
    @Qualifier("questionResutDatabaseDao")
    private QuestionResultDao questionResultDao;


    public QuestionResultService() {

    }

    @Transactional
    public List<QuestionResult> getALL() {
        return questionResultDao.getAll();
    }
}

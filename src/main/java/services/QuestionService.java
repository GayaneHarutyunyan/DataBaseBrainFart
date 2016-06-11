package services;

import dao.QuestionDao;
import models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "questionService")
public class QuestionService {

    @Autowired
    @Qualifier("questionDatabaseDao")
    private QuestionDao questionDao;

    public QuestionService() {
    }

    @Transactional
    public List<Question> getAll(){
        return questionDao.getAll();
    }
}

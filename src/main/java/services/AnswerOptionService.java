package services;

import dao.AnswerOptionDao;
import models.AnswerOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "answerOptionService")
public class AnswerOptionService {

    @Autowired
    @Qualifier("answerOptionDatabaseDao")
    private AnswerOptionDao answerOptionDao;

    public AnswerOptionService() {
    }

    @Transactional
    public List<AnswerOption> getALL() {
        return answerOptionDao.getAll();
    }
}

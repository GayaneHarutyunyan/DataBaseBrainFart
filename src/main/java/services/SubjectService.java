package services;

import dao.SubjectDao;
import models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "subjectService")
public class SubjectService {

    @Autowired
    @Qualifier("subjectDatabaseDao")
    private SubjectDao subjectDao;

    public SubjectService() {
    }

    @Transactional
    public List<Subject> getAll() {
        return subjectDao.getAll();
    }
}

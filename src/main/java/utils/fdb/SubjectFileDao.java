package utils.fdb;

import dao.SubjectDao;
import models.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("subjectFileDao")
public class SubjectFileDao extends FileAbstractDao<Subject> implements SubjectDao {


    @Override
    public List<Subject> getAll() {
        return null;
    }

    @Override
    public Subject getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }
}

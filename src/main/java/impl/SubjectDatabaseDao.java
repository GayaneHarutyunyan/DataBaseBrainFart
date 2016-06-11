package impl;

import dao.SubjectDao;
import models.Subject;
import org.springframework.stereotype.Repository;


@Repository(value = "subjectDatabaseDao")
public class SubjectDatabaseDao extends HibernateAbstractDao<Subject> implements SubjectDao {

    public SubjectDatabaseDao() {

    }

}

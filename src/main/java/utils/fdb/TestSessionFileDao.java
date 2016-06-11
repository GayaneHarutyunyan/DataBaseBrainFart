package utils.fdb;

import dao.TestSessionDao;
import models.TestSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testSessionFileDao")
public class TestSessionFileDao extends FileAbstractDao<TestSession> implements TestSessionDao {

    public TestSessionFileDao(){

    }

    @Override
    public List<TestSession> getAll() {
        return null;
    }

    @Override
    public TestSession getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }
}

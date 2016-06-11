package utils.fdb;

import dao.TestDao;
import models.Test;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("testFileDao")
public class TestFileDao extends FileAbstractDao<Test> implements TestDao {

    public TestFileDao() {

    }

    @Override
    public List<Test> getAll() {
        return null;
    }

    @Override
    public Test getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

}

package utils.fdb;

import dao.TestAvailabilityDao;
import models.TestAvailability;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testAvailableFileDao")
public class TestAvailableFileDao extends FileAbstractDao<TestAvailability> implements TestAvailabilityDao {

    public TestAvailableFileDao() {

    }

    @Override
    public List<TestAvailability> getAll() {
        return null;
    }

    @Override
    public TestAvailability getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }
}

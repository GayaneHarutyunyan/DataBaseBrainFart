package utils.fdb;

import dao.UserDao;
import models.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userFileDao")
public class UserFileDao extends FileAbstractDao<User> implements UserDao {

    public UserFileDao() {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }
}

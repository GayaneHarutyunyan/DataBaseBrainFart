package utils.fdb;

import dao.AdminDao;
import models.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminFileDao")
public class AdminFileDao extends FileAbstractDao<Admin> implements AdminDao {

    public AdminFileDao() {

    }

    @Override
    public List<Admin> getAll() {
        return null;
    }

    @Override
    public Admin getById(Long id) {
        return null;
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public Admin getByAdminRole(String role) {
        return null;
    }
}

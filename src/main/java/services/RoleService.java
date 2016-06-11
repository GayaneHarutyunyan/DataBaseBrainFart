package services;

import dao.RoleDao;
import models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "roleService")
public class RoleService {

    @Autowired
    @Qualifier("roleDatabaseDao")
    private RoleDao roleDao;

    public RoleService() {
    }

    @Transactional
    public List<Role> getAll() {
        return roleDao.getAll();
    }
}

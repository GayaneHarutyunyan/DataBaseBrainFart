package impl;

import dao.RoleDao;
import models.Role;
import org.springframework.stereotype.Repository;


@Repository(value = "roleDatabaseDao")
public class RoleDatabaseDao extends HibernateAbstractDao<Role> implements RoleDao {

    public RoleDatabaseDao() {

    }


}

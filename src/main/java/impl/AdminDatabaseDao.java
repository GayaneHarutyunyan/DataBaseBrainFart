package impl;

import dao.AdminDao;
import models.Admin;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository(value = "adminDatabaseDao")
public class AdminDatabaseDao extends HibernateAbstractDao<Admin> implements AdminDao {

    public AdminDatabaseDao() {

    }

    @Override
    public Admin getByAdminRole(String role) {
        Criteria criteria = getSession().createCriteria(Admin.class);
        criteria.add(Restrictions.eq("AdminRole", role));
        return (Admin) criteria.uniqueResult();
    }
}

package impl;

import dao.UserDao;
import models.User;
import org.springframework.stereotype.Repository;


@Repository(value = "userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

    public UserDatabaseDao(){

    }

    }

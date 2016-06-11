package services;

import dao.UserDao;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserService  {

    @Autowired
    @Qualifier(value = "userDatabaseDao")
    private UserDao userDao;

    public UserService() {

    }

    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }
}

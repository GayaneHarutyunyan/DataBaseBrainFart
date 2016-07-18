package services;

import dao.AdminDao;
import models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "adminService")
public class AdminService implements UserDetailsService {

    @Autowired
    @Qualifier("adminDatabaseDao")
    private AdminDao adminDao;

    public AdminService() {
    }

    @Transactional
    public List<Admin> getALL() {
        return adminDao.getAll();
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String adminRole) throws UsernameNotFoundException {
        Admin admin = adminDao.getByAdminRole(adminRole);
        System.err.println("blablabasdlas "+adminRole.toString());
        if (admin == null){
            throw new UsernameNotFoundException("Admin with Admin role: "+adminRole+" not found!");
        }
            return (UserDetails) admin;
    }
}

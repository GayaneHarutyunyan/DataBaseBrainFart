package dao;

import models.Admin;


public interface AdminDao extends ItemDao<Admin> {

    public Admin getByAdminRole(String role);
}

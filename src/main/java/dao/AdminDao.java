package dao;

import models.Admin;


public interface AdminDao extends ItemDao<Admin> {

     Admin getByAdminRole(String role);
}

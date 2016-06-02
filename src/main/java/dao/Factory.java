package dao;

import dao.postgres.PostgreSqlUsersDao;


public class Factory {
    public static Factory factory = new Factory();
    public UsersDao usersDao;

    private Factory() {

    }

    public static Factory getFactory() {
        return Factory.factory;
    }

    public UsersDao getUsersDao() {
        if (usersDao == null) usersDao = new PostgreSqlUsersDao();
        return usersDao;
    }
}

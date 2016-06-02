package dao;


import model.Users;

import java.util.List;

/**
 * Created by gaya on 02.06.2016.
 */
public class Project {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory();
        UsersDao usersDao = factory.getUsersDao();
/*
        Users users = new Users();
        users.setEmail("harutyunyan15@mail.ru");
        users.setPhoneNumber("0635827207");
        users.setSecondName("Harutyunyan");
        users.setFirstName("Gayane");
        usersDao.addUser(users);
/*


 */
/*
      Users users=  usersDao.readUser(1);
        System.out.println(
                users.getId() + " "
                        + users.getFirstName() + " "
                        + users.getSecondName() + " "
                        + users.getPhoneNumber() + " "
                        + users.getEmail());
*/
        /*
        List<Users> userses = usersDao.getUser();

        System.out.println("aaa aaaa aaa aaa");

        for (Users users : userses) {
            System.out.println(
                    users.getId() + " "
                            + users.getFirstName() + " "
                            + users.getSecondName() + " "
                            + users.getPhoneNumber() + " "
                            + users.getEmail());
        }
*/
        /*
        Users users = new Users();
        users.setId(1);
        usersDao.deleteUser(users);

       // usersDao.deleteUser(usersDao.readUser(1));
        */
/*
        Users users = new Users();
        users.setId(1);
        users.setEmail("harutyunyan@mail.ru");
        users.setPhoneNumber("0685882120");
        users.setSecondName("Harutyunyan");
        users.setFirstName("Gayane");
        usersDao.updateUser(users);
*/
    }

}

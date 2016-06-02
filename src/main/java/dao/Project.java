package dao;

import model.*;
import modelAdmin.*;

import java.util.*;

/**
 * Created by gaya on 02.06.2016.
 */
public class Project {
    public static void main(String[] args) {
        Factory factory = Factory.getFactory();
        UsersDao usersDao = factory.getUsersDao();
        TestSessionDao testSessionDao = factory.getTestSessionDao();
        TestsDao testsDao = factory.getTestsDao();
        TestAvailabilityDao testAvailabilityDao = factory.getTestAvailabilityDao();
        SubjectsDao subjectsDao = factory.getSubjectsDao();
        QuestionResultsDao questionResultsDao = factory.getQuestionResultsDao();
        QuestionDao questionDao = factory.getQuestionDao();
        QuestionConnectionsDao questionConnectionsDao = factory.getQuestionConnectionsDao();
        AnswerOptionsDao answerOptionsDao = factory.getAnswerOptionsDao();
        AdminDao adminDao = factory.getAdminDao();

        //Users users = new Users();
       // TestSession testSession = new TestSession();
        Tests tests = new Tests();
        TestAvailability testAvailability = new TestAvailability();
        Subjects subjects = new Subjects();
        QuestionConnections questionConnections = new QuestionConnections();
        Questions questions = new Questions();
        QuestionResults questionResults = new QuestionResults();
        AnswerOptions answerOptions = new AnswerOptions();
        Admins admins = new Admins();

/*

        users.setEmail("harutyunyan15@mail.ru");
        users.setPhoneNumber("0635827207");
        users.setSecondName("Bukashka ");
        users.setFirstName("Buka");
        usersDao.addUser(users);

        users.setEmail("harutyunyan15@mail.ru");
        users.setPhoneNumber("0635827207");
        users.setSecondName("Gnatovsky");
        users.setFirstName("Andrey");
        usersDao.addUser(users);

        users.setEmail("harutyunyan15@mail.ru");
        users.setPhoneNumber("0635827207");
        users.setSecondName("Karapetyan");
        users.setFirstName("Marat");
        usersDao.addUser(users);
*/


/*
       users=  usersDao.readUser(5);
        System.out.println(
                users.getId() + " "
                        + users.getFirstName() + " "
                        + users.getSecondName() + " "
                        + users.getPhoneNumber() + " "
                        + users.getEmail());
*/
/*
        List<TestSession> testSessions = testAvailabilityDao.getTestAvailability();

        System.out.println("aaa aaaa aaa aaa");

        for (TestSession testSession : userses) {
            System.out.println(
                    testSessions.getId() + " "
                            + testSessions.getFirstName() + " "
                            + users.getSecondName() + " "
                            + users.getPhoneNumber() + " "
                            + users.getEmail()) + " "
                    + users.getTestSession();

        }
*/
        /*
        Users users = new Users();
        users.setId(1);
        usersDao.deleteUser(users);
*/
        /*
        usersDao.deleteUser(usersDao.readUser(1));
        usersDao.deleteUser(usersDao.readUser(2));
        usersDao.deleteUser(usersDao.readUser(3));
        usersDao.deleteUser(usersDao.readUser(4));
        usersDao.deleteUser(usersDao.readUser(5));
        usersDao.deleteUser(usersDao.readUser(6));
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

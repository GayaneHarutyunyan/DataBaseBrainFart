package dao;

import app.Config;
import model.*;
import modelAdmin.*;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by gaya on 02.06.2016.
 */
public class ProjectTest {


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


       users=  usersDao.readUser(5);
        System.out.println(
                users.getId() + " "
                        + users.getFirstName() + " "
                        + users.getSecondName() + " "
                        + users.getPhoneNumber() + " "
                        + users.getEmail());



        Users users = new Users();
        users.setId(1);
        usersDao.deleteUser(users);


        usersDao.deleteUser(usersDao.readUser(1));

        Users users = new Users();
        users.setId(1);
        users.setEmail("harutyunyan@mail.ru");
        users.setPhoneNumber("0685882120");
        users.setSecondName("Harutyunyan");
        users.setFirstName("Gayane");
        usersDao.updateUser(users);
*/


/*
        testListUsers(usersDao);

        testListTests(testsDao);

        testListTestSession(testSessionDao);

        testListTestAvailability(testAvailabilityDao);

        testListSubjects(subjectsDao);

        testListQuestions(questionDao);

        testListQuestionResults(questionResultsDao);

        testListQuestionConnections(questionConnectionsDao);

        testListAnswerOptions(answerOptionsDao);

        testListAdmins(adminDao);
*/
    }

    private static void testListAdmins(AdminDao adminDao) {
        List<Admins> adminses = adminDao.getAdmins();
        for (Admins admins : adminses) {
            Powers powers = admins.getPowersId();
            System.out.println(
                    "   " + powers.getId() +
                            "   " + powers.getPosition() +
                            "   " + admins.getId() +
                            "   " + admins.getEmail() +
                            "   " + admins.getPassword());
        }
    }

    private static void testListAnswerOptions(AnswerOptionsDao answerOptionsDao) {
        List<AnswerOptions> answerOptionses = answerOptionsDao.getAnswerOptions();
        for (AnswerOptions answerOptions : answerOptionses) {
            Questions questions = answerOptions.getQuestionsId();

            System.out.println(
                    "   " + questions.getId() +
                            "   " + questions.getContent() +
                            "   " + questions.getValue() +
                            "   " + answerOptions.getId() +
                            "   " + answerOptions.getContent() +
                            "   " + answerOptions.isCorrectness());
        }
    }

    private static void testListQuestionConnections(QuestionConnectionsDao questionConnectionsDao) {
        List<QuestionConnections> questionConnectionses = questionConnectionsDao.getQuestionConnections();
        for (QuestionConnections questionConnections : questionConnectionses) {
            Questions questions = questionConnections.getQuestionId();
            Tests tests = questionConnections.getTestsId();
            System.out.println("   " + tests.getId() +
                    "   " + tests.getSubjectId() +
                    "   " + tests.getDescription() +
                    "   " + tests.getName() +
                    "   " + tests.isPublicity() +
                    "   " + questions.getId() +
                    "   " + questions.getContent() +
                    "   " + questions.getValue());

        }
    }

    private static void testListQuestions(QuestionDao questionDao) {
        List<Questions> questionses = questionDao.getQuestions();
        for (Questions questions : questionses) {
            System.out.println(
                    "   " + questions.getId() +
                            "   " + questions.getContent() +
                            "   " + questions.getValue());
        }
    }

    private static void testListSubjects(SubjectsDao subjectsDao) {
        List<Subjects> subjectses = subjectsDao.getSubjects();
        for (Subjects subjects : subjectses) {
            System.out.println(
                    "   " + subjects.getId() +
                            "   " + subjects.getSubject());
        }
    }

    private static void testListUsers(UsersDao usersDao) {
        List<Users> userses = usersDao.getUser();

        for (Users users : userses) {
            System.out.println(
                    "   " + users.getId() +
                            "   " + users.getFirstName() +
                            "   " + users.getSecondName() +
                            "   " + users.getPhoneNumber() +
                            "   " + users.getEmail());
        }
    }

    private static void testListTestAvailability(TestAvailabilityDao testAvailabilityDao) {
        List<TestAvailability> testAvailabilities = testAvailabilityDao.getTestAvailability();
        for (TestAvailability testAvailability : testAvailabilities) {
            Tests tests = testAvailability.getTestId();
            System.out.println(
                    "   " + tests.getId() +
                            "   " + tests.getSubjectId() +
                            "   " + tests.getDescription() +
                            "   " + tests.getName() +
                            "   " + tests.isPublicity() +
                            "   " + testAvailability.getId() +
                            "   " + testAvailability.getEndDate() +
                            "   " + testAvailability.getStartDate());
        }
    }

    private static void testListTestSession(TestSessionDao testSessionDao) {
        List<TestSession> testSessions = testSessionDao.getTestSession();
        for (TestSession testSession : testSessions) {
            Users users = testSession.getUserId();
            System.out.println(
                    "   " + users.getId() +
                            "   " + users.getFirstName() +
                            "   " + users.getSecondName() +
                            "   " + users.getEmail() +
                            "   " + testSession.getId() +
                            "   " + testSession.getSubmitDate() +
                            "   " + testSession.getTestResult());
        }
    }

    private static void testListTests(TestsDao testsDao) {
        List<Tests> testses = testsDao.getTests();
        for (Tests tests : testses) {
            Subjects subjects = tests.getSubjectId();
            System.out.println(
                    "   " + subjects.getId() +
                            "   " + subjects.getSubject() +
                            "   " + tests.getId() +
                            "   " + tests.getDescription() +
                            "   " + tests.getName() +
                            "   " + tests.isPublicity());
        }
    }

    private static void testListQuestionResults(QuestionResultsDao questionResultsDao) {
        List<QuestionResults> questionResultses = questionResultsDao.getQuestionResults();
        for (QuestionResults questionResults : questionResultses) {
            QuestionConnections questionConnections = questionResults.getQuestionConnectionsId();
            TestSession testSession = questionResults.getTestSessionId();
            System.out.println(
                    "   " + questionConnections.getId() +
                            "   " + questionConnections.getQuestionId() +
                            "   " + questionConnections.getTestsId() +
                            "   " + testSession.getId() +
                            "   " + testSession.getUserId() +
                            "   " + testSession.getSubmitDate() +
                            "   " + testSession.getTestResult() +
                            "   " + questionResults.getResult());
        }
    }
}

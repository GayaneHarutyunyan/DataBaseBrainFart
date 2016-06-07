package dao;

//import app.Config;

import model.*;

import java.sql.*;
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
        PowersDao powersDao = factory.getPowersDao();


        //*** работает правильно

        Users users = new Users();

        users.setFirstName("Гаяне");
        users.setSecondName("Арутюнян");
        users.setEmail("harutyunyan15@mail.ru");
        users.setPhoneNumber("0635827207");
        usersDao.addUser(users);


        users.setEmail("govorov@mail.ru");
        users.setFirstName("Дима");
        users.setPhoneNumber("0636927001");
        users.setSecondName("Говоров");
        usersDao.addUser(users);

        users.setEmail("bargharut@mail.ru");
        users.setFirstName("Marat");
        users.setPhoneNumber("0635027211");
        users.setSecondName("Karapetyan");
        usersDao.addUser(users);


        //***************************************************************************

//*** работает правильно

        Subjects subjects = new Subjects();

        subjects.setSubject("Java");
        subjectsDao.addSubjects(subjects);

        subjects.setSubject("HTML");
        subjectsDao.addSubjects(subjects);

        subjects.setSubject("CSS");
        subjectsDao.addSubjects(subjects);


//***************************************************************************
        Powers powers = new Powers();
        powers.setPosition("admin");
        powersDao.addPowers(powers);

//***************************************************************************

        /**
         * работает но не коректно не читает powers_id
         */
        Admins admins = new Admins();
        admins.setEmail("karate@mail.ru");
        admins.setPassword("jakAQkmxzQmczsajak");
        //не понятно как записать туда powers_id
        admins.setPowersId(powersDao.readPowers(1));
        adminDao.addAdmins(admins);


//***************************************************************************

        /**
         * работает но не коректно не читает admin_id subject_id
         */

        Tests tests = new Tests();

        tests.setName("Beginner Java");
        tests.setSubjectId(subjectsDao.readSubjects(1));
        tests.setDescription("Сейчас такой конструктор возвращает " +
                "список QuestionConnections - использовать который крайне неудобно,");
        tests.setPublicity(true);
        tests.setImg("C:\\Users\\gaya\\IdeaProjects\\DataBaseBrainFart\\src\\main\\resources\\pictures\\diagram1.png");
        tests.setAdminId(adminDao.readAdmins(1));
        testsDao.addTests(tests);


        tests.setName("Beginner Java");
        tests.setSubjectId(subjectsDao.readSubjects(2));
        tests.setDescription(" собрать полноценный тест с текущей" +
                " реализацией получиться только с кучей дополнительных действий" +
                " и подключений к базе.");
        tests.setPublicity(true);
        tests.setImg("C:\\Users\\gaya\\IdeaProjects\\DataBaseBrainFart\\src\\main\\resources\\pictures\\diagram2.jpg");
        tests.setAdminId(adminDao.readAdmins(2));
        testsDao.addTests(tests);

/*
//***************************************************************************

        //*** не работает

        TestSession testSession = new TestSession();
        testSession.setUserId(users);
        testSession.setTestsId(tests);
        testSession.setTestResult(85);
        testSession.setSubmitDate(testSession.getSubmitDate());

        testSessionDao.addTestSession(testSession);

//***************************************************************************
//** * не работает

        TestAvailability testAvailability = new TestAvailability();
        testAvailability.setTestsId(tests);
        testAvailability.setEndDate(java.sql.Date.valueOf("2016,15,5"));
        testAvailability.setStartDate(java.sql.Date.valueOf("2016,15,5"));
        testAvailabilityDao.addTestAvailability(testAvailability);

//***************************************************************************
//** * не работает

        Questions questions = new Questions();
        questions.setImg("./pictures/diagram2.jpg");
        questions.setContent("biviviviiviviiviviviiviiviviivjdscksn adasaa akhskah skahskahs khakuhsalhsakh");
        questions.setValue(5);
        questionDao.addQuestions(questions);

//***************************************************************************
//** * не работает

        AnswerOptions answerOptions = new AnswerOptions();
        answerOptions.setQuestionsId(questions);
        answerOptions.setContent("a");
        answerOptions.setCorrectness(true);
        answerOptions.setImg("./pictures/diagram2.jpg");
        answerOptionsDao.addAnswerOptions(answerOptions);

//***************************************************************************

//** * не работает

        QuestionConnections questionConnections = new QuestionConnections();
        questionConnections.setTestsId(tests);
        questionConnections.setQuestionId(questions);
        questionConnectionsDao.addQuestionConnections(questionConnections);

//***************************************************************************
        //**         * не работает

        QuestionResults questionResults = new QuestionResults();
        questionResults.setTestSessionId(testSession);
        questionResults.setQuestionConnectionsId(questionConnections);
        questionResults.setResult(80);
        questionResultsDao.addQuestionResults(questionResults);

//***************************************************************************

*/
    }
}

/*
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

/*

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
*/

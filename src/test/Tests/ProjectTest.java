package Tests;

//import utils.Config;

import dao.*;

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
    }
}
/*
        testListAdmins(adminDao);
    }

/*
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();



        Powers powers = new Powers();
        powers.setPosition("admin");
        session.save(powers);

        Admin admins = new Admin();
        admins.setEmail("karate@mail.ru");
        admins.setPassword("jakAQkmxzQmczsajak");
        //не понятно как записать туда powers_id
        admins.setPowersId(powers);
        powers.getAdmin().add(admins);
        session.save(admins);

        session.getTransaction().commit();


  */
/*
        Powers powers = powersDao.readPowers(2);
        System.out.println(
                "id=  " + powers.getId() +
                        " Position= " + powers.getPosition());

        Powers powers = new Powers();

        powers.setPosition("admin");
        powersDao.addPowers(powers);

//***************************************************************************

        //**        работает но не коректно не читает powers_id

        Admin admins = new Admin();

        admins.setEmail("karate@mail.ru");
        admins.setPassword("jakAQkmxzQmczsajak");
        //не понятно как записать туда powers_id
        admins.setPowersId(powersDao.readPowers(1));
        powers.getAdmin().add(admins);
        adminDao.addAdmins(admins);



    }

/*
       users=  usersDao.readUser(5);
        System.out.println(
                users.getId() + " "
                        + users.getFirstName() + " "
                        + users.getSecondName() + " "
                        + users.getPhoneNumber() + " "
                        + users.getEmail());



        User users = new User();
        users.setId(1);
        usersDao.deleteUser(users);


        usersDao.deleteUser(usersDao.readUser(1));

        User users = new User();
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
        List<Admin> adminses = adminDao.getAdmins();
        for (Admin admins : adminses) {
            Powers powers = admins.getPowersId();
            System.out.println(
                    "   " + powers.getId() +
                            "   " + powers.getPosition() +
                            "   " + admins.getId() +
                            "   " + admins.getEmail() +
                            "   " + admins.getPassword());
        }
    }
}
*/
    /*
    private static void testListAnswerOptions(AnswerOptionDao answerOptionsDao) {
        List<AnswerOption> answerOptionses = answerOptionsDao.getAnswerOptions();
        for (AnswerOption answerOptions : answerOptionses) {
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

    private static void testListQuestionConnections(QuestionConnectionDao questionConnectionsDao) {
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

    private static void testListSubjects(SubjectDao subjectsDao) {
        List<Subject> subjectses = subjectsDao.getSubjects();
        for (Subject subjects : subjectses) {
            System.out.println(
                    "   " + subjects.getId() +
                            "   " + subjects.getSubject());
        }
    }

    private static void testListUsers(UserDao usersDao) {
        List<User> userses = usersDao.getUser();

        for (User users : userses) {
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
            User users = testSession.getUserId();
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

    private static void testListTests(TestDao testsDao) {
        List<Tests> testses = testsDao.getTests();
        for (Tests tests : testses) {
            Subject subjects = tests.getSubjectId();
            System.out.println(
                    "   " + subjects.getId() +
                            "   " + subjects.getSubject() +
                            "   " + tests.getId() +
                            "   " + tests.getDescription() +
                            "   " + tests.getName() +
                            "   " + tests.isPublicity());
        }
    }

    private static void testListQuestionResults(QuestionResultDao questionResultsDao) {
        List<QuestionResult> questionResultses = questionResultsDao.getQuestionResults();
        for (QuestionResult questionResults : questionResultses) {
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

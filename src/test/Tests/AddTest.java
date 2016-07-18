package Tests;

import dao.*;
import models.*;

/**
 * Created by gaya on 08.06.2016.
 */
public class AddTest {

    public static void main(String[] args) {

        Factory factory = Factory.getFactory();

        AdminDao adminDao = factory.getAdminDao();
        PowersDao powersDao = factory.getPowersDao();


        Powers powers = new Powers();
       powers.setPosition("admin");
        powersDao.addPowers(powers);


        Admins admins = new Admins();

        admins.setEmail("karate@mail.ru");
        admins.setPassword("jakAQkmxzQmczsajak");

        admins.setPowersId(powersDao.readPowers(1));
       // powers.getAdmin().add(admins);
        adminDao.addAdmins(admins);
/*
        admins.setEmail("sdsde@mail.ru");
        admins.setPassword("5412asd2asdad");
        admins.setPowersId(powersDao.readPowers(1));
        powers.getAdmin().add(admins);
*/
        //   adminDao.editAdmins(admins);


//***************************************************************************

/*
        //*** работает правильно

        User users = new User();

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

        Subject subjects = new Subject();

        subjects.setSubject("Java");
        subjectsDao.addSubjects(subjects);

        subjects.setSubject("HTML");
        subjectsDao.addSubjects(subjects);

        subjects.setSubject("CSS");
        subjectsDao.addSubjects(subjects);


//***************************************************************************


        //*** работает но не коректно не читает admin_id subject_id


        Tests tests = new Tests();

        tests.setName("Beginner Java");
        tests.setSubjectId(subjectsDao.readSubjects(1));
        tests.setDescription("Сейчас такой конструктор возвращает " +
                "список QuestionConnections - использовать который крайне неудобно,");
        tests.setPublicity(true);
        tests.setImg("C:\\User\\gaya\\IdeaProjects\\DataBaseBrainFart\\src\\main\\resources\\pictures\\diagram1.png");
        tests.setAdminId(adminDao.readAdmins(1));
        testsDao.addTests(tests);


        tests.setName("Beginner Java");
        tests.setSubjectId(subjectsDao.readSubjects(2));
        tests.setDescription(" собрать полноценный тест с текущей" +
                " реализацией получиться только с кучей дополнительных действий" +
                " и подключений к базе.");
        tests.setPublicity(true);
        tests.setImg("C:\\User\\gaya\\IdeaProjects\\DataBaseBrainFart\\src\\main\\resources\\pictures\\diagram2.jpg");
        tests.setAdminId(adminDao.readAdmins(2));
        testsDao.addTests(tests);

/*
//***************************************************************************

        //*** не работает

        TestSession testSession = new TestSession();
        testSession.setUserId(users);
        testSession.setTestsId(tests);
        testSession.setTestResult(85);
        testSession.setSubmitDate(new Date());

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

        AnswerOption answerOptions = new AnswerOption();
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

        QuestionResult questionResults = new QuestionResult();
        questionResults.setTestSessionId(testSession);
        questionResults.setQuestionConnectionsId(questionConnections);
        questionResults.setResult(80);
        questionResultsDao.addQuestionResults(questionResults);

//***************************************************************************
*/
    }
}

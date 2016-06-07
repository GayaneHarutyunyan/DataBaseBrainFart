package dao;

import dao.postgres.*;


public class Factory {
    public static Factory factory = new Factory();
    private UsersDao usersDao;
    private TestSessionDao testSessionDao;
    private TestsDao testsDao;
    private TestAvailabilityDao testAvailabilityDao;
    private SubjectsDao subjectsDao;
    private QuestionResultsDao questionResultsDao;
    private QuestionDao questionDao;
    private QuestionConnectionsDao questionConnectionsDao;
    private AnswerOptionsDao answerOptionsDao;
    private AdminDao adminDao;
    private PowersDao powersDao;


    private Factory() {

    }

    public static Factory getFactory() {
        return Factory.factory;
    }

    public UsersDao getUsersDao() {
        if (usersDao == null) usersDao = new PostgreSqlUsersDao();
        return usersDao;
    }

    public TestSessionDao getTestSessionDao() {
        if (testSessionDao == null) testSessionDao = new PostgresSqlTestSessionDao();
        return testSessionDao;
    }

    public TestsDao getTestsDao() {
        if (testsDao == null) testsDao = new PostgreSqlTestsDao();
        return testsDao;
    }

    public TestAvailabilityDao getTestAvailabilityDao() {
        if (testAvailabilityDao == null) testAvailabilityDao = new PostgreSqlTestAvailabilityDao();
        return testAvailabilityDao;
    }

    public SubjectsDao getSubjectsDao() {
        if (subjectsDao == null) subjectsDao = new PostgreSqlSubjectsDao();
        return subjectsDao;
    }

    public QuestionResultsDao getQuestionResultsDao() {
        if (questionResultsDao == null) questionResultsDao = new PostgreSqlQuestionResultsDao();
        return questionResultsDao;
    }

    public QuestionDao getQuestionDao() {
        if (questionDao == null) questionDao = new PostgreSqlQuestionDao();
        return questionDao;
    }

    public AnswerOptionsDao getAnswerOptionsDao() {
        if (answerOptionsDao == null) answerOptionsDao = new PostgreSqlAnswerOptionsDao();
        return answerOptionsDao;
    }

    public AdminDao getAdminDao() {
        if (adminDao == null) adminDao = new PosgreSqlAdminDao();
        return adminDao;
    }

    public QuestionConnectionsDao getQuestionConnectionsDao() {
        if (questionConnectionsDao == null) questionConnectionsDao = new PostgreSqlQuestionConnectionsDao();
        return questionConnectionsDao;
    }

    public PowersDao getPowersDao() {
        if (powersDao == null) powersDao = new PosgreSqlPowersDao();
        return powersDao;
    }
}

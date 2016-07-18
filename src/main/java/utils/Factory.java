package utils;

import dao.*;


public class Factory {
    public static Factory factory = new Factory();
    private UserDao userDao;
    private TestSessionDao testSessionDao;
    private TestDao testDao;
    private TestAvailabilityDao testAvailabilityDao;
    private SubjectDao subjectDao;
    private QuestionResultDao questionResultDao;
    private QuestionDao questionDao;
    private QuestionConnectionDao questionConnectionDao;
    private AnswerOptionDao answerOptionDao;
    private AdminDao adminDao;
    private RoleDao roleDao;


    private Factory() {

    }
/*
    public static Factory getFactory() {
        return Factory.factory;
    }

    public UserDao getUserDao() {
        if (userDao == null) userDao = new PostgreSqlUserDao();
        return userDao;
    }

    public TestSessionDao getTestSessionDao() {
        if (testSessionDao == null) testSessionDao = new PostgresSqlTestSessionDao();
        return testSessionDao;
    }

    public TestDao getTestDao() {
        if (testDao == null) testDao = new PostgreSqlTestDao();
        return testDao;
    }

    public TestAvailabilityDao getTestAvailabilityDao() {
        if (testAvailabilityDao == null) testAvailabilityDao = new PostgreSqlTestAvailabilityDao();
        return testAvailabilityDao;
    }

    public SubjectDao getSubjectDao() {
        if (subjectDao == null) subjectDao = new PostgreSqlSubjectDao();
        return subjectDao;
    }

    public QuestionResultDao getQuestionResultDao() {
        if (questionResultDao == null) questionResultDao = new PostgreSqlQuestionResultDao();
        return questionResultDao;
    }

    public QuestionDao getQuestionDao() {
        if (questionDao == null) questionDao = new PostgreSqlQuestionDao();
        return questionDao;
    }

    public AnswerOptionDao getAnswerOptionDao() {
        if (answerOptionDao == null) answerOptionDao = new PostgreSqlAnswerOptionDao();
        return answerOptionDao;
    }

    public AdminDao getAdminDao() {
        if (adminDao == null) adminDao = new PosgreSqlAdminDao();
        return adminDao;
    }

    public QuestionConnectionDao getQuestionConnectionDao() {
     /   if (questionConnectionDao == null) questionConnectionDao = new PostgreSqlQuestionConnectionDao();
        return questionConnectionDao;
    }

    public RoleDao getRoleDao() {
        if (roleDao == null) roleDao = new PosgreSqlRoleDao();
        return roleDao;
    }

    */
}

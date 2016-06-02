package dao;


public class DaoFactory {


/*
    private static DaoFactory daoFactory;
    private static String type;
    private String user;
    private String password;
    private String url;
    private String driver;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DaoFactory.class.getName());

    private DaoFactory() {
        loadProperties();

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            log.error("ERROR: postgresql.Driver not found!\n", e);
            return;
        }
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(DaoFactory.class.getResourceAsStream("/db.properties"));
            type = properties.getProperty("type");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            throw new NoDBPropertiesException("Can't read file", e);
        }
    }

    public static DaoFactory getInstance() {
        if (null == daoFactory) {
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }



    public  Connection getConnection() throws DaoRuntimeException {
        log.trace("Driver manager get connection");
                try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DaoRuntimeException("No connection to DB", e);
        }
    }


    public UsersDao getUsersDao() {
        return new PostgreSqlUsersDao();

    }

    public TestSessionDao getTestSessionDao() {
        return new PostgresSqlTestSessionDao();
    }

    public TestsDao getTestsDao() {
        return new PostgreSqlTestsDao();
    }

    public TestAvailabilityDao getTestAvailabilityDao() {
        return new PostgreSqlTestAvailabilityDao();
    }

    public SubjectsDao getSubjectsDao() {
        return new PostgreSqlSubjectsDao();
    }

    public QuestionResultsDao getQuestionResultsDao() {
        return new PostgreSqlQuestionResultsDao();
    }

    public QuestionDao getQuestionDao() {
        return new PostgreSqlQuestionDao();
    }

    public QuestionConnectionsDao getQuestionConnectionsDao() {
        return new PostgreSqlQuestionConnectionsDao();
    }

    public AnswerOptionsDao getAnswerOptionsDao() {
        return new PostgreSqlAnswerOptionsDao();

    }

    public AdminDao getAdminDao(String type) {
        if (type.equalsIgnoreCase("postgres")) {
            return new PosgreSqlAdminDao();
        }else {
            return new PosgreSqlAdminDao();
        }


    }
    */
}






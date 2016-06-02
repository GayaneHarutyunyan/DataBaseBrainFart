import app.Config;
import org.apache.log4j.Logger;

import java.io.IOException;


/**
 * Created by gaya on 03.06.2016.
 */
public class ConfigTest {

    private static String LOG_PROPERTIES_FILE = "./conf/log4j.properties";
    private static Logger logger = Logger.getLogger(ConfigTest.class.getName());

    public static void main(String[] args) throws IOException {

        Config config = new Config(LOG_PROPERTIES_FILE);
        config.inIt();

        //В стандартной лог конфигурации вы это сообщение не увидите
        logger.fatal("some minor, debug message ");

        logger.info(" Program run ... ");

        logger.info(" mess", new Exception());


    }
}
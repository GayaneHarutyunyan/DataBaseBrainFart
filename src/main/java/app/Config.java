package app;

import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Подключать наше сообщение с логером
 */
public class Config {
    //Будет хранить себе адрес к нашему файлу конфигурацый

    private static String logFile;
    private static Properties logProperties = new Properties();

    /**
     * Мы хотим скрить предупреждения типа static_access
     *
     * @param logFile
     */
    @SuppressWarnings("static_access")
    public Config(String logFile) {
        this.logFile = logFile;
    }

    public void inIt() {
        try {
            logProperties.load(new FileInputStream(logFile));
            PropertyConfigurator.configure(logProperties);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

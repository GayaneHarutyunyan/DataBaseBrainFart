import org.apache.log4j.Logger;


/**
 * Created by gaya on 03.06.2016.
 */
public class ConfigTest {
    private static final Logger log = Logger.getLogger(ConfigTest.class);

    public static void main(String[] args) {
        ConfigTest test=new ConfigTest();
        test.doOrder();
    }

    public void doOrder(){
        // какае-то логика
        System.out.println("Юзер заполнил анкету !");
        log.info("Это информационное сообщение!");
        addToCart();
    }

    private void addToCart() {
        // добавление товара в корзину
        System.out.println("Юзер добавлен в базу ");
        log.error("Это сообщение ошибки");
    }
}
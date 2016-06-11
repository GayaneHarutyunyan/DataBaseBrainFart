package Tests;

import models.Admins;
import models.Powers;

/**
 * Created by gaya on 09.06.2016.
 */
public class AdminUtil {
    public static Admins createAdmins() {
        Admins admins = new Admins();
        Powers powers=new Powers();
        admins.setEmail("aa@mail.ru");
        admins.setPassword("aaskjna");
        powers.setPosition("asjhdka");
        admins.setPowersId(powers);

        return admins;
    }

}

package app;

/**
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author nb
 */
public class HibernateUtil {
    @Autowired
    private static SessionFactory sessionFactory = null;

    static {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        // Create the SessionFactory from standard (hibernate.cfg.xml)
        // config file.

        sessionFactory = cfg.buildSessionFactory(builder.build());
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;

    }
}

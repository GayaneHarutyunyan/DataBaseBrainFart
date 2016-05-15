package app;

import models.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Collection;
import java.util.List;


public class Main {

    //  private  Logger logger = Logger.getInstance(Main.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.close();
/*
        Session session = sessionFactory.openSession();




        Collection<Users> userses = null;

        try {
            //Начать транзакцию
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Users.class);
            //ищет все value в калонке
            //   criteria.add(Restrictions.eq("kalonka", "value"));

            //Получает список результатов
            userses = criteria.list();
            //Применить все изменинииия в таблице
            session.getTransaction().commit();

        } catch (Exception e) {
            //откат к наччалному запису если была ошибка
            session.getTransaction().rollback();
            // logger.error("message...",e);
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();

        }

        for (Users users : userses) {
            System.out.println(users.toString());
        }
*/
    }

}



package app;

import models.Users;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.List;


public class Main {

    //  private  Logger logger = Logger.getInstance(Main.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        sessionFactory.close();

/*
        Session session = sessionFactory.openSession();


        List<Object> users = null;

        try {
            //Начать транзакцию
            session.beginTransaction();

            //    Criteria criteria = session.createCriteria(Users.class);
            //ищет все value в калонке
            //   criteria.add(Restrictions.eq("kalonka", "value"));


            SQLQuery query = session.createSQLQuery("SELECT *FROM users");
            query.addEntity(Users.class);
            users = query.list();

            //Получает список результатов
            // users = criteria.list();
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

        for (Iterator iterator = users.iterator(); iterator.hasNext(); ) {
            Users users1 = (Users) iterator.next();
            System.out.println(users1.toString());
        }
        */

    }


}



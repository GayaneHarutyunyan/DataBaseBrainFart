package app;

import model.Users;
import org.hibernate.*;
import org.hibernate.criterion.Order;

import java.util.*;


public class Main {

    //  private  Logger logger = Logger.getInstance(Main.class);

    public static void main(String[] args) {



        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.close();

        /*
        Session session = sessionFactory.openSession();

        List<Users> users = null;

        try {
            //Начать транзакцию
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Users.class);
            //ищет все value в калонке
            //добавляем критерии
          //  criteria.add(Restrictions.eq("firstName", "value"));


            //сортировка по пол. ид по убиванию
            criteria.addOrder(Order.desc("id"));

            //ищет по диапазону значений
         //   criteria.add(Restrictions.between("testSession", 7, 10));


            //Получает список результатов
            users = criteria.list();
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

        for (Users user : users) {
            System.out.println(user.toString());
        }
*/
    }
}



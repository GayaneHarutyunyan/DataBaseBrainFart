package dao.postgres;

import java.util.*;

import org.apache.log4j.Logger;
import app.HibernateUtil;
import exception.*;
import dao.*;
import model.*;
import org.hibernate.Session;


public class PostgreSqlUsersDao implements UsersDao {
    private static Logger log = Logger.getLogger(PostgreSqlUsersDao.class.getName());

    @Override
    public void addUser(Users users) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Мы начинаем транзакцию
            session.beginTransaction();
            //сохраняем юзера
            session.save(users);
            //возвращаем транзакцию и закончили
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateUser(Users users) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Мы начинаем транзакцию
            session.beginTransaction();
            //обновление юзера
            session.update(users);
/*
            Users temp = new Users();
            temp.setId(users.getId());
            temp.setFirstName(users.getFirstName());
            temp.setSecondName(users.getSecondName());
            temp.setEmail(users.getEmail());
            temp.setPhoneNumber(users.getPhoneNumber());
           session.update(temp);
           */
            //возвращаем транзакцию и закончили
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteUser(Users users) throws DaoRuntimeException {
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //Мы начинаем транзакцию
            session.beginTransaction();
            //сохраняем юзера
            session.delete(users);
            //возвращаем транзакцию и закончили
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Users readUser(long id) throws DaoRuntimeException {
        Users result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Users) session.get(Users.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<Users> getUser() throws DaoRuntimeException {
        Session session = null;
        List<Users> userses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            userses = session.createCriteria(Users.class).list();
        } finally {
            //lazy="false" чтобы не вываливалась ошибка что мы закрываем сессию не релдизавав его
            if ((session != null) && (session.isOpen())) session.close();
        }
        return userses;
    }
}
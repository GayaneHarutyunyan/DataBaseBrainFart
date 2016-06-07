package dao.postgres;


import app.HibernateUtil;
import dao.*;
import exception.*;
import model.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PostgreSqlQuestionDao implements QuestionDao {
  //  private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PostgreSqlTestsDao.class.getName());

    @Override
    public void addQuestions(Questions questions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(questions);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void deleteQuestions(Questions questions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(questions);
            session.getTransaction().commit();

        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void updateQuestions(Questions questions) throws DaoRuntimeException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(questions);
            session.getTransaction().commit();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Questions readQuestions(long id) throws DaoRuntimeException {
        Questions result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Questions) session.get(Questions.class, id);
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return result;
    }

    @Override
    public List<Questions> getQuestions() throws DaoRuntimeException {
        Session session = null;
        List<Questions>  questionses = new ArrayList<>();
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            //возвращает список всех юзеров
            questionses = session.createCriteria(Questions.class).list();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return questionses;
    }

}



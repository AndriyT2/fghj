package model;

import models.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import osHibernate.AdditionalMaterialsEntity;
import osHibernate.LectureEntity;
import osHibernate.PersonEntity;
import utility.hibernate.HibernateUtil;
import utility.utilityLog.LogFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AmySQLForServlet {


    public void addPersonSQLJSP(String lastname, String firstname, String phone, String email, String role) {
        PersonEntity person = new PersonEntity();
        person.setLastname(lastname);
        person.setFirstname(firstname);
        person.setPhone(phone);
        person.setEmail(email);
        person.setRole(role);
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(person);
        transaction.commit();
        HibernateUtil.shutdown();

    }

    public List<PersonEntity> personGetAll() {
        List<PersonEntity> personList;
       try(Session session = HibernateUtil.getSession()) {
           Query<PersonEntity> query = session.createQuery("from PersonEntity", PersonEntity.class);
           personList = query.list();
           System.out.println(personList);
       }
        return personList;
    }


    public PersonEntity personById(int idFromDB) {
        Query query;
        PersonEntity person;
        try (Session session = HibernateUtil.getSession()) {
            query = session.createQuery("from PersonEntity  where id=:personId");

            query.setParameter("personId", idFromDB);
            person = (PersonEntity) query.uniqueResult();
        }
        return person;
    }
    public List<AdditionalMaterialsEntity> lectureBefore2023() {

        Session session = HibernateUtil.getSession();
        Query<AdditionalMaterialsEntity> query = session.createQuery("SELECT a.lecture.name, count (a.id) as amCount from AdditionalMaterialsEntity a group by a.lecture.name "); //where l.lectureDate<'2023-01-01 00:00:00'
        List<AdditionalMaterialsEntity> lectureList = query.list();
        HibernateUtil.shutdown();
        return lectureList;
    }
    public LectureEntity firstLecture() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("select l.lectureId, l.description, l.lectureDate, l.lectureDate, l.name, l.creationDate, count (h.homeworkId) as hCount from LectureEntity l left join HomeworkEntity h where l.creationDate = (select max (creationDate) from LectureEntity ) group by l.lectureId order by hCount limit 1");
        LectureEntity lecture = (LectureEntity) query.uniqueResult();
        HibernateUtil.shutdown();
        return lecture;
    }

    public List<PersonEntity> studentByLastname() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from PersonEntity where role = 'student' order by lastname");
        List<PersonEntity> studentList = query.list();
        HibernateUtil.shutdown();
        return studentList;
    }

    public List<AdditionalMaterialsEntity> amType() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select  resourceType, count (additionalMaterialsId) as typeTotal from AdditionalMaterialsEntity group by resourceType");
        List<AdditionalMaterialsEntity> materialsEntityList = query.list();
        transaction.commit();
        HibernateUtil.shutdown();
        return materialsEntityList;
    }


    public List<PersonEntity> teacherByLetter() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from PersonEntity where role = 'teacher' and lastname between 'A' and  'N'");
        List<PersonEntity> personEntityList = query.list();
        HibernateUtil.shutdown();
        return personEntityList;
    }


}



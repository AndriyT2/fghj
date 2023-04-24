package model;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import os.osHibernate.AdditionalMaterialsEntity;
import os.osHibernate.PersonEntity;
import utility.hibernate.HibernateUtil;

import java.util.List;


public class AmySQLForServlet {












    public List<AdditionalMaterialsEntity> amType() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select  resourceType, count (additionalMaterialsId) as typeTotal from AdditionalMaterialsEntity group by resourceType");
        List<AdditionalMaterialsEntity> materialsEntityList = query.list();
        transaction.commit();
        HibernateUtil.shutdown();
        return materialsEntityList;
    }




    public List<PersonEntity> studentOnCourse(int countCourse) {
        List<PersonEntity> personList = null;
        Session session = HibernateUtil.getSession();

        if (countCourse == 1) {
            Query query = session.createQuery("select p.lastname, p.firstname, p.firstname, count(p.course) as courseTotal from PersonEntity p where p.role='student' group by p.id having courseTotal=1 order by p.lastname");
            personList = query.list();
        } else if (countCourse == 2) {
            Query query = session.createQuery("select p.lastname, p.firstname, p.firstname, count(p.course) as courseTotal from PersonEntity p where p.role='student' group by p.id having courseTotal=2 order by p.lastname");
            personList = query.list();
        } else {
            Query query = session.createQuery("select p.lastname, p.firstname, p.firstname, count(p.course) as courseTotal from PersonEntity p where p.role='student' group by p.id having courseTotal>=3 order by p.lastname");
            personList = query.list();
        }


        System.out.println(personList);
        return personList;
    }

}



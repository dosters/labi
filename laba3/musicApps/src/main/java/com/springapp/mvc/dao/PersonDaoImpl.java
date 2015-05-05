package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MusicEntity;
import com.springapp.mvc.domain.PersonEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Lenovo on 27.03.2015.
 */

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int add(PersonEntity person) {
        int i = 0;
        int id=-1;
        List<PersonEntity> my = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonEntity").list();
        for (PersonEntity p : my) {
            if (p.getName().equals(person.getName()) == true && p.getLastName().equals(person.getLastName()) == true) {
                i++;
            }
        }
        if (i == 0) {
            sessionFactory.getCurrentSession().saveOrUpdate(person);
        }
        List<PersonEntity> my2 = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonEntity").list();
        for (PersonEntity p : my2) {
            if (p.getName().equals(person.getName()) == true && p.getLastName().equals(person.getLastName()) == true) {
                id=p.getId();
            }
        }
        return id;
    }

    @Override
    @SuppressWarnings("unchected")
    public List<PersonEntity> list() {
        List<PersonEntity> l=sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonEntity").list();
        List<PersonEntity> f=new ArrayList<PersonEntity>();
        for(PersonEntity p:l)
        {
            if(p.getName().equals("admin")==true)
            {

            }
            else
            {
                f.add(p);
            }
        }
        return f;
    }

    @Override
    public List<PersonEntity> top() {
        List<PersonEntity> l=sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonEntity").list();
        List<PersonEntity> personEntities=new ArrayList<PersonEntity>();
        for(PersonEntity p:l)
        {
            if(p.getName().equals("admin")==true)
            {

            }
            else
            {
                personEntities.add(p);
            }
        }
        Collections.sort(personEntities, Collections.reverseOrder(new Comparator<PersonEntity>() {
        public int compare(PersonEntity o1, PersonEntity o2) {
            return o1.getName().compareTo(o2.getName());
        }}
        ));
        List<PersonEntity> tops = new ArrayList<PersonEntity>();
        for (int i = 0; i < 4; i++) {
            tops.add(personEntities.get(i));
        }
        return tops;
    }

    @Override
    public PersonEntity getPersonFromId(int id) {
        List<PersonEntity> personEntities = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonEntity").list();
        PersonEntity p=new PersonEntity();
        for(PersonEntity personEntity:personEntities)
        {
            if(personEntity.getId()==id)
            {
                p=personEntity;
            }
        }
        return p;
    }

    @Override
    public void changeId(PersonEntity personEntity) {
        List<PersonEntity> personEntities = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonEntity").list();
        for(PersonEntity p:personEntities)
        {

            if(p.getName().equals(personEntity.getName())==true && p.getLastName().equals(personEntity.getLastName())==true)
            {
                personEntity.setId(p.getId());
            }
        }
    }
}

package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PersonmusicEntity;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Repository
public class PersonMusicDaoImpl implements PersonMusicDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(PersonmusicEntity personEntity) {
        int i = 0;
        List<PersonmusicEntity> my = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PersonmusicEntity").list();
        for (PersonmusicEntity p : my) {
            if (p.getIdPerson().equals(personEntity.getIdPerson())==true && p.getIdMusic().equals(personEntity.getIdMusic())==true) {
                i++;
            }
        }
        if (i == 0) {
            SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO personmusic (idMusic, idPerson)  VALUES ("+personEntity.getIdMusic()+","+personEntity.getIdPerson()+")");
            query.executeUpdate();
        }
    }

    @Override
    public void delete(PersonmusicEntity personmusicEntity) {
                SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM personmusic WHERE idMusic="+personmusicEntity.getIdMusic()+" AND idPerson="+personmusicEntity.getIdPerson());
                query.executeUpdate();
    }

    @Override
    public void deleteId(int id) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM personmusic WHERE idMusic="+id);
        query.executeUpdate();
    }
}

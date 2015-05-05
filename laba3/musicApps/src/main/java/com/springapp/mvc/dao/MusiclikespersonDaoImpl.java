package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MusiclikedpersonEntity;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusiclikespersonDaoImpl implements MusiclikedpersonDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(int idMusic,int idPerson) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO musiclikedperson(idPerson, idMusic) VALUES ("+idPerson+","+idMusic+")");
        query.executeUpdate();
    }

    @Override
    public List<MusiclikedpersonEntity> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.MusiclikedpersonEntity").list();
    }

    @Override
    public void delete(int idMusic) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM musiclikedperson WHERE idMusic="+idMusic);
        query.executeUpdate();
    }
}

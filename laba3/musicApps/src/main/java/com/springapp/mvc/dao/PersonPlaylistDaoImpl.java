package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonplaylistEntity;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Repository
public class PersonPlaylistDaoImpl implements PersonPlaylistDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(int idPerson,int idPlaylist) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO personplaylist (idPerson, idPlaylist) VALUES ("+idPerson+","+idPlaylist+")");
        query.executeUpdate();
    }

    @Override
    public void delete(PersonplaylistEntity p) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM personplaylist WHERE idPlaylist="+p.getIdPlaylist()+" AND idPerson="+p.getIdPerson());
        query.executeUpdate();
    }

    @Override
    public void deleteID(int id) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM personplaylist WHERE idPlaylist="+id);
        query.executeUpdate();
    }
}

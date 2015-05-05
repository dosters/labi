package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PlaylistlikedpersonEntity;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 06.04.2015.
 */
@Repository
public class PlaylistlikedpersonDaoImpl implements PlaylistlikedpersonDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(int idPlaylist, int idPerson) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO playlistlikedperson(idPerson, idPlaylist) VALUES ("+idPerson+","+idPlaylist+")");
        query.executeUpdate();
    }

    @Override
    public List<PlaylistlikedpersonEntity> getall() {
        return sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PlaylistlikedpersonEntity").list();
    }

    @Override
    public void delete(int idPlaylist) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlistlikedperson WHERE idPlaylist="+idPlaylist);
        query.executeUpdate();
    }
}

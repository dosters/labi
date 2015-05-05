package com.springapp.mvc.dao;

import com.springapp.mvc.domain.PersonmusicEntity;
import com.springapp.mvc.domain.PlaylistEntity;
import com.springapp.mvc.domain.PlaylistmusicEntity;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Repository
public class PlaylistMusicDaoImpl implements PlaylistMusicDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(int idMusic, int idPlaylist) {
        int i = 0;
        PlaylistmusicEntity playlistEntity=new PlaylistmusicEntity(idPlaylist,idMusic);
        List<PlaylistmusicEntity> my = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PlaylistmusicEntity").list();
        for (PlaylistmusicEntity p : my) {
            if (p.getIdPlaylist().equals(playlistEntity.getIdPlaylist())==true && p.getIdMusic().equals(playlistEntity.getIdMusic())==true) {
                i++;
            }
        }
        if (i == 0) {
            SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("INSERT INTO playlistmusic(idMusic, idPlaylist) VALUES ("+idMusic+","+idPlaylist+")");
            query.executeUpdate();
        }

    }

    @Override
    public void delete(int idMusic, int idPlaylist) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlistmusic WHERE idPlaylist="+idPlaylist+" AND idMusic="+idMusic);
        query.executeUpdate();
    }

    @Override
    public void deleteMP(int idMusic) {
        List<PlaylistmusicEntity> my = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PlaylistmusicEntity").list();
        for (PlaylistmusicEntity p : my) {
            SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlistmusic WHERE idPlaylist="+p.getIdPlaylist()+" AND idMusic="+idMusic);
            query.executeUpdate();
            }
        }

    @Override
    public void deleteID(int idMusic) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlistmusic WHERE idMusic=" + idMusic);
        query.executeUpdate();
    }
    @Override
    public void deleteIdP(int idPlaylist) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlistmusic WHERE idPlaylist="+idPlaylist);
        query.executeUpdate();
    }
}


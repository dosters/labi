package com.springapp.mvc.dao;

import com.springapp.mvc.domain.*;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Repository
public class PlaylistDaoImpl implements PlaylistDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private PlaylistlikedpersonDao playlistlikedpersonDao;
    @Override
    public void add(PlaylistEntity playlistEntity) {

        sessionFactory.getCurrentSession().saveOrUpdate(playlistEntity);
    }

    @Transactional
    @Override
    public List<PlaylistEntity> getAll() {
        List<PlaylistEntity> playlistEntities = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PlaylistEntity").list();
        return playlistEntities;
    }

    @Transactional
    @Override
    public List<PlaylistEntity> top() {
        List<PlaylistEntity> playlistEntities = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PlaylistEntity").list();
        Collections.sort(playlistEntities, Collections.reverseOrder(new Comparator<PlaylistEntity>() {
                                                                        public int compare(PlaylistEntity o1, PlaylistEntity o2) {
                                                                            return o1.getLikes().compareTo(o2.getLikes());
                                                                        }
                                                                    }
        ));
        List<PlaylistEntity> tops = new ArrayList<PlaylistEntity>();
        for (int i = 0; i < 4; i++) {
            tops.add(playlistEntities.get(i));
        }
        return tops;
    }

    @Override
    public List<PlaylistEntity> personPlaylists(int id) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("SELECT playlist.id,playlist.name,playlist.likes FROM playlist INNER JOIN personplaylist ON personplaylist.idPlaylist=playlist.id WHERE personplaylist.idPerson="+id);
        query.addEntity(PlaylistEntity.class);
        List<PlaylistEntity> playlistEntities=new ArrayList<PlaylistEntity>();
        List playlistEntity = query.list();
        for (Iterator iterator =
             playlistEntity.iterator(); iterator.hasNext();){
            PlaylistEntity employee = (PlaylistEntity) iterator.next();
            playlistEntities.add(employee);
        }
        return playlistEntities;
    }

    @Override
    public void like(int idPlaylist,int idPerson) {
        List<PlaylistEntity> musicEntities = getAll();
        int likes = 0;
        for (PlaylistEntity m : musicEntities) {
            if (idPlaylist == m.getId()) {
                likes = m.getLikes();
            }
        }
        List<PlaylistlikedpersonEntity> playlistlikedpersonEntities = playlistlikedpersonDao.getall();
        int i = 0;
        for (PlaylistlikedpersonEntity p : playlistlikedpersonEntities) {
            if (p.getIdPlaylist() == idPlaylist && p.getIdPerson() == idPerson) {
                i++;
            }
        }
        if (i == 0) {
            likes++;
            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE playlist SET likes=" + likes + " WHERE id=" + idPlaylist);
            playlistlikedpersonDao.add(idPlaylist, idPerson);
            query.executeUpdate();
        } else
        {
            likes--;
            SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery("UPDATE playlist SET likes=" + likes + " WHERE id=" + idPlaylist);
            SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlistlikedperson WHERE idPerson="+idPerson+" AND idPlaylist="+idPlaylist);
            query.executeUpdate();
            query1.executeUpdate();
        }
    }

    @Override
    public PlaylistEntity getFromId(String name) {
        List<PlaylistEntity> playlistEntities = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.PlaylistEntity").list();
        for(PlaylistEntity p:playlistEntities)
        {
            if(p.getName().equals(name)==true)
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM playlist WHERE id="+id);
        query.executeUpdate();
    }

}

package com.springapp.mvc.dao;

import com.springapp.mvc.domain.MusicEntity;
import com.springapp.mvc.domain.MusiclikedpersonEntity;
import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PlaylistEntity;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Lenovo on 27.03.2015.
 */

@Repository
public class MusicDaoImpl implements MusicDao{
    @Autowired
    private MusiclikedpersonDao musiclikedpersonDao;
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void add(MusicEntity musicEntity) {
        int i = 0;
        List<MusicEntity> my = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.MusicEntity").list();
        for (MusicEntity p : my) {
            if (p.getName().equals(musicEntity.getName()) == true) {
                i++;
            }
        }
        if (i == 0) {
            sessionFactory.getCurrentSession().saveOrUpdate(musicEntity);
        }

    }

    @Override
    public List<MusicEntity> getAllMusic() {
        return sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.MusicEntity").list();
    }

    @Override
    public List<MusicEntity> top() {

        List<MusicEntity> musicEntities = sessionFactory.getCurrentSession().createQuery("from com.springapp.mvc.domain.MusicEntity").list();
        Collections.sort(musicEntities, Collections.reverseOrder(new Comparator<MusicEntity>() {
                    public int compare(MusicEntity o1, MusicEntity o2) {
                        return o1.getLikes().compareTo(o2.getLikes());
                    }
                }
        ));
        List<MusicEntity> tops = new ArrayList<MusicEntity>();
        for (int i = 0; i < 4; i++) {
            tops.add(musicEntities.get(i));
        }
        return tops;
    }

    @Override
    public List<MusicEntity> getMusic(int id) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select music.id,music.name,music.scr,music.likes from music inner join personmusic on personmusic.idMusic=music.id Where personmusic.idPerson="+id);
        query.addEntity(MusicEntity.class);
        List<MusicEntity> musicEntities=new ArrayList<MusicEntity>();
        List musicEntity = query.list();
        for (Iterator iterator =
             musicEntity.iterator(); iterator.hasNext();){
                MusicEntity employee = (MusicEntity) iterator.next();
                musicEntities.add(employee);
        }
        return musicEntities;
    }

    @Override
    public void like(int idMusic,int idPerson) {
        List<MusicEntity> musicEntities=getAllMusic();
        int likes=0;
        for(MusicEntity m:musicEntities)
        {
            if(idMusic==m.getId())
            {
                likes=m.getLikes();
            }
        }
        List<MusiclikedpersonEntity> musiclikedpersonEntities=musiclikedpersonDao.getAll();
        int i=0;
        for(MusiclikedpersonEntity p:musiclikedpersonEntities)
        {
            if(p.getIdMusic()==idMusic && p.getIdPerson()==idPerson)
            {
                i++;
            }
        }
        if(i==0)
        {
            likes++;
            SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("UPDATE music SET likes="+likes+" WHERE id="+idMusic);
            musiclikedpersonDao.add(idMusic,idPerson);
            query.executeUpdate();
        }
        else
        {
            likes--;
            SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("UPDATE music SET likes="+likes+" WHERE id="+idMusic);
            SQLQuery query1=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM musiclikedperson WHERE idMusic="+idMusic+" AND idPerson="+idPerson);
            query.executeUpdate();
            query1.executeUpdate();
        }
    }
    @Override
    public List<MusicEntity> playlistMusic(int idPlaylist) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select music.id,music.likes,music.name,music.scr from music inner join playlistmusic on playlistmusic.idMusic=music.id where playlistmusic.idPlaylist="+idPlaylist);
        query.addEntity(MusicEntity.class);
        List<MusicEntity> musicEntities=new ArrayList<MusicEntity>();
        List musicEntity = query.list();
        for (Iterator iterator =
             musicEntity.iterator(); iterator.hasNext();){
            MusicEntity employee = (MusicEntity) iterator.next();
            musicEntities.add(employee);
        }
        return musicEntities;
    }

    @Override
    public List<MusicEntity>search(String s) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("select music.id,music.likes,music.name,music.scr from music WHERE music.name LIKE '"+s+"%'");
        query.addEntity(MusicEntity.class);
        List<MusicEntity> musicEntities=new ArrayList<MusicEntity>();
        List musicEntity = query.list();
        for (Iterator iterator =
             musicEntity.iterator(); iterator.hasNext();){
            MusicEntity employee = (MusicEntity) iterator.next();
            musicEntities.add(employee);
        }
        return musicEntities;
    }

    @Override
    public void delete(int id) {
        SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("DELETE FROM music WHERE id="+id);
        query.executeUpdate();
    }
}


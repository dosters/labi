package com.springapp.mvc.service;

import com.springapp.mvc.dao.PlaylistDao;
import com.springapp.mvc.domain.PersonEntity;
import com.springapp.mvc.domain.PlaylistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistDao playlistDao;
    @Override
    @Transactional
    public void add(PlaylistEntity playlistEntity) {
        playlistDao.add(playlistEntity);
    }
    @Transactional
    @Override
    public List<PlaylistEntity> getAll() {
        return playlistDao.getAll();
    }
    @Transactional
    @Override
    public List<PlaylistEntity> top() {
        return playlistDao.top();
    }
    @Transactional
    @Override
    public List<PlaylistEntity> personPlaylists(int id) {
        return playlistDao.personPlaylists(id);
    }
    @Transactional
    @Override
    public void like(int idPlaylist,int idPerson) {
        playlistDao.like(idPlaylist,idPerson);
    }
@Transactional
    @Override
    public PlaylistEntity getFromId(String name) {
        return playlistDao.getFromId(name);
    }
@Transactional
    @Override
    public void delete(int id) {
         playlistDao.delete(id);
    }
}

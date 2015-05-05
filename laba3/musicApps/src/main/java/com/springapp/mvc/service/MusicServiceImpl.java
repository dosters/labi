package com.springapp.mvc.service;

import com.springapp.mvc.dao.MusicDao;
import com.springapp.mvc.domain.MusicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDao musicDao;
    @Override
    @Transactional
    public void add(MusicEntity musicEntity) {
    musicDao.add(musicEntity);
    }
    @Transactional
    @Override
    public List<MusicEntity> getAllMusic() {
        return musicDao.getAllMusic();
    }
    @Override
    @Transactional
    public List<MusicEntity> top()
    {
        return musicDao.top();
    }
    @Transactional
    @Override
    public List<MusicEntity> getMusic(int id) {
        return musicDao.getMusic(id);
    }
    @Transactional
    @Override
    public void like(int idMusic,int idPerson) {
        musicDao.like(idMusic,idPerson);
    }
    @Transactional
    @Override
    public List<MusicEntity> playlistMusic(int idPlaylist) {
        return musicDao.playlistMusic(idPlaylist);
    }
@Transactional
    @Override
    public List<MusicEntity> search(String s) {
        return musicDao.search(s);
    }
@Transactional
    @Override
    public void delete(int id) {
        musicDao.delete(id);
    }
}

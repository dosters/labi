package com.springapp.mvc.service;

import com.springapp.mvc.dao.PlaylistMusicDao;
import com.springapp.mvc.domain.PlaylistmusicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Service
public class PlaylistMusicServiceImpl implements PlaylistMusicService {
    @Autowired
    private PlaylistMusicDao playlistMusicDao;
    @Transactional
    @Override
    public void add(int idMusic, int idPlaylist) {
     playlistMusicDao.add(idMusic,idPlaylist);
    }
    @Transactional
    @Override
    public void delete(int idMusic, int idPlaylist) {
        playlistMusicDao.delete(idMusic,idPlaylist);
    }
    @Transactional
    @Override
    public void deleteMP(int idMusic) {
        playlistMusicDao.deleteMP(idMusic);
    }
    @Transactional
    @Override
    public void deleteID(int idMusic) {
        playlistMusicDao.deleteID(idMusic);
    }
@Transactional
    @Override
    public void deleteIdP(int idPlaylist) {
        playlistMusicDao.deleteIdP(idPlaylist);
    }
}

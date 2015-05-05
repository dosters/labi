package com.springapp.mvc.service;

import com.springapp.mvc.dao.PlaylistlikedpersonDao;
import com.springapp.mvc.domain.PlaylistlikedpersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 13.04.2015.
 */
public class PlaylistlikedPersonServiceImpl implements PlaylistlikedPersonService {
    @Autowired
    private PlaylistlikedpersonDao playlistlikedpersonDao;
    @Transactional
    @Override
    public void add(int idPlaylist, int idPerson) {
        playlistlikedpersonDao.add(idPlaylist,idPerson);
    }
    @Transactional
    @Override
    public List<PlaylistlikedpersonEntity> getall() {
        return playlistlikedpersonDao.getall();
    }
    @Transactional
    @Override
    public void delete(int idPlaylist) {
    playlistlikedpersonDao.delete(idPlaylist);
    }
}

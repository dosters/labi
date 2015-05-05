package com.springapp.mvc.service;

import com.springapp.mvc.dao.PersonPlaylistDao;
import com.springapp.mvc.domain.PersonplaylistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Lenovo on 28.03.2015.
 */
@Service
public class PersonPlaylistServiceImpl implements PersonPlaylistService {
    @Autowired
    private PersonPlaylistDao personPlaylistDao;
    @Transactional
    @Override
    public void add(int idPerson, int idPlaylist) {
        personPlaylistDao.add(idPerson,idPlaylist);
    }
    @Transactional
    @Override
    public void delete(PersonplaylistEntity p) {
        personPlaylistDao.delete(p);
    }
@Transactional
    @Override
    public void deleteID(int id) {
        personPlaylistDao.deleteID(id);
    }
}
